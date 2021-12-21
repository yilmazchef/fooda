package be.fooda.frontend.customer.views.product;

import be.fooda.frontend.customer.client.BasketClient;
import be.fooda.frontend.customer.client.MediaClient;
import be.fooda.frontend.customer.client.ProductClient;
import be.fooda.frontend.customer.data.dto.basket.CreateBasketRequest;
import be.fooda.frontend.customer.data.dto.basket.CreateProductRequest;
import be.fooda.frontend.customer.data.dto.basket.CreateStoreRequest;
import be.fooda.frontend.customer.data.dto.product.PriceResponse;
import be.fooda.frontend.customer.data.dto.product.ProductResponse;
import be.fooda.frontend.customer.security.AuthenticatedUser;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

@PageTitle("Fooda | Product")
@Route(value = "product", layout = MainLayout.class)
@AnonymousAllowed
public class ProductView extends VerticalLayout {

    @Getter
    private final String session = VaadinSession.getCurrent().getSession().getId();

    // LAYOUTS
    private final HorizontalLayout pagingLayout = new HorizontalLayout();
    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final VerticalLayout productListLayout = new VerticalLayout();

    @PostConstruct
    public void initStyle() {

        addClassNames("product-view", "flex", "flex-col", "h-full");

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setWidthFull();

        pagingLayout.setMargin(false);
        pagingLayout.setPadding(false);
        pagingLayout.setSpacing(false);
        pagingLayout.setWidthFull();

        searchLayout.setMargin(false);
        searchLayout.setPadding(false);
        searchLayout.setSpacing(false);
        searchLayout.setWidthFull();

        productListLayout.setMargin(false);
        productListLayout.setPadding(false);
        productListLayout.setSpacing(false);
        productListLayout.setWidthFull();

    }

    // FIXME: cognitive complexity
    public ProductView(@Autowired AuthenticatedUser authenticatedUser,
                       @Autowired ProductClient productClient, @Autowired BasketClient basketClient, @Autowired MediaClient mediaClient) {

        final var pagingInfo = new Label("Paging:");
        final var pageNo = new NumberField("Page No");
        pageNo.setValue(1.00);

        final var pageSize = new NumberField("Page Size");
        pageSize.setValue(25.00);
        pagingLayout.add(pagingInfo, pageNo, pageSize);

        final var searchField = new TextField("Search");
        final var searchButton = new Button("Search", VaadinIcon.SEARCH.create());
        searchButton.addClickListener(
                onClick -> {
                    productClient.search(
                            searchField.getValue().toLowerCase(Locale.ROOT),
                            pageNo.getValue().intValue(),
                            pageSize.getValue().intValue()
                    );
                }
        );


        final var products = productClient.findAll(pageNo.getValue().intValue(), pageSize.getValue().intValue());
        for (ProductResponse productResponse : products) {
            final var productItemLayout = new ProductItemLayout(productResponse);

            var prices = new Object() {
                BigDecimal defaultPrice = BigDecimal.ZERO;
            };
            for (PriceResponse priceResponse : productResponse.getPrices()) {
                if (priceResponse.getIsDefault()) {
                    prices.defaultPrice = priceResponse.getAmount();
                    break;
                }
            }

            productItemLayout.getAddToCartButton().addClickListener(onClick -> {
                final var basketExists = basketClient.exists(session, productResponse.getStore().getStoreId());
                if (!basketExists) {
                    basketClient.create(
                            new CreateBasketRequest()
                                    .withSession(session)
                                    .withStore(
                                            new CreateStoreRequest()
                                                    .withStoreId(productResponse.getStore().getStoreId())
                                    )
                                    .withProducts(
                                            Set.of(
                                                    new CreateProductRequest()
                                                            .withProductId(productResponse.getProductId())
                                                            .withQuantity(1.00)
                                                            .withPrice(prices.defaultPrice)
                                            )
                                    )
                    );
                } else {
                    Notification.show("Product is already in the basket! Please update quantity by visiting basket page.",
                    4000, Notification.Position.BOTTOM_CENTER).open();
                }
            });

            productListLayout.add(productItemLayout);
        }

        searchLayout.add(searchField, searchButton);

        /* add all sub layouts to the view */
        add(pagingLayout, searchLayout, productListLayout);

    }
}

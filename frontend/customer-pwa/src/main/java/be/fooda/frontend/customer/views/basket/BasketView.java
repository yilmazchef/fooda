package be.fooda.frontend.customer.views.basket;

import be.fooda.frontend.customer.client.BasketClient;
import be.fooda.frontend.customer.client.MediaClient;
import be.fooda.frontend.customer.data.dto.basket.BasketResponse;
import be.fooda.frontend.customer.data.dto.basket.ProductResponse;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Fooda | Basket")
@Route(value = "basket", layout = MainLayout.class)
@AnonymousAllowed
@Tag("basket-view")
public class BasketView extends VerticalLayout {

    // FIXME: find basket by session and increase/decrease quantity.

    private final String session = VaadinSession.getCurrent().getSession().getId();

    // BASKET_GROUPS_PER_STORE
    private final VerticalLayout basketItemGroupLayout = new VerticalLayout();

    // PRICE_INFO
    private final VerticalLayout totalPriceLayout = new VerticalLayout();

    // ACTIONS
    private final VerticalLayout actionsLayout = new VerticalLayout();


    public BasketView(@Autowired BasketClient basketClient, @Autowired MediaClient mediaClient) {

        addClassNames("basket-view", "flex", "flex-col", "h-full");

        final var basketResponseList = basketClient.findBySession(session);

        if (!basketResponseList.isEmpty()) {

            for (BasketResponse basketResponse : basketResponseList) {

                final var products = basketResponse.getProducts();
                for (ProductResponse productResponse : products) {
                    final var basketProductLayout = new BasketItemLayout(productResponse);

                    basketProductLayout.getUpdateButton().addClickListener(onClick -> {
                        Notification.show(productResponse.getTitle() + " X " + basketProductLayout.getQuantityField().getValue()).open();
                    });

                    basketItemGroupLayout.add(basketProductLayout);
                }
            }

        } else {
            Notification.show("Basket is empty", 3000, Notification.Position.BOTTOM_CENTER).open();
        }

        add(basketItemGroupLayout, totalPriceLayout, actionsLayout);
    }

}

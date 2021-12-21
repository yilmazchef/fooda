package be.fooda.frontend.customer.views.product;

import be.fooda.frontend.customer.data.dto.product.PriceResponse;
import be.fooda.frontend.customer.data.dto.product.ProductResponse;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.Getter;

import java.math.BigDecimal;

@AnonymousAllowed
public class ProductItemLayout extends VerticalLayout {

    // LAYOUTS
    private final HorizontalLayout firstRowLayout = new HorizontalLayout();
    private final VerticalLayout imageLayout = new VerticalLayout();
    private final VerticalLayout secondRowLayout = new VerticalLayout();

    @Getter
    private final Image image = new Image();
    private final VerticalLayout basketEventsLayout = new VerticalLayout();

    @Getter
    private final BigDecimalField priceField = new BigDecimalField("Price");

    @Getter
    private final Details details = new Details();

    @Getter
    private final Button addToCartButton = new Button("Add to Cart");

    public void initStyle() {

        super.setMargin(false);
        super.setPadding(false);
        super.setSpacing(false);
        super.setWidthFull();

        firstRowLayout.setMargin(false);
        firstRowLayout.setPadding(false);
        firstRowLayout.setSpacing(false);
        firstRowLayout.setWidthFull();

        image.setWidth(100.0F, Unit.PERCENTAGE);
        image.setHeight(140, Unit.PIXELS);

        imageLayout.setMargin(false);
        imageLayout.setPadding(false);
        imageLayout.setSpacing(false);
        imageLayout.setWidth(68.0F, Unit.PERCENTAGE);

        basketEventsLayout.setMargin(false);
        basketEventsLayout.setPadding(false);
        basketEventsLayout.getStyle().set("padding-left", "2%");
        basketEventsLayout.setSpacing(false);
        basketEventsLayout.setWidth(30.0F, Unit.PERCENTAGE);

        priceField.setReadOnly(true);
        priceField.setWidth(100.0F, Unit.PERCENTAGE);
        priceField.getStyle()
                .set("margin", "0")
                .set("padding", "0");

        secondRowLayout.setMargin(false);
        secondRowLayout.setPadding(false);
        secondRowLayout.setSpacing(false);
        secondRowLayout.setWidthFull();

        priceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        priceField.setPrefixComponent(VaadinIcon.EURO.create());

        details.getStyle().set("width", "100%");

        addToCartButton.setDisableOnClick(true);
        addToCartButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    }

    public ProductItemLayout(ProductResponse product) {

        initStyle();

        /* firstRowLayout */

        image.setAlt(product.getTitle());
        image.setSrc(product.getDefaultImage().getUrl());
        imageLayout.add(image);

        final var productPrices = product.getPrices();
        final var price = new Object() {
            public BigDecimal current = BigDecimal.ZERO;
        };

        for (PriceResponse productPrice : productPrices) {
            if (productPrice.getIsDefault().equals(Boolean.TRUE)) {
                price.current = productPrice.getAmount();
                break;
            }
        }

        priceField.setValue(price.current.setScale(2));
        basketEventsLayout.add(priceField, addToCartButton);

        firstRowLayout.add(imageLayout, basketEventsLayout);

        /* firstRowLayout */

        /* secondRowLayout */

        secondRowLayout.add(details);

        /* secondRowLayout */


        /* add layouts to the view */
        add(firstRowLayout, secondRowLayout);

    }

}

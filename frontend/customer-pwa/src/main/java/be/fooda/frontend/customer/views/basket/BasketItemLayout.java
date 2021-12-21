package be.fooda.frontend.customer.views.basket;

import be.fooda.frontend.customer.data.dto.basket.ProductResponse;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AnonymousAllowed
public class BasketItemLayout extends VerticalLayout {

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
    private final Paragraph taxValue = new Paragraph();
    @Getter
    private final NumberField quantityField = new NumberField();

    @Getter
    private final Details details = new Details();

    @Getter
    private final Button updateButton = new Button();

    public void initStyle() {

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setWidthFull();

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

        taxValue.setWidth(100.0F, Unit.PERCENTAGE);
        taxValue.getStyle()
                .set("margin", "0")
                .set("padding", "0");

        quantityField.setValue(1.00);
        quantityField.setWidth(100.0F, Unit.PERCENTAGE);
        quantityField.getStyle()
                .set("margin", "0")
                .set("padding", "0");

        secondRowLayout.setMargin(false);
        secondRowLayout.setPadding(false);
        secondRowLayout.setSpacing(false);
        secondRowLayout.setWidthFull();

        priceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        priceField.setPrefixComponent(VaadinIcon.EURO.create());

        details.getStyle().set("width", "100%");

    }

    public BasketItemLayout(ProductResponse product) {

        initStyle();

        /* firstRowLayout */

        image.setAlt(product.getTitle());
        image.setSrc(product.getMedia().getUrl());
        imageLayout.add(image);

        priceField.setValue(product.getPrice().setScale(2));
        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setMax(10);
        quantityField.addValueChangeListener(onQuantityChange -> {
            priceField.setValue(product.getPrice().multiply(BigDecimal.valueOf(onQuantityChange.getValue())));

            BigDecimal taxValue;
            if (priceField.getValue() == null) {
                taxValue = BigDecimal.ZERO;
            } else {
                taxValue = priceField.getValue().multiply(new BigDecimal("0.21")).setScale(2, RoundingMode.HALF_EVEN);
            }
            this.taxValue.setText("VAT 21%: €" + taxValue);
        });

        basketEventsLayout.add(quantityField, priceField, taxValue);

        firstRowLayout.add(imageLayout, basketEventsLayout);

        /* firstRowLayout */

        /* secondRowLayout */

        secondRowLayout.add(details);

        /* secondRowLayout */


        /* add layouts to the view */
        add(firstRowLayout, secondRowLayout);

    }

}

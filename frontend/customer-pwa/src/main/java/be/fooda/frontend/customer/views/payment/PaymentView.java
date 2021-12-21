package be.fooda.frontend.customer.views.payment;

import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Fooda | Payment")
@Route(value = "payment", layout = MainLayout.class)
@PermitAll
public class PaymentView extends VerticalLayout {

    public PaymentView() {

        // CSS
        addClassNames("payment-view", "flex", "flex-col", "h-full");
    }

}

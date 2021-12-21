package be.fooda.frontend.customer.views.delivery;

import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Fooda | Delivery")
@Route(value = "delivery", layout = MainLayout.class)
@PermitAll
public class DeliveryView extends VerticalLayout {

    public DeliveryView() {
       
        // CSS
        addClassNames("delivery-view", "flex", "flex-col", "h-full");
        
    }

}

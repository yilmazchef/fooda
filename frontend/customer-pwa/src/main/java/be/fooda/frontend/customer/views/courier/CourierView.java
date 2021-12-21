package be.fooda.frontend.customer.views.courier;

import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Courier")
@Route(value = "courier", layout = MainLayout.class)
@PermitAll
public class CourierView extends VerticalLayout {

    public CourierView() {

        // CSS
        addClassNames("courier-view", "flex", "flex-col", "h-full");


    }

}

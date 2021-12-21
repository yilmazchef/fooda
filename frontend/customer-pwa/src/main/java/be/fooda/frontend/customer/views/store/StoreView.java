package be.fooda.frontend.customer.views.store;

import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Fooda | Store")
@Route(value = "store", layout = MainLayout.class)
@AnonymousAllowed
public class StoreView extends VerticalLayout {

    public StoreView() {




    }

}

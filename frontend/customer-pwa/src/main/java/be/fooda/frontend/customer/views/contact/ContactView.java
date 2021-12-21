package be.fooda.frontend.customer.views.contact;

import be.fooda.frontend.customer.client.ContactClient;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;

@PageTitle("Contact")
@Route(value = "contact", layout = MainLayout.class)
@PermitAll
@Tag("contact-view")
public class ContactView extends VerticalLayout {

  public ContactView(@Autowired ContactClient contactClient) {

    // CSS
    addClassNames("contact-view", "flex", "flex-col", "h-full");



  }
}

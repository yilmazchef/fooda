package be.fooda.frontend.customer.views.customer;


import be.fooda.frontend.customer.client.CustomerClient;
import be.fooda.frontend.customer.data.dto.customer.CreateCustomerRequest;
import be.fooda.frontend.customer.security.AuthenticatedUser;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@PageTitle("Fooda | Customer")
@Route(value = "customer/create", layout = MainLayout.class) // http://localhost:8888/customer/create
@Tag("create-customer-view")
@PermitAll
public class CreateCustomerView extends VerticalLayout {

    private final CustomerLayout createCustomerLayout = new CustomerLayout();

    public CreateCustomerView(@Autowired CustomerClient customerClient, @Autowired AuthenticatedUser authenticatedUser) {

        final var oUser = authenticatedUser.get();

        if (oUser.isPresent()) {

            final var user = oUser.get();

            createCustomerLayout.getSave().setText("Create new customer.");
            createCustomerLayout.getSave().addClickListener(onClick -> {
                final var savedCustomer = customerClient.create(
                        new CreateCustomerRequest()
                                .withFirstName(createCustomerLayout.getFirstName().getValue())
                                .withFamilyName(createCustomerLayout.getLastName().getValue())
                                .withCompanyName(createCustomerLayout.getCompanyName().getValue())
                                .withDateOfBirth(
                                        createCustomerLayout.getDateOfBirth().getValue()
                                                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
                                )
                                .withTitle(createCustomerLayout.getTitle().getValue())
                                .withNote(createCustomerLayout.getNote().getValue())
                                .withUserId(Long.valueOf(user.getId()))
                );

                if (savedCustomer.isEmpty()) {
                    Notification.show("Customer could NOT be saved.").open();
                } else {

                    final var customer = savedCustomer.get();

                    Notification.show(
                            "New Customer: "
                                    .concat(customer.getFirstName())
                                    .concat(" ")
                                    .concat(customer.getFamilyName())
                                    .concat(", company: ")
                                    .concat(customer.getCompanyName()),
                            3000, Notification.Position.BOTTOM_CENTER).open();
                }

            });


            add(createCustomerLayout);
        }

    }
}

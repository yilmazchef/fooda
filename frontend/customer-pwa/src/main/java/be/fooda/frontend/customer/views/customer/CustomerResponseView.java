package be.fooda.frontend.customer.views.customer;

import be.fooda.frontend.customer.client.CustomerClient;
import be.fooda.frontend.customer.data.dto.customer.CustomerResponse;
import be.fooda.frontend.customer.data.dto.customer.UpdateCustomerRequest;
import be.fooda.frontend.customer.security.AuthenticatedUser;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.annotation.security.PermitAll;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@PageTitle("Fooda | Customer")
@Route(value = "customer", layout = MainLayout.class) // http://localhost:8888/customer/
@Tag("customer-response-view")
@PermitAll
public class CustomerResponseView extends VerticalLayout {

    // FIXME: FIND ALL CUSTOMERS BY USER_ID

    public CustomerResponseView(@Autowired CustomerClient customerClient,
            @Autowired AuthenticatedUser authenticatedUser) {

        addClassNames("customer-response-view", "flex", "flex-col", "h-full");

        final var oUser = authenticatedUser.get();

        if (oUser.isPresent()) {

            final var user = oUser.get();
            Notification.show("User ID: " + user.getId()).open();

            final var findAllResponse = customerClient.findAllByUserId(Long.valueOf(user.getId()));

            if (findAllResponse.getStatusCode() == HttpStatus.FOUND) {
                for (CustomerResponse customer : findAllResponse.getBody()) {

                    final CustomerLayout customerResponseLayout;
                    if (findAllResponse.getBody().isEmpty()) {
                        customerResponseLayout = new CustomerLayout();
                    } else {
                        customerResponseLayout = new CustomerLayout(customer);
                        customerResponseLayout.getSave().addClickListener(onClick -> {

                            final var updateRequest = new UpdateCustomerRequest()
                                    .withAddressId(customer.getCurrentAddress().getId())
                                    .withFamilyName(customerResponseLayout.getLastName().getValue())
                                    .withCompanyName(customerResponseLayout.getCompanyName().getValue())
                                    .withContactId(customer.getCurrentContact().getId())
                                    .withDateOfBirth(
                                            customerResponseLayout.getDateOfBirth().getValue()
                                                    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)))
                                    .withFirstName(customerResponseLayout.getFirstName().getValue())
                                    .withTitle(customerResponseLayout.getTitle().getValue())
                                    .withNote(customerResponseLayout.getNote().getValue())
                                    .withUserId(Long.valueOf(user.getId()));

                            final var updateResponse = customerClient.update(customer.getId(), updateRequest);

                            if (updateResponse.getStatusCode().is2xxSuccessful()) {

                                final var updatedCustomer = updateResponse.getBody();

                                if (updatedCustomer.getCompanyName().isEmpty()) {
                                    Notification.show(
                                            "Customer updated: "
                                                    .concat(updatedCustomer.getFirstName())
                                                    .concat(" ")
                                                    .concat(updatedCustomer.getFamilyName()),
                                            3000, Notification.Position.BOTTOM_CENTER).open();
                                } else {
                                    Notification.show(
                                            "Customer: "
                                                    .concat(updatedCustomer.getFirstName())
                                                    .concat(" ")
                                                    .concat(updatedCustomer.getFamilyName())
                                                    .concat(", company: ")
                                                    .concat(updatedCustomer.getCompanyName()),
                                            3000, Notification.Position.BOTTOM_CENTER).open();
                                }
                            }

                        });
                    }

                    add(customerResponseLayout);
                }
            }

        }

    }

}

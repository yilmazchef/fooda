package be.fooda.frontend.customer.views.address;

import be.fooda.frontend.customer.client.AddressClient;
import be.fooda.frontend.customer.data.dto.address.AddressResponse;
import be.fooda.frontend.customer.data.dto.address.CoordinateResponse;
import be.fooda.frontend.customer.security.AuthenticatedUser;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Fooda | Address")
@Route(value = "address", layout = MainLayout.class)
@PermitAll
@Tag("address-view")
public class AddressView extends VerticalLayout {

    // TODO: will be connected to the real REST client ..
    public AddressView(@Autowired AuthenticatedUser authenticatedUser, @Autowired AddressClient addressClient) {

        addClassNames("address-view", "flex", "flex-col", "h-full");

        final var addressList = mockResponse(authenticatedUser);

        if(!addressList.isEmpty()){

            for (AddressResponse addressResponse : addressList) {
                final var addressLayout = new AddressLayout(addressResponse);
                add(addressLayout);
            }

        } else {
            Notification.show("No address found!", 3000, Notification.Position.BOTTOM_CENTER).open();
        }

    }

    public List<AddressResponse> mockResponse(AuthenticatedUser authenticatedUser) {

        final var results = new ArrayList<AddressResponse>();

        for (int i = 0; i < 3; i++) {

            String door = String.valueOf(i);

            results.add(
                    authenticatedUser
                            .get()
                            .map(user -> new AddressResponse()
                                    .withAddressId(1L)
                                    .withUser(Long.valueOf(user.getId()))
                                    .withTitle("Home")
                                    .withDoor(door)
                                    .withHouse("82")
                                    .withStreet("Langestraat")
                                    .withMunicipality("Zele")
                                    .withPostcode("9240")
                                    .withCity("Ghent")
                                    .withRegion("East Flanders")
                                    .withCountry("Belgium")
                                    .withCountryCode("BE")
                                    .withCoordinate(
                                            new CoordinateResponse()
                                                    .withId(1L)
                                                    .withLatitude(12.360)
                                                    .withLongitude(65.321)
                                    )
                                    .withRegisteredAt("20/09/2021 11:00")
                                    .withUpdatedAt("20/09/2021 11:00")
                                    .withActive(Boolean.TRUE))
                            .orElse(new AddressResponse().withTitle("UNKNOWN"))
            );
        }

        return results;

    }
}

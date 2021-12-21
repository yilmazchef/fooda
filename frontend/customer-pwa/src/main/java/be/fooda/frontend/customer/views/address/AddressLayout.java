package be.fooda.frontend.customer.views.address;

import be.fooda.frontend.customer.data.dto.address.AddressResponse;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

import javax.annotation.security.PermitAll;

@Tag("address-layout")
@PermitAll
public class AddressLayout extends VerticalLayout {

    final FormLayout addressInfoForm = new FormLayout();

    @Getter
    final Label addressId = new Label();
    @Getter
    final TextField title = new TextField();
    @Getter
    final TextField door = new TextField();
    @Getter
    final TextField house = new TextField();
    @Getter
    final TextField street = new TextField();
    @Getter
    final TextField municipality = new TextField();
    @Getter
    final TextField city = new TextField();
    @Getter
    final TextField postcode = new TextField();
    @Getter
    final TextField region = new TextField();
    @Getter
    final TextField country = new TextField();
    @Getter
    final TextField countryCode = new TextField();
    @Getter
    final Label registry = new Label();
    @Getter
    final Label updated = new Label();

    final FormLayout coordinatesForm = new FormLayout();
    @Getter
    final TextField latitude = new TextField();
    @Getter
    final TextField longitude = new TextField();

    final HorizontalLayout actionsLayout = new HorizontalLayout();
    @Getter
    final Button save = new Button("Save");
    @Getter
    final Button clear = new Button("Clear");

    public AddressLayout(AddressResponse addressResponse) {

        addressId.setText(String.valueOf(addressResponse.getAddressId()));
        title.setValue(addressResponse.getTitle());
        door.setValue(addressResponse.getDoor());
        house.setValue(addressResponse.getHouse());
        street.setValue(addressResponse.getStreet());
        municipality.setValue(addressResponse.getMunicipality());
        postcode.setValue(addressResponse.getPostcode());
        city.setValue(addressResponse.getCity());
        region.setValue(addressResponse.getRegion());
        country.setValue(addressResponse.getCountry());
        countryCode.setValue(addressResponse.getCountryCode());
        registry.setText(addressResponse.getRegisteredAt());
        updated.setText(addressResponse.getUpdatedAt());

        addressInfoForm.addFormItem(addressId, "Address ID");
        addressInfoForm.addFormItem(title, "Title");
        addressInfoForm.addFormItem(door, "Door");
        addressInfoForm.addFormItem(house, "House");
        addressInfoForm.addFormItem(street, "Street");
        addressInfoForm.addFormItem(municipality, "Municipality");
        addressInfoForm.addFormItem(postcode, "Postcode");
        addressInfoForm.addFormItem(city, "City");
        addressInfoForm.addFormItem(region, "Region");
        addressInfoForm.addFormItem(country, "Country");
        addressInfoForm.addFormItem(countryCode, "Country Code");
        addressInfoForm.addFormItem(registry, "Registered");
        addressInfoForm.addFormItem(updated, "Updated");

        coordinatesForm.addFormItem(longitude, "Longitude");
        coordinatesForm.addFormItem(latitude, "Latitude");

        actionsLayout.add(save, clear);

        add(addressInfoForm, coordinatesForm, actionsLayout);

    }


}

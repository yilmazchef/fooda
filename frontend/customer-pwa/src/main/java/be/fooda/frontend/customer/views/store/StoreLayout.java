package be.fooda.frontend.customer.views.store;

import be.fooda.frontend.customer.data.dto.basket.StoreResponse;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.Getter;

@Tag("store-layout")
@AnonymousAllowed
public class StoreLayout extends VerticalLayout {

    private final FormLayout storeInfoForm = new FormLayout();

    @Getter
    final Label storeId = new Label();
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

    public StoreLayout(StoreResponse storeResponse) {

        storeId.setText(String.valueOf(storeResponse.getStoreId()));
//        title.setValue(storeResponse.getTitle());
//        door.setValue(storeResponse.getDoor());
//        house.setValue(storeResponse.getHouse());
//        street.setValue(storeResponse.getStreet());
//        municipality.setValue(storeResponse.getMunicipality());
        postcode.setValue(storeResponse.getPostcode());
//        city.setValue(storeResponse.getCity());
//        region.setValue(storeResponse.getRegion());
//        country.setValue(storeResponse.getCountry());
//        countryCode.setValue(storeResponse.getCountryCode());
//        registry.setText(storeResponse.getRegisteredAt());
//        updated.setText(storeResponse.getUpdatedAt());

        storeInfoForm.addFormItem(storeId, "Store ID");
        storeInfoForm.addFormItem(title, "Title");
        storeInfoForm.addFormItem(door, "Door");
        storeInfoForm.addFormItem(house, "House");
        storeInfoForm.addFormItem(street, "Street");
        storeInfoForm.addFormItem(municipality, "Municipality");
        storeInfoForm.addFormItem(postcode, "Postcode");
        storeInfoForm.addFormItem(city, "City");
        storeInfoForm.addFormItem(region, "Region");
        storeInfoForm.addFormItem(country, "Country");
        storeInfoForm.addFormItem(countryCode, "Country Code");
        storeInfoForm.addFormItem(registry, "Registered");
        storeInfoForm.addFormItem(updated, "Updated");

        coordinatesForm.addFormItem(longitude, "Longitude");
        coordinatesForm.addFormItem(latitude, "Latitude");

        actionsLayout.add(save, clear);

        add(storeInfoForm, coordinatesForm, actionsLayout);

    }


}

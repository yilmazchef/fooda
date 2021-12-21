package be.fooda.frontend.customer.views.customer;

import be.fooda.frontend.customer.data.dto.customer.CustomerResponse;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

import javax.annotation.security.PermitAll;
import java.time.LocalDate;
import java.util.Objects;

@Tag("customer-layout")
@PermitAll
public class CustomerLayout extends VerticalLayout {

    private final FormLayout customerForm = new FormLayout();

    @Getter
    private final TextField title = new TextField();
    @Getter
    private final TextField firstName = new TextField();
    @Getter
    private final TextField lastName = new TextField();
    @Getter
    private final TextField companyName = new TextField();
    @Getter
    private final DatePicker dateOfBirth = new DatePicker();
    @Getter
    private final TextField note = new TextField();

    @Getter
    private final Button save = new Button();
    @Getter
    private final Button clear = new Button();

    public CustomerLayout(CustomerResponse customerResponse) {

        title.setValue(Objects.requireNonNull(customerResponse.getTitle()));
        firstName.setValue(Objects.requireNonNull(customerResponse.getFirstName()));
        lastName.setValue(Objects.requireNonNull(customerResponse.getFamilyName()));
        companyName.setValue(Objects.requireNonNull(customerResponse.getCompanyName()));
        dateOfBirth.setValue(Objects.requireNonNull(LocalDate.parse(customerResponse.getDateOfBirth())));
        note.setValue(Objects.requireNonNull(customerResponse.getNote()));

        clear.addClickListener(onClick -> {
            firstName.setValue("");
            lastName.setValue("");
            lastName.setValue("");
            companyName.setValue("");
            dateOfBirth.setValue(LocalDate.now());
            note.setValue("");
        });

        customerForm.addFormItem(title, "Title");
        customerForm.addFormItem(firstName, "First Name");
        customerForm.addFormItem(lastName, "Last Name");
        customerForm.addFormItem(companyName, "Company Name");
        customerForm.addFormItem(dateOfBirth, "Date of Birth");
        customerForm.addFormItem(note, "Note");

        customerForm.addFormItem(save, "save");
        customerForm.addFormItem(clear, "clear");

        add(customerForm);

    }

    public CustomerLayout() {
        add("NO CUSTOMER FOUND");
    }
}

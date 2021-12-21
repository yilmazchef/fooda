package be.fooda.frontend.user.views.user;

import be.fooda.frontend.customer.data.entity.User;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

import javax.annotation.security.PermitAll;

@Tag("user-layout")
@PermitAll
public class UserLayout extends VerticalLayout {

    private final FormLayout userForm = new FormLayout();

    @Getter
    private final TextField firstName = new TextField();
    @Getter
    private final TextField lastName = new TextField();
    @Getter
    private final EmailField email = new EmailField();
    @Getter
    private final TextField phone = new TextField();
    @Getter
    private final PasswordField password = new PasswordField();
    @Getter
    private final Button save = new Button();
    @Getter
    private final Button clear = new Button();

    public UserLayout(User user) {

        firstName.setValue(user.getName().split(",")[0]);
        lastName.setValue(user.getName().split(",")[1]);
        if (user.getUsername().contains("@")) {
            email.setValue(user.getUsername());
        } else if(user.getUsername().startsWith("+") || user.getUsername().startsWith("0")){
            phone.setValue(user.getUsername());
        }

        clear.addClickListener(onClick -> {
            firstName.setValue("");
            lastName.setValue("");
            email.setValue("");
            phone.setValue("+324XXXXXXXX");
            password.setValue("");
        });

        userForm.addFormItem(firstName, "firstName");
        userForm.addFormItem(lastName, "lastName");
        userForm.addFormItem(email, "email");
        userForm.addFormItem(phone, "phone");
        userForm.addFormItem(password, "password");
        userForm.addFormItem(save, "save");
        userForm.addFormItem(clear, "clear");

        add(userForm);

    }

    public UserLayout() {
        add("NO USER FOUND");
    }
}

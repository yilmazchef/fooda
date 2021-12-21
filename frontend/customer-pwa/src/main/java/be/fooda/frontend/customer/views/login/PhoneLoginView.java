package be.fooda.frontend.customer.views.login;

import be.fooda.frontend.customer.data.service.UserService;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Fooda | Phone Login")
@Route(value = "login/phone")
@AnonymousAllowed
public class PhoneLoginView extends LoginOverlay {

    private final UserService userService;

    public PhoneLoginView(@Autowired UserService userService) {

        this.userService = userService;

        // setAction("login");

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Fooda Login with SMS");
        i18n.getHeader().setDescription("Login using SMS validation code.");
        i18n.getForm().setUsername("Phone Number");
        i18n.getForm().setPassword("Validation Code");
        i18n.setAdditionalInformation(null);
        setI18n(i18n);

        addLoginListener(loginEvent());

        setForgotPasswordButtonVisible(false);
        setOpened(true);
    }

    // TODO: add SMS login via Twilio 
    private ComponentEventListener<LoginEvent> loginEvent(){
        return onLogin -> {
            final String phoneNumber = onLogin.getUsername();
            final String code = onLogin.getPassword();

            final var user = userService.findByPhone(phoneNumber);

            if(user.isPresent()){
                Notification.show("Logged in with " + phoneNumber + " and code " + code);
            } else {
                userService.createPhoneUser(phoneNumber, code);
                Notification.show("New phone user is created with " + phoneNumber);
            }

        };
    }

}

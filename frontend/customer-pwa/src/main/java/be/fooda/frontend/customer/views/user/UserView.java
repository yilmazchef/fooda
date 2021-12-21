package be.fooda.frontend.customer.views.user;

import be.fooda.frontend.customer.data.service.UserRepository;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;

@PageTitle("Fooda | User")
@Route(value = "user", layout = MainLayout.class) // http://localhost:8888/user/
@Tag("user-view")
@PermitAll
public class UserView extends VerticalLayout {

    // firstName, lastName, email, phone, password, roles

    public UserView(@Autowired UserRepository userRepository) {

        addClassNames("user-view", "flex", "flex-col", "h-full");



    }


}

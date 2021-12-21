package be.fooda.frontend.customer.views.welcome;

import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.Getter;

@PageTitle("Fooda | Welcome")
@Route(value = "welcome", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@AnonymousAllowed
@Tag("welcome-view")
public class WelcomeView extends VerticalLayout {

    @Getter
    private final String session = VaadinSession.getCurrent().getSession().getId();

    public WelcomeView() {

        addClassNames("welcome-view", "flex", "flex-col", "h-full", "items-center", "justify-between");

        final var logo = new Image("images/logo.png", "Fooda Logo");
        logo.getStyle()
                .set("width", "25vw")
                .set("height", "auto");
        add(logo);

        Notification.show("User Session: " + session, 10_000, Notification.Position.TOP_CENTER).open();

    }


}

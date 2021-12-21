package be.fooda.frontend.customer.views.hello;

import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Fooda | Hello")
@Tag("hello-view")
@Route(value = "hello", layout = MainLayout.class)
@AnonymousAllowed
public class HelloView extends VerticalLayout {

  private final TextField firstInput = new TextField();
  private final Button helloButton = new Button();

  public HelloView() {
    // CSS
    addClassNames("hello-view", "flex", "flex-col", "h-full");

    helloButton.addClickListener(
      onClick -> {
        Notification.show(firstInput.getValue()).open();
      }
    );

    add(firstInput, helloButton);
  }
}

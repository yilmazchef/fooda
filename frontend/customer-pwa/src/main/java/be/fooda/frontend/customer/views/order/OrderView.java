package be.fooda.frontend.customer.views.order;

import be.fooda.frontend.customer.client.OrderClient;
import be.fooda.frontend.customer.data.dto.order.OrderResponse;
import be.fooda.frontend.customer.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;

@PageTitle("Fooda | Order")
@Route(value = "order", layout = MainLayout.class)
@PermitAll
@Tag("order-view")
public class OrderView extends VerticalLayout {

    private final VerticalLayout orderItemsLayout = new VerticalLayout();

    public OrderView(@Autowired OrderClient orderClient) {

        // CSS
        addClassNames("order-view", "flex", "flex-col", "h-full");

        final var orderResponseList = orderClient.findAll(1, 25);

        if (!orderResponseList.isEmpty()) {

            for (OrderResponse orderResponse : orderResponseList) {
                final var orderItemLayout = new OrderItemLayout(orderResponse);
                orderItemsLayout.add(orderItemLayout);
            }

        }

    }

}


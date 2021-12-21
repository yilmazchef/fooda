package be.fooda.frontend.customer.views.order;

import be.fooda.frontend.customer.data.dto.order.OrderResponse;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import javax.annotation.security.PermitAll;

@Tag("order-item-layout")
@PermitAll
public class OrderItemLayout extends VerticalLayout {
    
    public OrderItemLayout(OrderResponse response){



    }

}

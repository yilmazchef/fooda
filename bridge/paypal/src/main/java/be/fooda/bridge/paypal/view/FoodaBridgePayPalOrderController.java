package be.fooda.bridge.paypal.view;

import be.fooda.bridge.paypal.model.access.request.FoodaBridgePayPalAccessReq;
import be.fooda.bridge.paypal.model.access.response.FoodaBridgePayPalAccessRes;
import be.fooda.bridge.paypal.model.order.request.FoodaBridgePayPalOrderReq;
import be.fooda.bridge.paypal.model.order.response.FoodaBridgePayPalOrderRes;
import be.fooda.bridge.paypal.service.FoodaBridgePayPalAccessService;
import be.fooda.bridge.paypal.service.FoodaBridgePayPalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bridge/paypal/order")
public class FoodaBridgePayPalOrderController {

    @Autowired
    private FoodaBridgePayPalOrderService<FoodaBridgePayPalOrderReq, FoodaBridgePayPalOrderRes> orderService;

    @PostMapping("add")
    public ResponseEntity<FoodaBridgePayPalOrderRes> apiBridgePayPalOrderAdd(@RequestBody final FoodaBridgePayPalOrderReq req) {
        final FoodaBridgePayPalOrderRes createdOrder = orderService.add(req);
        return createdOrder != null ?
                new ResponseEntity<>(createdOrder, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

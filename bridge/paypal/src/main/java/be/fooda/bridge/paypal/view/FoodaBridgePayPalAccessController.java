package be.fooda.bridge.paypal.view;

import be.fooda.bridge.paypal.model.access.request.FoodaBridgePayPalAccessReq;
import be.fooda.bridge.paypal.model.access.response.FoodaBridgePayPalAccessRes;
import be.fooda.bridge.paypal.service.FoodaBridgePayPalAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bridge/paypal/")
public class FoodaBridgePayPalAccessController {

    @Autowired
    private FoodaBridgePayPalAccessService<FoodaBridgePayPalAccessReq, FoodaBridgePayPalAccessRes> accessService;

    @PostMapping("generateToken/")
    public ResponseEntity<FoodaBridgePayPalAccessRes> apiBridgePayPalGenerateToken() {
        final FoodaBridgePayPalAccessRes createdToken = accessService.generateToken();
        return createdToken != null ?
                new ResponseEntity<>(createdToken, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

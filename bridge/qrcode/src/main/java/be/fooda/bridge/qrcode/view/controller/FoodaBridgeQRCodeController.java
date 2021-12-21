package be.fooda.bridge.qrcode.view.controller;

import be.fooda.bridge.qrcode.model.request.FoodaBridgeQRCodeReq;
import be.fooda.bridge.qrcode.model.response.FoodaBridgeQRCodeRes;
import be.fooda.bridge.qrcode.service.FoodaBridgeQRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bridge/qrcode")
public class FoodaBridgeQRCodeController {

    @Autowired
    private FoodaBridgeQRCodeService<FoodaBridgeQRCodeReq, FoodaBridgeQRCodeRes> qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<FoodaBridgeQRCodeRes> apiBridgeQRCodeGenerate(@RequestBody final FoodaBridgeQRCodeReq request) {
        final FoodaBridgeQRCodeRes generatedQRCode = qrCodeService.generate(request);
        return generatedQRCode != null ?
                new ResponseEntity<>(generatedQRCode, HttpStatus.ACCEPTED) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

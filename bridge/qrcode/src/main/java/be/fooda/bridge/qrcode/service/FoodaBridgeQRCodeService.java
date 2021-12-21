package be.fooda.bridge.qrcode.service;

public interface FoodaBridgeQRCodeService<REQ, RES> {

    RES generate(REQ req);
}

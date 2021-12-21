package be.fooda.bridge.paypal.service;

public interface FoodaBridgePayPalAccessService<REQ, RES> {
    RES generateToken();
}

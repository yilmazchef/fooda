package be.fooda.bridge.paypal.service;

public interface FoodaBridgePayPalOrderService<REQ, RES> {

    RES getOne(final String id);

    RES add(REQ req);

    RES edit(final String id);

    RES remove(final String id);

    RES authorize();

    RES capture();
}

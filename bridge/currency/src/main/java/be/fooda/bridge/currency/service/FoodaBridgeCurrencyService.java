package be.fooda.bridge.currency.service;

import java.util.List;

public interface FoodaBridgeCurrencyService<RES> {

    RES getAll(final String base);

    RES getSpecific(final String base, List<String> rateCodes);
}

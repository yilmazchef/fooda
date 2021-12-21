package be.fooda.bridge.currency.view.controller;

import be.fooda.bridge.currency.model.response.FoodaBridgeCurrencyRes;
import be.fooda.bridge.currency.service.FoodaBridgeCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bridge/currency")
public class FoodaBridgeCurrencyController {

    @Autowired
    private FoodaBridgeCurrencyService<FoodaBridgeCurrencyRes> currencyService;

    @GetMapping("/getSpecific")
    public ResponseEntity<FoodaBridgeCurrencyRes> apiBridgeCurrencyGetSpecific(@RequestParam final String base, @RequestParam final List<String> rates) {
        final FoodaBridgeCurrencyRes currencyRes = currencyService.getSpecific(base, rates);
        return currencyRes != null ?
                new ResponseEntity<>(currencyRes, HttpStatus.ACCEPTED) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAll")
    public ResponseEntity<FoodaBridgeCurrencyRes> apiBridgeCurrencyGetAll(@RequestParam final String base) {
        final FoodaBridgeCurrencyRes currencyRes = currencyService.getAll(base);
        return currencyRes != null ?
                new ResponseEntity<>(currencyRes, HttpStatus.ACCEPTED) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

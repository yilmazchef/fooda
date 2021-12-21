package be.fooda.bridge.currency.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class FoodaBridgeCurrencyRatesRes {

    @JsonProperty("HKD")
    private Double hkd;

    @JsonProperty("ISK")
    private Double isk;

    @JsonProperty("DKK")
    private Double dkk;

    @JsonProperty("CAD")
    private Double cad;

    @JsonProperty("USD")
    private Double usd;

    @JsonProperty("MYR")
    private Double myr;

    @JsonProperty("BGN")
    private Double bgn;

    @JsonProperty("NOK")
    private Double nok;

    @JsonProperty("RON")
    private Double ron;

    @JsonProperty("SGD")
    private Double sgd;

    @JsonProperty("CZK")
    private Double czk;

    @JsonProperty("SEK")
    private Double sek;

    @JsonProperty("NZD")
    private Double nzd;

    @JsonProperty("BRL")
    private Double brl;

    @JsonProperty("HRK")
    private Double hrk;

    @JsonProperty("CHF")
    private Double chf;

    @JsonProperty("MXN")
    private Double mxn;

    @JsonProperty("ZAR")
    private Double zar;

    @JsonProperty("INR")
    private Double inr;

    @JsonProperty("THB")
    private Double thb;

    @JsonProperty("CNY")
    private Double cny;

    @JsonProperty("AUD")
    private Double aud;

    @JsonProperty("ILS")
    private Double ils;

    @JsonProperty("KRW")
    private Double krw;

    @JsonProperty("JPY")
    private Double jpy;

    @JsonProperty("PLN")
    private Double pln;

    @JsonProperty("GBP")
    private Double gbp;

    @JsonProperty("IDR")
    private Double idr;

    @JsonProperty("HUF")
    private Double huf;

    @JsonProperty("PHP")
    private Double php;

    @JsonProperty("TRY")
    private Double jsonMemberTry;

    @JsonProperty("RUB")
    private Double rub;
}
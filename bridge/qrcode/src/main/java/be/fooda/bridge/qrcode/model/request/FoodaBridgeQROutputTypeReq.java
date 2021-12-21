package be.fooda.bridge.qrcode.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodaBridgeQROutputTypeReq {
    PNG,
    SVG,
    PDF
}

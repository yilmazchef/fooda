package be.fooda.bridge.qrcode.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class FoodaBridgeQRCodeReq {

    // https://qrtag.net/api/qr(_transparent)(_[size]).[png|svg](?url=[URL])

    private Boolean isTransparent;
    private Integer width;
    private Integer height;
    @NonNull
    private FoodaBridgeQROutputTypeReq outputType;
    @NonNull
    private String redirectUrl;
}

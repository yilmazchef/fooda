package be.fooda.bridge.qrcode.model.response;

import be.fooda.bridge.qrcode.model.request.FoodaBridgeQROutputTypeReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodaBridgeQRCodeRes {

    private FoodaBridgeQROutputTypeRes outputType;
    private String redirectUrl;
    private byte[] data;
}

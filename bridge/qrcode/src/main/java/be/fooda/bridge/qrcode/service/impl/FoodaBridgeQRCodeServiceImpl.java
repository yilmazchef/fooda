package be.fooda.bridge.qrcode.service.impl;

import be.fooda.bridge.qrcode.model.request.FoodaBridgeQRCodeReq;
import be.fooda.bridge.qrcode.model.response.FoodaBridgeQRCodeRes;
import be.fooda.bridge.qrcode.model.response.FoodaBridgeQROutputTypeRes;
import be.fooda.bridge.qrcode.service.FoodaBridgeQRCodeService;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodaBridgeQRCodeServiceImpl implements FoodaBridgeQRCodeService<FoodaBridgeQRCodeReq, FoodaBridgeQRCodeRes> {


    @Autowired
    private OkHttpClient client;

    @SneakyThrows
    @Override
    public FoodaBridgeQRCodeRes generate(FoodaBridgeQRCodeReq req) {
        Request request = new Request.Builder()
                .url("http://api.qrserver.com/v1/create-qr-code/?data="
                        + req.getRedirectUrl()
                        + "&size=" + req.getWidth() + "x" + req.getHeight())
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        return new FoodaBridgeQRCodeRes(
                FoodaBridgeQROutputTypeRes.valueOf(req.getOutputType().name()),
                req.getRedirectUrl(),
                response.body().bytes()
        );
    }
}

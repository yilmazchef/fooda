package be.fooda.backend.media.view.controller;

import be.fooda.backend.media.model.dto.CreateBarcodeRequest;
import be.fooda.backend.media.model.http.HttpEndpoints;
import be.fooda.backend.media.model.http.HttpFailureMassages;
import lombok.RequiredArgsConstructor;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Lombok
@RequiredArgsConstructor
// Spring
@RestController
@RequestMapping("/api/v1/media/barcode") // https://www.fooda.be/api/v1/media/barcode
public class BarcodeController {

    // QR_CODE - MATRIX_BARCODE
    @PostMapping(HttpEndpoints.POST_GENERATE_BARCODE)
    public ResponseEntity<byte[]> generateQR(@RequestBody @Valid @NotNull CreateBarcodeRequest request) {
        try (ByteArrayOutputStream bos = QRCode
                .from(request.getText())
                .withSize(request.getWidth(), request.getHeight())
                .stream()) {
            
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(bos.toByteArray());
                
        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMassages.BARCODE_COULD_NOT_BE_CREATED.getDescription());
        }
    }


}

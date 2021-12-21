package be.fooda.backend.media.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource NOT found..");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

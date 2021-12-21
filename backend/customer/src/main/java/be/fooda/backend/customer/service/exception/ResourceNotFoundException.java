package be.fooda.backend.customer.service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource NOT found..");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

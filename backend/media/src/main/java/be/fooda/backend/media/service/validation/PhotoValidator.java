package be.fooda.backend.media.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhotoValidator implements ConstraintValidator<Photo, String> {

    private static final String
            IMAGE_REGEX = "([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$)";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.isEmpty()
                && value.matches(IMAGE_REGEX)
                && value.length() >1
                && value.length()<=4;
    }
}

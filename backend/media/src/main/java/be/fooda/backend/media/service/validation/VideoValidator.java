package be.fooda.backend.media.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VideoValidator implements ConstraintValidator<Video, String> {

    private static final String VIDEO_EXPRESSION="";

    @Override
    public boolean isValid(String path, ConstraintValidatorContext context) {
        return true;

    }
}

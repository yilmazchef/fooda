package be.fooda.backend.media.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VectorValidator implements ConstraintValidator<Vector, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return true;
    }
}

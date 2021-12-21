package be.fooda.backend.media.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhotoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Photo {
    String message() default "Invalid IMAGE extension";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
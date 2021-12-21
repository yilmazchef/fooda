package be.fooda.backend.media.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VideoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Video {
    String message() default "Invalid Video extension";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

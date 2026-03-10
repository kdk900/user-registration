package com.facelesscoder.user_registration.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author KK
 * @created 10/03/2026 - 19:45
 * @project user-registration
 */

@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimezoneValidator.class)
@Documented
public @interface ValidTimeZone {
    String message() default  "Invalid time zone ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

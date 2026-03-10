package com.facelesscoder.user_registration.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.ZoneId;

/**
 * @author KK
 * @created 10/03/2026 - 19:39
 * @project user-registration
 */
public class TimezoneValidator implements ConstraintValidator<ValidTimeZone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            // Let @NotNull or @NotBlank handle null/blank values, this annotation will not mandate the field but just make sure if present it should be valid one
            return true;
        }
        try {
            // ZoneId.of(value) will throw a DateTimeException for an invalid ID
            ZoneId.of(value);
            return true;
        } catch (DateTimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid timezone");
        }
    }
}

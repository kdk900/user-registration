package com.facelesscoder.user_registration.dto;

/**
 * @author KK
 * @created 10/03/2026 - 19:01
 * @project user-registration
 */

import com.facelesscoder.user_registration.entity.User;
import com.facelesscoder.user_registration.validation.ValidTimeZone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record RegisterUserRequestDto(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]{1,100}$")
        String firstName,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]{1,100}$")
        String lastName,

        @Email @NotBlank String emailId,

        User.Role role, // "CUSTOMER" OR "AGENT"

        @Valid
        @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$")
        @NotBlank String dob,

        @Size(min = 0, max = 10)
        @Pattern(regexp = "^[1-9][0-9]{9}$", message = "Mobile number must be 10 digits, cannot start with 0")
        String phoneNumber,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9, ]*$")
        String addressLine1,

        @Pattern(regexp = "^[a-zA-Z0-9, ]*$")
        String addressLine2,

        @Pattern(regexp = "^[a-zA-Z0-9, ]*$")
        String addressLine3,

        @NotNull
                @Min(10000)
                @Max(999999)
        Integer zipcode,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z ]*$")
        String city,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z ]*$")
        String state,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z ]*$")
        String country,

        @ValidTimeZone
        String timezone,

        @Size(min = 0, max = 150)
        @Pattern(regexp = "^[a-zA-Z0-9, ]*$")
        String skill,

        @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]$", message = "Invalid time format (HH:mm)")
        String workingHoursStart,

        @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]$", message = "Invalid time format (HH:mm)")
        String workingHoursEnd
) {

}

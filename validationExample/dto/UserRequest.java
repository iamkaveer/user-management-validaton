package com.validation.validationExample.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "userName should not be blank")
    private String userName;
    @NotBlank(message = "email should not be blank")
    @Email(message = "invalid email address")
    private String email;
    @NotNull(message = "Date of birth is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth should be in the format YYYY-MM-DD")
    private String dateOfBirth;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Phone number should be 12 digits with first 2 digits as country code")
    private String mobile;
}

package com.project.cybershield.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO {

    @NotBlank(message = "Full name is required")
    @Length(max = 255)
    private String fullName;

    @NotBlank(message = "Password is required")
    @Length(max = 255)
    private String password;

    @NotBlank(message = "Phone number is required")
    @Length(max = 14)
    private String phoneNumber;

    @NotBlank(message = "Security question is required")
    private String securityQuestion;

    @NotBlank(message = "Answer to security question is required")
    @Length(max = 255)
    private String answer;
}

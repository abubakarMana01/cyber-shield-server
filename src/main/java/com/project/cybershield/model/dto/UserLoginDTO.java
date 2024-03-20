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
public class UserLoginDTO {

    @NotBlank(message = "Password is required")
    @Length(max = 255)
    private String password;

    @NotBlank(message = "Phone number is required")
    @Length(max = 255)
    private String phoneNumber;
}

package com.project.cybershield.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SecurityQuestionRequestDTO {

    @NotBlank(message = "Answer is required")
    @Length(max = 255)
    private String answer;

    @NotBlank(message = "Phone number is required")
    @Length(max = 255)
    private String phoneNumber;
}

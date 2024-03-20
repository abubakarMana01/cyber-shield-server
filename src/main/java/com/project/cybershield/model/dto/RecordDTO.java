package com.project.cybershield.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {

    private Long id;

    @NotBlank(message = "Password is required")
    @Length(max = 255)
    private String password;

    @Length(max = 255)
    private String link;

    @NotBlank(message = "Name is required")
    @Length(max = 255)
    private String name;

    @NotBlank(message = "User identifier is required")
    @Length(max = 255)
    private String userIdentifier;
}

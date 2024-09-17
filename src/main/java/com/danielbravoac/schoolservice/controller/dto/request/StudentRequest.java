package com.danielbravoac.schoolservice.controller.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotBlank
    @Size(min = 3, max = 100)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 100)
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^\\d{8}$", message = "DNI debe contener exactamente 8 dígitos numéricos")
    private String dni;
    @NotNull
    @Min(value = 1)
    @Max(value = 120)
    private Byte age;
}

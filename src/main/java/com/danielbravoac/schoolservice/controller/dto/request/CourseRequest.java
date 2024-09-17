package com.danielbravoac.schoolservice.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotBlank
    @Size(min = 2, max = 200)
    private String name;
    @NotBlank
    @Size(min = 2, max = 20)
    private String acronym;
}

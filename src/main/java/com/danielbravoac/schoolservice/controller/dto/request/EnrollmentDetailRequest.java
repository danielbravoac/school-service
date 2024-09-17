package com.danielbravoac.schoolservice.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetailRequest {
    private Integer idEnrollmentDetail;
    @JsonBackReference
    private EnrollmentRequest enrollment;
    @NotNull
    @Min(value = 1)
    private Integer idCourse;
    @NotBlank
    @Size(max = 20, min = 1)
    private String classroom;
}

package com.danielbravoac.schoolservice.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {
    private Integer idEnrollment;
    @NotNull
    @Min(value = 1)
    private Integer idStudent;
    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailRequest> details;
}

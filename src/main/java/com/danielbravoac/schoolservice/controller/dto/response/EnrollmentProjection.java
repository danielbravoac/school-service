package com.danielbravoac.schoolservice.controller.dto.response;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface EnrollmentProjection {
    LocalDateTime getEnrollmentDate();

    @Value("#{target.student.firstName+' '+target.student.lastName}")
    String getStudentFullName();

    List<EnrollmentDetailProjection> getDetails();
}

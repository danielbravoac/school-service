package com.danielbravoac.schoolservice.controller.dto.response;

import org.springframework.beans.factory.annotation.Value;

public interface EnrollmentDetailProjection {
    @Value("#{target.course.name}")
    String getCourseName();

    String getClassroom();
}

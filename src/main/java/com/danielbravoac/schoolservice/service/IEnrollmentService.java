package com.danielbravoac.schoolservice.service;

import com.danielbravoac.schoolservice.controller.dto.response.EnrollmentProjection;
import com.danielbravoac.schoolservice.model.Enrollment;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer, EnrollmentProjection> {
    EnrollmentProjection getEnrollmentById(Integer id);
}

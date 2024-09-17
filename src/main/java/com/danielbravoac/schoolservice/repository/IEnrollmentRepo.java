package com.danielbravoac.schoolservice.repository;

import com.danielbravoac.schoolservice.controller.dto.response.EnrollmentProjection;
import com.danielbravoac.schoolservice.model.Enrollment;

import java.util.Optional;

public interface IEnrollmentRepo extends IGenericRepo<Enrollment, Integer, EnrollmentProjection> {
    Optional<EnrollmentProjection> findProjectedByIdEnrollment(Integer id);
}

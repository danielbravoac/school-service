package com.danielbravoac.schoolservice.service.impl;

import com.danielbravoac.schoolservice.controller.dto.response.EnrollmentProjection;
import com.danielbravoac.schoolservice.exception.custom.ModelNotFoundException;
import com.danielbravoac.schoolservice.model.Enrollment;
import com.danielbravoac.schoolservice.repository.IEnrollmentRepo;
import com.danielbravoac.schoolservice.repository.IGenericRepo;
import com.danielbravoac.schoolservice.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer, EnrollmentProjection> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer, EnrollmentProjection> getRepo() {
        return repo;
    }

    @Override
    public EnrollmentProjection getEnrollmentById(Integer id) {
        return repo.findProjectedByIdEnrollment(id).orElseThrow(() -> new ModelNotFoundException("ID not found"));
    }
}

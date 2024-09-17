package com.danielbravoac.schoolservice.service.impl;

import com.danielbravoac.schoolservice.controller.dto.response.StudentProjection;
import com.danielbravoac.schoolservice.exception.custom.ModelNotFoundException;
import com.danielbravoac.schoolservice.model.Student;
import com.danielbravoac.schoolservice.repository.IGenericRepo;
import com.danielbravoac.schoolservice.repository.IStudentRepo;
import com.danielbravoac.schoolservice.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer, StudentProjection> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer, StudentProjection> getRepo() {
        return repo;
    }

    @Override
    public StudentProjection getStudentById(Integer id) {
        return repo.findProjectedByIdStudent(id).orElseThrow(() -> new ModelNotFoundException("ID not found"));
    }
}

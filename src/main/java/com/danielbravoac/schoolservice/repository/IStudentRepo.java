package com.danielbravoac.schoolservice.repository;

import com.danielbravoac.schoolservice.controller.dto.response.CourseProjection;
import com.danielbravoac.schoolservice.controller.dto.response.StudentProjection;
import com.danielbravoac.schoolservice.model.Student;

import java.util.Optional;

public interface IStudentRepo extends IGenericRepo<Student, Integer, StudentProjection> {
    Optional<StudentProjection> findProjectedByIdStudent(Integer id);
}

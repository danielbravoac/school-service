package com.danielbravoac.schoolservice.service;

import com.danielbravoac.schoolservice.controller.dto.response.StudentProjection;
import com.danielbravoac.schoolservice.model.Student;

public interface IStudentService extends ICRUD<Student, Integer, StudentProjection> {
    StudentProjection getStudentById(Integer id);
}

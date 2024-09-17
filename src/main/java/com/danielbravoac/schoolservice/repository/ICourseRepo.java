package com.danielbravoac.schoolservice.repository;

import com.danielbravoac.schoolservice.controller.dto.response.CourseProjection;
import com.danielbravoac.schoolservice.model.Course;

import java.util.Optional;

public interface ICourseRepo extends IGenericRepo<Course, Integer, CourseProjection> {

    Optional<CourseProjection> findProjectedByIdCourse(Integer id);
}

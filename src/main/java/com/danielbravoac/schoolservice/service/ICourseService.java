package com.danielbravoac.schoolservice.service;

import com.danielbravoac.schoolservice.controller.dto.response.CourseProjection;
import com.danielbravoac.schoolservice.model.Course;

public interface ICourseService extends ICRUD<Course, Integer, CourseProjection> {
    CourseProjection getCourseById(Integer id);
}

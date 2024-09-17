package com.danielbravoac.schoolservice.service.impl;

import com.danielbravoac.schoolservice.controller.dto.response.CourseProjection;
import com.danielbravoac.schoolservice.model.Course;
import com.danielbravoac.schoolservice.repository.ICourseRepo;
import com.danielbravoac.schoolservice.repository.IGenericRepo;
import com.danielbravoac.schoolservice.service.ICourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer, CourseProjection> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer, CourseProjection> getRepo() {
        return repo;
    }

    @Override
    public CourseProjection getCourseById(Integer id) {
        return repo.findProjectedByIdCourse(id).orElseThrow(() -> new EntityNotFoundException("ID not found"));
    }
}

package com.danielbravoac.schoolservice.controller;

import com.danielbravoac.schoolservice.controller.dto.request.CourseRequest;
import com.danielbravoac.schoolservice.controller.dto.response.CourseProjection;
import com.danielbravoac.schoolservice.controller.dto.response.GenericResponse;
import com.danielbravoac.schoolservice.controller.dto.response.Info;
import com.danielbravoac.schoolservice.model.Course;
import com.danielbravoac.schoolservice.service.ICourseService;
import com.danielbravoac.schoolservice.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    private final MapperUtil mapper;

    @GetMapping
    public ResponseEntity<GenericResponse<List<CourseProjection>>> getCourses() throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), service.findAllProjection()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseProjection>> getCourse(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), service.getCourseById(id)));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CourseRequest>> createCourse(@Valid @RequestBody CourseRequest course) throws Exception {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.CREATED.value(), "CREATION OK"), mapper.map(service.save(mapper.map(course, Course.class)), CourseRequest.class)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseRequest>> updateCourse(@PathVariable int id, @Valid @RequestBody CourseRequest course) throws Exception {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.OK.value(), "UPDATE OK"), mapper.map(service.update(id, mapper.map(course, Course.class)), CourseRequest.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteCourse(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.NO_CONTENT.value(), "DELETE OK"), null), HttpStatus.NO_CONTENT);
    }
}

package com.danielbravoac.schoolservice.controller;

import com.danielbravoac.schoolservice.controller.dto.request.StudentRequest;
import com.danielbravoac.schoolservice.controller.dto.response.StudentProjection;
import com.danielbravoac.schoolservice.controller.dto.response.GenericResponse;
import com.danielbravoac.schoolservice.controller.dto.response.Info;
import com.danielbravoac.schoolservice.model.Student;
import com.danielbravoac.schoolservice.service.IStudentService;
import com.danielbravoac.schoolservice.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    private final MapperUtil mapper;

    @GetMapping("/orderByAge")
    public ResponseEntity<GenericResponse<List<StudentProjection>>> orderByAge() throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"),
                service.findAllProjection().stream()
                        .sorted(Comparator.comparingInt(StudentProjection::getAge).reversed())
                        .toList()
        ));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<StudentProjection>>> getStudents() throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), service.findAllProjection()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentProjection>> getStudent(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), service.getStudentById(id)));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<StudentRequest>> createStudent(@Valid @RequestBody StudentRequest student) throws Exception {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.CREATED.value(), "CREATION OK"), mapper.map(service.save(mapper.map(student, Student.class)), StudentRequest.class)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentRequest>> updateStudent(@PathVariable int id, @Valid @RequestBody StudentRequest student) throws Exception {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.OK.value(), "UPDATE OK"), mapper.map(service.update(id, mapper.map(student, Student.class)), StudentRequest.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteStudent(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.NO_CONTENT.value(), "DELETE OK"), null), HttpStatus.NO_CONTENT);
    }
}

package com.danielbravoac.schoolservice.controller;

import com.danielbravoac.schoolservice.controller.dto.request.EnrollmentRequest;
import com.danielbravoac.schoolservice.controller.dto.response.GenericResponse;
import com.danielbravoac.schoolservice.controller.dto.response.Info;
import com.danielbravoac.schoolservice.controller.dto.response.EnrollmentProjection;
import com.danielbravoac.schoolservice.model.Enrollment;
import com.danielbravoac.schoolservice.service.IEnrollmentService;
import com.danielbravoac.schoolservice.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;

    private final MapperUtil mapper;

    @GetMapping("/groupByCourseReport")
    public ResponseEntity<GenericResponse<Map<String, List<String>>>> groupByCourseReport() throws Exception {
        Map<String, List<String>> result = service.findAll().stream()
                .flatMap(matricula -> matricula.getDetails().stream()
                        .map(detalle -> new AbstractMap.SimpleEntry<String, String>(
                                detalle.getCourse().getName(),
                                matricula.getStudent().getFirstName()
                        )))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), result));
    }


    @GetMapping
    public ResponseEntity<GenericResponse<List<EnrollmentProjection>>> getEnrollments() throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), service.findAllProjection()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EnrollmentProjection>> getEnrollment(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(new Info(HttpStatus.OK.value(), "OK"), service.getEnrollmentById(id)));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<EnrollmentRequest>> createEnrollment(@Valid @RequestBody EnrollmentRequest enrollment) throws Exception {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.CREATED.value(), "CREATION OK"), mapper.map(service.save(mapper.map(enrollment, Enrollment.class)), EnrollmentRequest.class)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<EnrollmentRequest>> updateEnrollment(@PathVariable int id, @Valid @RequestBody EnrollmentRequest enrollment) throws Exception {
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.OK.value(), "UPDATE OK"), mapper.map(service.update(id, mapper.map(enrollment, Enrollment.class)), EnrollmentRequest.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteEnrollment(@PathVariable int id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(new GenericResponse<>(new Info(HttpStatus.NO_CONTENT.value(), "DELETE OK"), null), HttpStatus.NO_CONTENT);
    }
}

package com.danielbravoac.schoolservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "curso")
public class Course {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCourse;

    @Column(length = 200, nullable = false, unique = true, name = "nombre")
    private String name;

    @Column(length = 20, nullable = false, name = "siglas")
    private String acronym;

    @Column(nullable = false, name = "estado")
    private boolean status = true;
}

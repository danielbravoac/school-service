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
@Table(name = "estudiante")
public class Student {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idStudent;

    @Column(length = 100, nullable = false, name = "nombres")
    private String firstName;

    @Column(length = 100, nullable = false, name = "apellidos")
    private String lastName;

    @Column(length = 8, nullable = false, name = "dni", unique = true)
    private String dni;

    @Column(name = "edad")
    private Byte age;
}

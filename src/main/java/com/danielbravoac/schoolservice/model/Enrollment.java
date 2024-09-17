package com.danielbravoac.schoolservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "matricula")
public class Enrollment {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Integer idEnrollment;

    @Column(name = "fecha_matricula", nullable = false, updatable = false)
    private LocalDateTime enrollmentDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula_estudiante"))
    private Student student;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<EnrollmentDetail> details;

    @Column(nullable = false, name = "estado")
    private boolean status = true;

}

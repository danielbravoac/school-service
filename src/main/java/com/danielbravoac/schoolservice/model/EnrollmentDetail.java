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
@Table(name = "detalle_matricula")
public class EnrollmentDetail {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_matricula")
    private Integer idEnrollmentDetail;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_matricula")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_curso", foreignKey = @ForeignKey(name = "fk_detalle_matricula_curso"))
    private Course course;

    @Column(name = "aula", length = 20)
    private String classroom;
}

package com.educloud.inscripciones.model.entity;

import com.educloud.inscripciones.model.enums.EstadoInscripcion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "inscripciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String estudianteId;

    @Column(nullable = false)
    private String cursoId;

    @Column(nullable = false)
    private LocalDateTime fechaInscripcion;

    @Enumerated(EnumType.STRING)
    private EstadoInscripcion estado;

    @PrePersist
    public void prePersist(){
     this.setFechaInscripcion(LocalDateTime.now());
    }

}

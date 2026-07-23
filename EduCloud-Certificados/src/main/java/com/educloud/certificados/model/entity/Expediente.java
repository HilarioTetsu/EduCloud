package com.educloud.certificados.model.entity;

import com.educloud.certificados.model.enums.EstadoExpediente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "expedientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID inscripcionId;

    @Column(nullable = false)
    private String estudianteId;

    @Column(nullable = false)
    private String cursoId;

    @Column(nullable = false)
    private Integer porcentajeProgreso;

    @Enumerated(EnumType.STRING)
    private EstadoExpediente estado;

    @Column(nullable = false)
    private LocalDateTime fechaApertura;

    @PrePersist
    public void prePersist(){
        setFechaApertura(LocalDateTime.now());
        setEstado(EstadoExpediente.EN_CURSO);
        setPorcentajeProgreso(0);
    }

}

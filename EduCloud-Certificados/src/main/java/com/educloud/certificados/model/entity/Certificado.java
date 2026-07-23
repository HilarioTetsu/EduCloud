package com.educloud.certificados.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "certificados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "expediente_id", nullable = false)
    private Expediente expediente;

    @Column(nullable = false, unique = true)
    private String codigoVerificacion;

    @Column(nullable = false)
    private LocalDateTime fechaEmision;

    private String urlPdf;

    @PrePersist
    public void prePersist(){
        setFechaEmision(LocalDateTime.now());
    }

}

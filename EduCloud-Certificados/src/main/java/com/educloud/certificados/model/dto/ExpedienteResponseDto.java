package com.educloud.certificados.model.dto;

import com.educloud.certificados.model.enums.EstadoExpediente;

import java.time.LocalDateTime;
import java.util.UUID;

public record ExpedienteResponseDto(UUID inscripcionId,
                                    String estudianteId,
                                    String cursoId,
                                    Integer porcentajeProgreso,
                                    EstadoExpediente estado,
                                    LocalDateTime fechaApertura
                                    ) {
}

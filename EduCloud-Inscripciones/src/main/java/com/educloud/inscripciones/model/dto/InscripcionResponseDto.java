package com.educloud.inscripciones.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record InscripcionResponseDto(UUID inscripcionId,
                                     String estudianteId,
                                     String cursoId,
                                     LocalDateTime fechaInscripcion) {
}

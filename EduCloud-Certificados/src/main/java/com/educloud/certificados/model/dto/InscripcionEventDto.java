package com.educloud.certificados.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record InscripcionEventDto(UUID inscripcionId,
                                  String estudianteId,
                                  String cursoId,
                                  LocalDateTime fechaInscripcion) {
}

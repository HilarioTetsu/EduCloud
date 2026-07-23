package com.educloud.inscripciones.model.dto;

import com.educloud.inscripciones.model.enums.EstadoInscripcion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarInscripcionDto(@NotBlank String estudianteId, @NotBlank String cursoId, @NotNull EstadoInscripcion estado) {
}

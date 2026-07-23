package com.educloud.inscripciones.model.dto;

import com.educloud.inscripciones.model.enums.EstadoInscripcion;
import jakarta.validation.constraints.NotNull;

public record ActualizarEstadoDto(@NotNull EstadoInscripcion estado) {
}

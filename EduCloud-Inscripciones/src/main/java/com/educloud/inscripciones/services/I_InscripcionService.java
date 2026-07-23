package com.educloud.inscripciones.services;

import com.educloud.inscripciones.model.dto.ActualizarEstadoDto;
import com.educloud.inscripciones.model.dto.InscripcionResponseDto;
import com.educloud.inscripciones.model.dto.RegistrarInscripcionDto;
import com.educloud.inscripciones.model.enums.EstadoInscripcion;

import java.util.UUID;

public interface I_InscripcionService {

    InscripcionResponseDto registrarInscripcion(RegistrarInscripcionDto registrarInscripcionDto);

    InscripcionResponseDto actualizarEstado(UUID inscripcionId, ActualizarEstadoDto estado);

    InscripcionResponseDto findById(UUID inscripcionId);

}

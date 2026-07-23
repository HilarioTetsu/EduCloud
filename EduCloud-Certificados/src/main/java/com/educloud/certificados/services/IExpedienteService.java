package com.educloud.certificados.services;

import com.educloud.certificados.model.dto.ExpedienteResponseDto;
import com.educloud.certificados.model.dto.InscripcionEventDto;

public interface IExpedienteService {

    ExpedienteResponseDto generarExpediente(InscripcionEventDto dto);

}

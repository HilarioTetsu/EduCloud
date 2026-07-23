package com.educloud.certificados.services;

import com.educloud.certificados.model.dto.ExpedienteResponseDto;
import com.educloud.certificados.model.dto.InscripcionEventDto;
import com.educloud.certificados.model.entity.Expediente;
import com.educloud.certificados.repository.IExpedienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ExpedienteServiceImpl implements IExpedienteService{

    private final IExpedienteRepository repository;


    @Override
    @Transactional
    public ExpedienteResponseDto generarExpediente(InscripcionEventDto dto) {

        Expediente exp = Expediente.builder()
                .inscripcionId(dto.inscripcionId())
                .cursoId(dto.cursoId())
                .estudianteId(dto.estudianteId())
                .build();

        repository.saveAndFlush(exp);

        return new ExpedienteResponseDto(exp.getInscripcionId(),
                exp.getEstudianteId(),
                exp.getCursoId(),
                exp.getPorcentajeProgreso(),
                exp.getEstado(),
                exp.getFechaApertura());
    }
}

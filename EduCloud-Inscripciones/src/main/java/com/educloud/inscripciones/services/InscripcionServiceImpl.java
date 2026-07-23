package com.educloud.inscripciones.services;

import com.educloud.inscripciones.model.dto.ActualizarEstadoDto;
import com.educloud.inscripciones.model.dto.InscripcionResponseDto;
import com.educloud.inscripciones.model.dto.RegistrarInscripcionDto;
import com.educloud.inscripciones.model.entity.Inscripcion;
import com.educloud.inscripciones.model.enums.EstadoInscripcion;
import com.educloud.inscripciones.repository.InscripcionRepository;
import com.educloud.inscripciones.services.publisher.PublicadorEventosInscripcion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InscripcionServiceImpl implements I_InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final PublicadorEventosInscripcion publisher;


    @Override
    @Transactional
    public InscripcionResponseDto registrarInscripcion(RegistrarInscripcionDto dto) {

        Inscripcion inscripcion = Inscripcion.builder()
                .cursoId(dto.cursoId())
                .estudianteId(dto.estudianteId())
                .estado(dto.estado())
                .build();

        inscripcionRepository.saveAndFlush(inscripcion);

        InscripcionResponseDto result = new InscripcionResponseDto(inscripcion.getId(),
                inscripcion.getEstudianteId(),
                inscripcion.getCursoId(),
                inscripcion.getFechaInscripcion());

        publisher.publicarInscripcionCreada(result);

        return result;
    }

    @Override
    public InscripcionResponseDto actualizarEstado(UUID inscripcionId, ActualizarEstadoDto dto) {

        Inscripcion inscripcion = inscripcionRepository.findById(inscripcionId).orElseThrow(() -> new NoSuchElementException("No se encontro la inscripcion"));

        inscripcion.setEstado(dto.estado());
        inscripcionRepository.saveAndFlush(inscripcion);



        return new InscripcionResponseDto(inscripcion.getId(),
                inscripcion.getEstudianteId(),
                inscripcion.getCursoId(),
                inscripcion.getFechaInscripcion());
    }

    @Override
    public InscripcionResponseDto findById(UUID inscripcionId) {

        Inscripcion inscripcion = inscripcionRepository.findById(inscripcionId).orElseThrow(() -> new NoSuchElementException("No se encontro la inscripcion"));

        return new InscripcionResponseDto(inscripcion.getId(),
                inscripcion.getEstudianteId(),
                inscripcion.getCursoId(),
                inscripcion.getFechaInscripcion());
    }
}

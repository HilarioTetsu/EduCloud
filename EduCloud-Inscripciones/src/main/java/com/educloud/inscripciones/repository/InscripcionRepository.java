package com.educloud.inscripciones.repository;

import com.educloud.inscripciones.model.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscripcionRepository extends JpaRepository<Inscripcion, UUID> {
}

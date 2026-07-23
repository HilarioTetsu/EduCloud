package com.educloud.certificados.repository;

import com.educloud.certificados.model.entity.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpedienteRepository extends JpaRepository<Expediente,Long> {
}

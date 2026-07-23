package com.educloud.inscripciones.services.publisher;

import com.educloud.inscripciones.config.MqProperties;
import com.educloud.inscripciones.model.dto.InscripcionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicadorEventosInscripcion {

    private final RabbitTemplate rabbitTemplate;
    private final MqProperties mqProperties;

    public void publicarInscripcionCreada(InscripcionResponseDto evento) {
        rabbitTemplate.convertAndSend(
                mqProperties.getExchange(),
                mqProperties.getRouting().getInscripcionCreada(), // "inscripcion.creada"
                evento
        );
    }

}

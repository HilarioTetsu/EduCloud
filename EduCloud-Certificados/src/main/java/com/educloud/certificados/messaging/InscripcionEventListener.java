package com.educloud.certificados.messaging;

import com.educloud.certificados.model.dto.InscripcionEventDto;
import com.educloud.certificados.services.IExpedienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class InscripcionEventListener {

    private final IExpedienteService service;

    @RabbitListener(queues = "${mq.queue.certificados-inscripcion}")
    public void handleEstudianteInscrito(InscripcionEventDto evento) {
        log.info("📩 Mensaje recibido de RabbitMQ para el estudiante: {}", evento.estudianteId());

        try {
            // Delegar a la capa de servicio para crear el expediente
            service.generarExpediente(evento);

            log.info("✅ Expediente procesado exitosamente para la inscripción: {}", evento.inscripcionId());
        } catch (Exception e) {
            log.error("❌ Error al procesar el evento de inscripción: {}", e.getMessage());
            // Si la excepción no se atrapa, RabbitMQ reintentará o enviará a Dead Letter Queue según configuración
            throw e;
        }
    }

}

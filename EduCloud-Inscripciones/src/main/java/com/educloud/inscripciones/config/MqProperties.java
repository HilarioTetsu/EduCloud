package com.educloud.inscripciones.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mq")
public class MqProperties {

    private String exchange;
    private Routing routing = new Routing();

    @Data
    public static class Routing {
        // mq.routing.inscripcion-creada
        private String inscripcionCreada;


    }
}
package com.educloud.certificados.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mq")
public class MqProperties {

    private String exchange;
    private Routing routing = new Routing();
    private Queue queue = new Queue();

    @Data
    public static class Routing {
        private String inscripcionCreada;
    }

    @Data
    public static class Queue {
        private String certificadosInscripcion;
    }

}

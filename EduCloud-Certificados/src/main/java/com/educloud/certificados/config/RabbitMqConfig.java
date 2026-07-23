package com.educloud.certificados.config;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(MqProperties.class)
public class RabbitMqConfig {

    private final MqProperties mqProperties;

    public RabbitMqConfig(MqProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

    @Bean
    public Queue queue() {
        // Nombre de la cola: "certificados.inscripcion-creada.queue"
        return new Queue(mqProperties.getQueue().getCertificadosInscripcion(), true);
    }

    @Bean
    public TopicExchange exchange() {
        // Nombre del exchange: "inscripciones.exchange"
        return new TopicExchange(mqProperties.getExchange());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        // Routing Key: "inscripcion.creada"
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(mqProperties.getRouting().getInscripcionCreada());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}

package com.example.saveuser.config.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    private static final String NOME_EXCHANGE = "amq.direct";

    private final AmqpAdmin amqpAdmin;

    private Queue queue(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConfig.NOME_EXCHANGE);
    }

    private Binding binding(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public void adiciona() {
        Queue queueEmail = this.queue(RabbitMQConstant.FILA_EMAIL);
        DirectExchange directExchange = this.directExchange();
        Binding binding = this.binding(queueEmail, directExchange);
        this.amqpAdmin.declareQueue(queueEmail);
        this.amqpAdmin.declareExchange(directExchange);
        this.amqpAdmin.declareBinding(binding);
    }

}

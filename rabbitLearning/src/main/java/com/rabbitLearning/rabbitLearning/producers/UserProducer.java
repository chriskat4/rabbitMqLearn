package com.rabbitLearning.rabbitLearning.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rabbitLearning.rabbitLearning.dtos.EmailDto;
import com.rabbitLearning.rabbitLearning.model.User;



@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User userModel) {
        EmailDto email = new EmailDto(userModel.getNome(),userModel.getEmail());

        rabbitTemplate.convertAndSend("", routingKey, email);
    }

}

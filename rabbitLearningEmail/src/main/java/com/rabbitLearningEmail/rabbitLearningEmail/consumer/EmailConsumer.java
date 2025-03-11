package com.rabbitLearningEmail.rabbitLearningEmail.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitLearningEmail.rabbitLearningEmail.Model.Email;
import com.rabbitLearningEmail.rabbitLearningEmail.dtos.EmailDto;
import com.rabbitLearningEmail.rabbitLearningEmail.service.EmailService;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void listenEmailQueue(@Payload EmailDto emailRecordDto) {
        var emailModel = new Email();
        BeanUtils.copyProperties(emailRecordDto, emailModel);
        emailService.sendEmail(emailModel);
    }

}

package com.rabbitLearningEmail.rabbitLearningEmail.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rabbitLearningEmail.rabbitLearningEmail.Model.Email;
import com.rabbitLearningEmail.rabbitLearningEmail.dtos.EmailDto;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmail(Email email) {
       try {
           MimeMessage message = javaMailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(message, true);

           helper.setFrom("Noreply@gmail.com");
           helper.setSubject("Subject");
           helper.setTo(email.getEmail());

    
           helper.setText("WELCOME TO OUR SITE", true);
           javaMailSender.send(message);
       } catch (Exception exception) {
           System.out.println("Falha ao enviar o email");
       }
    }
}

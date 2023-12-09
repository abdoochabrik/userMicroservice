package com.example.userMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.userMicroservice.domain.offer;
import java.util.List;


@Service()
public class EmailServiceImpl implements EmailServiceInterface {
    
        @Autowired private JavaMailSender emailSender;

        public void sendSimpleMessage( String to,String content) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject("freelanceEasy news"); 
        message.setText(content);
        emailSender.send(message);
       }


}

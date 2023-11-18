package com.example.userMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.userMicroservice.domain.offer;
import java.util.List;


@Service()
public class EmailServiceImpl {
    
        @Autowired private JavaMailSender emailSender;

        public void sendSimpleMessage( String to,String content) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject("freelanceEasy news"); 
        message.setText(content);
        emailSender.send(message);
       }

       public String getContent(List<offer> offers, String username) {
           StringBuilder result = new StringBuilder();
           result.append("Bonjour ").append(username).append("\n").append("\n");
           for ( offer offer : offers) {
            String title = offer.getTitle();
            String link  = offer.getLink();
            result.append("y'a une offre intitulée "  + title + " ").append("\n");
            result.append("pour plus d'informations visitez ce lien " + link + " ").append("\n"); 
            result.append("-------------------------------------------------").append("\n"); 
           }
           result.append("\n").append("\n");
           result.append("équipe FreealanceEasy ").append("\n");
        return result.toString();
    }
}

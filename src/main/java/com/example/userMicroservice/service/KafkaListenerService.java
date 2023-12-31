package com.example.userMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.userMicroservice.domain.offer;
import com.example.userMicroservice.domain.user;
import com.example.userMicroservice.enums.centerOfInterest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

@Component
public class KafkaListenerService {
     

  
    @Autowired 
    @Qualifier("EmailContentServiceImpl2")
    private EmailContentServiceInterface emailContentServiceImpl;

    @Autowired private userService UserService;
    @Autowired private EmailServiceInterface emailServiceImp;
    

    @KafkaListener(topics = "web",groupId = "groupId")
    void webListener(String data) throws Exception {
        System.out.println("receiving web offers");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<offer> offers = objectMapper.readValue(data, new TypeReference<List<offer>>() {});
            List<user> users = UserService.findUsersByCenterOfInterest(centerOfInterest.WEB);
            System.out.println("found users" + users);
            for(int i=0;i<users.size();i++) {
                emailServiceImp.sendSimpleMessage(users.get(i).getEmail(), emailContentServiceImpl.getMailContent(offers, users.get(i).getUsername()));
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    @KafkaListener(topics = "data",groupId = "groupId")
    void dataListener(String data) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<offer> offers = objectMapper.readValue(data, new TypeReference<List<offer>>() {});
            List<user> users = UserService.findUsersByCenterOfInterest(centerOfInterest.DATA);
            for(int i=0;i<users.size();i++) {
                emailServiceImp.sendSimpleMessage(users.get(i).getEmail(), emailContentServiceImpl.getMailContent(offers, users.get(i).getUsername()));
            }
        } catch (IOException e) {
            System.out.println("errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        }
    }

    @KafkaListener(topics = "security",groupId = "groupId")
    void securityListener(String data) throws Exception {
         try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<offer> offers = objectMapper.readValue(data, new TypeReference<List<offer>>() {});
            List<user> users = UserService.findUsersByCenterOfInterest(centerOfInterest.SECURITY);
            for(int i=0;i<users.size();i++) {
                emailServiceImp.sendSimpleMessage(users.get(i).getEmail(), emailContentServiceImpl.getMailContent(offers, users.get(i).getUsername()));
            }
        } catch (IOException e) {
            System.out.println("errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        }
    }
}
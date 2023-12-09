package com.example.userMicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userMicroservice.domain.offer;


@Service("EmailContentServiceImpl2")
public class EmailContentServiceImpl2 implements EmailContentServiceInterface {

    @Override
    public String getMailContent(List<offer> offers, String username) {
        StringBuilder result = new StringBuilder();
        result.append("Hello ").append(username).append("\n").append("\n");
        for ( offer offer : offers) {
         String title = offer.getTitle();
         String link  = offer.getLink();
         result.append("there is an offer titled "  + title + " ").append("\n");
         result.append("to see more click here " + link + " ").append("\n"); 
         result.append("-------------------------------------------------").append("\n"); 
        }
        result.append("\n").append("\n");
        result.append("FreealanceEasy team").append("\n");
     return result.toString();
    }
    
}

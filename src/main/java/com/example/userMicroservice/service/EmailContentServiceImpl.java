package com.example.userMicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userMicroservice.domain.offer;

@Service()
public class EmailContentServiceImpl implements EmailContentServiceInterface {

    @Override
    public String getMailContent(List<offer> offers, String username) {
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

package com.example.userMicroservice.service;

import java.util.List;

import com.example.userMicroservice.domain.offer;

public interface EmailContentServiceInterface {
    
    public abstract String getMailContent(List<offer> offers, String username);
}

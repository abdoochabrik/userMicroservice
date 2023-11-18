package com.example.userMicroservice.dto;

import com.example.userMicroservice.enums.centerOfInterest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String username;
    private String email;
    private String password;
    private centerOfInterest centerOfInterest;
    private Boolean activateNotifications;
}
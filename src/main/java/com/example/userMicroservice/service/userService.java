package com.example.userMicroservice.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.userMicroservice.Exceptions.UserNotFoundException;
import com.example.userMicroservice.domain.user;
import com.example.userMicroservice.dto.UpdateUserDto;
import com.example.userMicroservice.dto.UserDto;
import com.example.userMicroservice.dto.UserLoginDto;
import com.example.userMicroservice.enums.centerOfInterest;
import com.example.userMicroservice.repository.userRepository;

import jakarta.ws.rs.InternalServerErrorException;

@Service()
public class userService  {

    @Autowired private userRepository userRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    public user register(UserDto userDto) {
       user newUser =  new user();
       newUser.setEmail(userDto.getEmail());
       newUser.setUserName(userDto.getUsername());
       newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
       newUser.setCenterOfINterest(userDto.getCenterOfInterest());
       newUser.setActivateNotifications(true);
       newUser.setRole("USER");
       return userRepo.save(newUser);
    }

    public ResponseEntity<user> login(UserLoginDto userLoginDto) throws Exception {
        var foundUser =  userRepo.findByEmail(userLoginDto.getEmail());
        if(foundUser != null && passwordEncoder.matches(userLoginDto.getPassword(), foundUser.getPassword())) {
              return ResponseEntity.ok(foundUser);
        }
        else {
            throw new UserNotFoundException("No user found with this email");
        }
    }

    public List<user> findAllUsers() throws Exception {

        try {
            List<user> users = userRepo.findAll();
            return users;
        } catch (Exception e) {
            throw new RuntimeException("an error occured");
        }
    }

    public user UpdateUser(UpdateUserDto updateUserDto,Long userId) throws Exception {
        try {
            Optional<user> optionalUser = userRepo.findById(userId);
            if(!optionalUser.isEmpty()) {
                user user = optionalUser.get();
                user.setUserName(updateUserDto.getUsername());
                user.setActivateNotifications(updateUserDto.getActivateNotifications());
                user.setEmail(updateUserDto.getEmail());
                user.setPassword(updateUserDto.getPassword());
                user.setCenterOfINterest(updateUserDto.getCenterOfInterest());
                return userRepo.save(user);
            }
            else {
                throw new UserNotFoundException("I can't find this user");
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Boolean deleteUser(Long userId) throws Exception  {
         try {
            userRepo.deleteById(userId);
            return true;
         } catch (Exception e) {
            throw new UserNotFoundException("User not found");
         }
    }

     public user findUser(Long userId) throws Exception  {
         try {
           return userRepo.findById(userId).get();
         } catch (Exception e) {
            throw new UserNotFoundException("User not found");
         }
    }

    public List<user> findUsersByCenterOfInterest(centerOfInterest CenterOfInterest) throws Exception{
        try {
             return userRepo.findByCenterOfInterestAndActivateNotifications(CenterOfInterest,true); 
        } catch (Exception e) {
            throw new InternalServerErrorException("internal server problem");
        }
    }
}

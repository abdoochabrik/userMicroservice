package com.example.userMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.userMicroservice.domain.user;
import com.example.userMicroservice.dto.UpdateUserDto;
import com.example.userMicroservice.dto.UserDto;
import com.example.userMicroservice.dto.UserLoginDto;
import com.example.userMicroservice.enums.centerOfInterest;
import com.example.userMicroservice.service.EmailServiceImpl;
import com.example.userMicroservice.service.userService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class userController {
    
    @Autowired private userService userservice;

    @PostMapping("/register")
    public ResponseEntity<user> newUser(@RequestBody UserDto userdto) {
        var user =  userservice.register(userdto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<user> getUser(@RequestBody UserLoginDto userLginDto) throws Exception {
            return userservice.login(userLginDto);
    }

    @PatchMapping("/{id}")
    public user updateUser( @PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) throws Exception {
        return userservice.UpdateUser(updateUserDto, id);
    }


    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) throws Exception {
        return userservice.deleteUser(id);
    }

    @GetMapping("/{id}")
    public user getUser(@PathVariable Long id) throws Exception {
        return userservice.findUser(id);
    }

    @GetMapping("")
    public java.util.List<user> getUsers() throws Exception {
        return userservice.findAllUsers();
    }

}

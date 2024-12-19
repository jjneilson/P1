package com.ERS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ERS.entity.User;
import com.ERS.service.ReinbursmentService;
import com.ERS.service.UserService;

@Controller
public class EmploymentReinbursmentSystemController {
    
    @Autowired
    UserService userService;
    ReinbursmentService reinbursmentService;


    @Autowired
    public EmploymentReinbursmentSystemController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User newUser){ 
        if (userService.findByUsername(newUser.getUsername())==null) {
            Optional<User> response = Optional.of(userService.registerUser(newUser));
            if(response.isPresent()){
                return ResponseEntity.status(200).body(response);
            }
            else {
                return ResponseEntity.status(400).body("User not created");
            }
        }
        else {
            return ResponseEntity.status(400).body("Username already exists");
        }
    }

}
package com.ERS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ERS.entity.User;
import com.ERS.service.UserService;

@Controller
public class EmploymentReinbursmentSystemController {
    
    @Autowired
    UserService userService;


    @Autowired
    public EmploymentReinbursmentSystemController(UserService userService){
        this.userService = userService;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity deleteUser(@PathVariable int userId){
        User response = userService.findByUserId(userId);
        if(response != null){
            userService.deleteUser(userId);
            return ResponseEntity.status(200).body(response);
        }
        else{
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        User response = userService.login(user.getUsername(), user.getPassword());
        if(response != null){
            return ResponseEntity.status(200).body(response);
        }
        else{
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User newUser){
        boolean notexists=userService.findByUsername(newUser.getUsername())==null;
        if (notexists) {
            User response = userService.registerAccount(newUser);
            return ResponseEntity.status(200).body(response);
        }
        else{
            if(!notexists){
                return ResponseEntity.status(409).body(null);
            }
            else{
                return ResponseEntity.status(400).body(null);
            }
        }

    }






}
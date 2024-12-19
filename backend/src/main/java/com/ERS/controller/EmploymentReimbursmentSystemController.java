package com.ERS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ERS.entity.Reimbursment;
import com.ERS.entity.User;
import com.ERS.service.ReimbursmentService;
import com.ERS.service.UserService;

@Controller
public class EmploymentReimbursmentSystemController {
    
    @Autowired
    UserService userService;
    ReimbursmentService reimbursmentService;


    @Autowired
    public EmploymentReimbursmentSystemController(UserService userService, ReimbursmentService reimbursmentService){
        this.userService = userService;
        this.reimbursmentService = reimbursmentService;
    }

    @GetMapping("/users/{userid}/reimbursements")
    public ResponseEntity getAllReimbursmentsById(@PathVariable int userid){
        return ResponseEntity.status(200).body(reimbursmentService.getAllReimbursmentsById(userid));
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/reimbursements")
    public ResponseEntity getAllReimbursments(){
        return ResponseEntity.status(200).body(reimbursmentService.getAllReimbursments());
    }

    @PatchMapping("/reimbursements/{reimbursmentid}")
    public ResponseEntity updateReimbursment(@PathVariable int reimbursmentid, @RequestBody Reimbursment updatedReimbursment){
        Optional<Object> response = Optional.ofNullable(reimbursmentService.updateReimbursment(reimbursmentid, updatedReimbursment));
        if(response.isPresent()){
            return ResponseEntity.status(200).body(response);
        }
        else {
            return ResponseEntity.status(400).body("Reimbursment change not resolved");
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User newUser){ 
        if ((User) userService.findByUsername(newUser.getUsername())==null) {
            Optional<User> response = Optional.ofNullable(userService.registerUser(newUser));
            if(response.isPresent()){
                return ResponseEntity.status(200).body(response);
            }
            else {
                return ResponseEntity.status(400).body("User not created");
            }
        }
        else {
            return ResponseEntity.status(409).body("Username already exists");
        }
    }

    @PostMapping("/createreimbursement")
    public ResponseEntity createReimbursment(@RequestBody Reimbursment newReimbursment){
        Optional<Object> response = Optional.ofNullable(reimbursmentService.createReimbursment(newReimbursment));
        if(response.isPresent()){
            return ResponseEntity.status(200).body(response);
        }
        else {
            return ResponseEntity.status(400).body("Reimbursment not created");
        }
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user){
        User response = (User) userService.findByUsername(user.getUsername());
        if(response!=null){
            User loggedin = (User) userService.loginUser(response,user);
            if(loggedin!=null){
                return ResponseEntity.status(200).body(response);
            }
            else {
                return ResponseEntity.status(400).body("Incorrect password");
            }
        }
        else {
            return ResponseEntity.status(400).body("User not found");
        }
    }

}
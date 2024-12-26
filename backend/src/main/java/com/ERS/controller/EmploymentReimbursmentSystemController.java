package com.ERS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ERS.entity.Reimbursment;
import com.ERS.entity.User;
import com.ERS.service.JwtService;
import com.ERS.service.ReimbursmentService;
import com.ERS.service.UserService;

@Controller
public class EmploymentReimbursmentSystemController {
    
    @Autowired
    UserService userService;
    @Autowired
    ReimbursmentService reimbursmentService;
    @Autowired
    JwtService jwtService;

    @Autowired
    public EmploymentReimbursmentSystemController(UserService userService, ReimbursmentService reimbursmentService){
        this.userService = userService;
        this.reimbursmentService = reimbursmentService;
    }

    @GetMapping("/users/{userid}/reimbursements")
    public ResponseEntity getAllReimbursmentsById(@RequestHeader("Authorization") String token, @PathVariable int userid){
        if(jwtService.decodeToken(token) != null){
            return ResponseEntity.status(200).body(reimbursmentService.getAllReimbursmentsById(userid));
        }
        return ResponseEntity.status(440).body("Session Expired");
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            return ResponseEntity.status(200).body(userService.getAllUsers());
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @GetMapping("/reimbursements")
    public ResponseEntity getAllReimbursments(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            return ResponseEntity.status(200).body(reimbursmentService.getAllReimbursments());
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @PatchMapping("/reimbursements/resolve/{reimbursmentid}")
    public ResponseEntity resolveReimbursment(@RequestHeader("Authorization") String token,@PathVariable int reimbursmentid, @RequestBody Reimbursment updatedReimbursment){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            Optional<Object> response = Optional.ofNullable(reimbursmentService.updateReimbursment(reimbursmentid, updatedReimbursment));
            if(response.isPresent()){
                return ResponseEntity.status(200).body(response);
            }
            else {
                return ResponseEntity.status(409).body("Reimbursment change not resolved");
            }
        } 
        return ResponseEntity.status(401).body("Unauthorized");
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
    public ResponseEntity createReimbursment(@RequestHeader("Authorization") String token, @RequestBody Reimbursment newReimbursment){
        User jwt = jwtService.decodeToken(token);
        if(jwt != null){
            newReimbursment.setuserid(jwt.getuserid());
            Optional<Object> response = Optional.ofNullable(reimbursmentService.createReimbursment(newReimbursment));
            if(response.isPresent()){
             return ResponseEntity.status(200).body(response);
            }
            else {
                return ResponseEntity.status(400).body("Reimbursment not created");
            }
        }
        return ResponseEntity.status(440).body("Session Expired");
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user){
        User response = (User) userService.findByUsername(user.getUsername());
        if(response!=null){
            User loggedin = (User) userService.loginUser(response,user);
            if(loggedin!=null){
                String token = jwtService.generateToken(loggedin);
                return ResponseEntity.status(200).header("Authorization", token).body(response);
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
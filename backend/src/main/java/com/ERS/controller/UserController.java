package com.ERS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ERS.entity.User;
import com.ERS.service.JwtService;
import com.ERS.service.ReimbursmentService;
import com.ERS.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    @Autowired
    ReimbursmentService reimbursmentService;
    @Autowired
    JwtService jwtService;

    public UserController(UserService userService, ReimbursmentService reimbursmentService){
        this.userService = userService;
        this.reimbursmentService = reimbursmentService;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            return ResponseEntity.status(200).body(userService.getAllUsers());
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @GetMapping("/auth/me")
    public ResponseEntity checkauth(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token) != null){
            return ResponseEntity.status(200).body(jwtService.decodeToken(token));
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @PatchMapping("/users/{userid}/role")
    public ResponseEntity changeUserRole(@RequestHeader("Authorization") String token, @PathVariable int userid, @RequestBody User user){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            Optional<User> response = Optional.ofNullable(userService.changeUserRole(userid, user));
            if (response.isPresent()) {
                return ResponseEntity.status(200).body(response);
            }
            return ResponseEntity.status(409).body("User not found.");
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @PostMapping("/auth/logout")
    public ResponseEntity logoutUser(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token) != null){
            return ResponseEntity.status(200).body("Logged out");
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @PostMapping("/auth/register")
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

    @PostMapping("/auth/login")
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

    @DeleteMapping("/users/delete/{userid}")
    public ResponseEntity deleteUser(@RequestHeader("Authorization") String token, @PathVariable int userid){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            Optional<User> response = Optional.ofNullable(userService.deleteUser(userid));
            if(response.isPresent()){
                return ResponseEntity.status(200).body(response);
            }
            return ResponseEntity.status(409).body("User not found.");
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }
}

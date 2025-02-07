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

import com.ERS.entity.Reimbursment;
import com.ERS.entity.User;
import com.ERS.service.JwtService;
import com.ERS.service.ReimbursmentService;
import com.ERS.service.UserService;

@Controller
public class ReimbursmentController {
    
    @Autowired
    UserService userService;
    @Autowired
    ReimbursmentService reimbursmentService;
    @Autowired
    JwtService jwtService;

    @Autowired
    public ReimbursmentController(UserService userService, ReimbursmentService reimbursmentService){
        this.userService = userService;
        this.reimbursmentService = reimbursmentService;
    }

    @GetMapping("/reimbursements")
    public ResponseEntity getAllReimbursments(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            return ResponseEntity.status(200).body(reimbursmentService.getAllReimbursments());
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @GetMapping("/reimbursements/me")
    public ResponseEntity getAllReimbursmentsById(@RequestHeader("Authorization") String token){
        if(jwtService.decodeToken(token) != null){
            return ResponseEntity.status(200).body(reimbursmentService.getAllReimbursmentsById(jwtService.decodeToken(token).getuserid()));
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

    @PatchMapping("/reimbursements/update/{reimbursmentid}")
    public ResponseEntity changeReimbursment(@RequestHeader("Authorization") String token,@PathVariable int reimbursmentid, @RequestBody Reimbursment updatedReimbursment){
        if(jwtService.decodeToken(token).getRole().equals("employee")||jwtService.decodeToken(token).getRole().equals("manager")){
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


    @PostMapping("/reimbursements/create")
    public ResponseEntity createReimbursment(@RequestHeader("Authorization") String token, @RequestBody Reimbursment newReimbursment){
        User jwt = jwtService.decodeToken(token);
        if(jwt != null){
            newReimbursment.setuserid(jwt.getuserid());
            newReimbursment.setStatus("Pending");
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

    @DeleteMapping("/reimbursements/delete/{reimbursmentid}")
    public ResponseEntity deleteReimbursment(@RequestHeader("Authorization") String token, @PathVariable int reimbursmentid){
        if(jwtService.decodeToken(token).getRole().equalsIgnoreCase("manager")){
            Optional<Object> response = Optional.ofNullable(reimbursmentService.deleteReimbursment(reimbursmentid));
            if(response.isPresent()){
                return ResponseEntity.status(200).body(response);
            }
            else {
                return ResponseEntity.status(409).body("Reimbursment not deleted");
            }
        } 
        return ResponseEntity.status(401).body("Unauthorized");
    }
}

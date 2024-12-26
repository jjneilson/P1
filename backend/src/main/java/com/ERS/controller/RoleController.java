package com.ERS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ERS.service.JwtService;
import com.ERS.service.RoleService;

@Controller
public class RoleController {
    
    @Autowired
    RoleService roleService;
    @Autowired
    JwtService jwtService;

    public RoleController(RoleService roleService, JwtService jwtService){
        this.roleService = roleService;
        this.jwtService = jwtService;
    }

    @GetMapping("/roles")
    public List<String> getAllRoles(){
        return this.roleService.getAllRoles();
    }

    @PostMapping("/roles/add")
    public ResponseEntity addRole(@RequestHeader("Authorization") String token, @RequestBody String role){
        if(jwtService.decodeToken(token).getRole().equals("manager")){
            Optional<String> response = Optional.ofNullable(this.roleService.addRole(role));
            if(response.isPresent())
                return ResponseEntity.status(200).body(response);
            else
                return ResponseEntity.status(409).body("Role already exists.");
        }
        return ResponseEntity.status(401).body("Unauthorized");           
    }
}

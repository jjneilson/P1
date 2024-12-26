package com.ERS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERS.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<String> getAllRoles() {
        return this.roleRepository.findAll();
    }

    public String addRole(String role) {
        Optional<String> response = Optional.ofNullable(this.roleRepository.findByrole(role));
        if (response.isPresent()){
            return this.roleRepository.save(role);
        }
        return null;
        
    }
    
}

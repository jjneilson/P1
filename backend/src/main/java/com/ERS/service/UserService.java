package com.ERS.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERS.entity.User;
import com.ERS.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User newUser) {
        // Checks for valid input
        boolean fname = newUser.getfirstname().length()>0;
        boolean lname = newUser.getlastname().length()>0;
        boolean uname=newUser.getUsername().length()>0;
        boolean pword=newUser.getPassword().length()>8;
        if(fname && lname && uname && pword){
            newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
            newUser.setRole("Employee");
            return this.userRepository.save(newUser);
        }
        return null;

    }

    public Object findByUsername(String username) {
        return this.userRepository.findByusername(username);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }


}

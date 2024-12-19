package com.ERS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ERS.entity.User;
import com.ERS.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private final UserRepository userRepository;
    private BCryptPasswordEncoder crypto;
    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.crypto = new BCryptPasswordEncoder();
    }

    public User registerUser(User newUser) {
        // Checks for valid input
        boolean fname = newUser.getfirstname().length()>0;
        boolean lname = newUser.getlastname().length()>0;
        boolean uname=newUser.getUsername().length()>0;
        boolean pword=newUser.getPassword().length()>8;
        if(fname && lname && uname && pword){
            newUser.setPassword(crypto.encode(newUser.getPassword()));
            newUser.setRole("employee");
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

    public User loginUser(User response, User user) {
        if (crypto.matches(user.getPassword(), response.getPassword())){
            return response;
        }
        return null;
    }



}

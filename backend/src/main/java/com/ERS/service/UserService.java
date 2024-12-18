package com.ERS.service;

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

    public User registerAccount(User newUser){
        return this.userRepository.save(newUser);
    }

    public User findByUsername(String username){
        return this.userRepository.findByUsername(username);
    }

    public User findByUserId(int userId){
        return this.userRepository.findByUserId(userId);
    }

    public void deleteUser(int userId){
        this.userRepository.deleteById(userId);
    }

    public User login(String username, String password){
        User possibleUser = this.userRepository.findByUsername(username);
        if(possibleUser != null && possibleUser.getPassword().equals(password)){
            return possibleUser;
        }
        return null;
    }
}

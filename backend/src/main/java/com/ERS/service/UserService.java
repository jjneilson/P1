package com.ERS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ERS.entity.Reimbursment;
import com.ERS.entity.User;
import com.ERS.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private final UserRepository userRepository;
    private final ReimbursmentService reimbursmentService;
    private BCryptPasswordEncoder crypto;
    
    @Autowired
    public UserService(UserRepository userRepository, ReimbursmentService reimbursmentService){
        this.userRepository = userRepository;
        this.reimbursmentService = reimbursmentService;
        this.crypto = new BCryptPasswordEncoder();
    }

    public User registerUser(User newUser) {
        // Checks for valid input
        boolean fname = newUser.getfirstname().length()>0;
        boolean lname = newUser.getlastname().length()>0;
        boolean uname=newUser.getUsername().length()>0;
        boolean pword=newUser.getPassword().length()>=8;
        if(fname && lname && uname && pword){
            newUser.setPassword(crypto.encode(newUser.getPassword()));
            newUser.setRole("employee");
            return this.userRepository.save(newUser);
        }
        return null;
    }

    public User findByUsername(String username) {
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

    public User changeUserRole(int userid, User user) {
        Optional<User> response = Optional.ofNullable(this.userRepository.findByuserid(userid));
        if (response.isPresent()) {
            User resp = response.get();
            resp.setRole(user.getRole());
            return this.userRepository.save(resp);
        }
        return null;
    }

    public User deleteUser(int userid) {
        Optional<User> response = Optional.ofNullable(this.userRepository.findByuserid(userid));
        if(response.isPresent()){
            for (Reimbursment curr:this.reimbursmentService.getAllReimbursmentsById(userid)){
                this.reimbursmentService.deleteReimbursment(curr.getreimbursmentid());
            }
            this.userRepository.delete(response.get());
            return response.get();
        }
        return null;
    }



}

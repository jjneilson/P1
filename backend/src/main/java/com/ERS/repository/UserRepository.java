package com.ERS.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ERS.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findByUsername(String username);

    public User findByUserId(int userId);

    public void deleteById(int userId);

}

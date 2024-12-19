package com.ERS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERS.entity.Reinbursment;
import com.ERS.repository.ReinbursmentRepository;

@Service
public class ReinbursmentService {
    
    @Autowired
    private final ReinbursmentRepository reinbursmentRepository;

    @Autowired
    public ReinbursmentService(ReinbursmentRepository reinbursmentRepository){
        this.reinbursmentRepository = reinbursmentRepository;
    }

    public List<Reinbursment> getAllReimbursments() {
        return this.reinbursmentRepository.findAll();
    }


}

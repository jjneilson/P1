package com.ERS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERS.repository.ReinbursmentRepository;
import com.ERS.entity.Reinbursment;

@Service
public class ReinbursmentService {
    
    @Autowired
    private final ReinbursmentRepository reinbursmentRepository;

    @Autowired
    public ReinbursmentService(ReinbursmentRepository reinbursmentRepository){
        this.reinbursmentRepository = reinbursmentRepository;
    }

    public List<Reinbursment> findByPostedBy(int postedBy){
        return this.reinbursmentRepository.findByPostedBy(postedBy);
    }

    public Reinbursment findByReinbursmentId(int reinbursmentId){
        return this.reinbursmentRepository.findByReinbursmentId(reinbursmentId);
    }

    public void updateByReinbursmentId(int reinbursmentId, String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateByReinbursmentId'");
    }

    public Object getReinbursments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReinbursments'");
    }
}

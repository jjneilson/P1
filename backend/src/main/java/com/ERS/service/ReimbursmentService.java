package com.ERS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERS.entity.Reimbursment;
import com.ERS.repository.ReimbursmentRepository;

@Service
public class ReimbursmentService {
    
    @Autowired
    private final ReimbursmentRepository reimbursmentRepository;

    @Autowired
    public ReimbursmentService(ReimbursmentRepository reinbursmentRepository){
        this.reimbursmentRepository = reinbursmentRepository;
    }

    public List<Reimbursment> getAllReimbursments() {
        return this.reimbursmentRepository.findAll();
    }

    public Object getAllReimbursmentsById(int userid) {
        return this.reimbursmentRepository.findByuserid(userid);
    }

    public Object createReimbursment(Reimbursment newReimbursment) {
        boolean amount = newReimbursment.getAmount()!=0;
        boolean userid = newReimbursment.getuserid()!=0;
        boolean status = newReimbursment.getStatus().equals("pending");
        if (amount && userid && status) {
            return this.reimbursmentRepository.save(newReimbursment);
        }
        return null;
    }

    public Object updateReimbursment(int reimbursmentid, Reimbursment updatedReimbursment) {
        boolean idcheck = this.reimbursmentRepository.findByreimbid(reimbursmentid)!=null;
        if (idcheck) {
            updatedReimbursment.setStatus(updatedReimbursment.getStatus());
            return this.reimbursmentRepository.save(updatedReimbursment);
        }
        return null;
    }


}

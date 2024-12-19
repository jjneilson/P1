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

    public Object createReimbursment(Reimbursment newReinbursment) {
        boolean amount = newReinbursment.getAmount()!=0;
        boolean userid = newReinbursment.getuserid()!=0;
        boolean status = newReinbursment.getStatus().equals("pending");
        if (amount && userid && status) {
            System.out.println("Creating new reinbursment");
            return this.reimbursmentRepository.save(newReinbursment);
        }
        return null;
    }

    public Object updateReimbursment(int reimbursmentid, Reimbursment updatedReimbursment) {
        boolean idcheck = this.reimbursmentRepository.findByreimbid(reimbursmentid)!=null;
        if (idcheck) {
            updatedReimbursment.setreimbursmentid(reimbursmentid);
            return this.reimbursmentRepository.save(updatedReimbursment);
        }
        return null;
    }


}

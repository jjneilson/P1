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

    public List<Reimbursment> getAllReimbursmentsById(int userid) {
        return this.reimbursmentRepository.findByuserid(userid);
    }

    public Object createReimbursment(Reimbursment newReimbursment) {
        boolean amount = newReimbursment.getAmount()!=0;
        boolean userid = newReimbursment.getuserid()!=0;
        boolean status = newReimbursment.getStatus().equalsIgnoreCase("pending");
        System.out.println(amount +" "+ userid +" "+ status);
        if (amount && userid && status) {
            return this.reimbursmentRepository.save(newReimbursment);
        }
        return null;
    }

    public Object updateReimbursment(int reimbursmentid, Reimbursment updatedReimbursment) {
        boolean idcheck = this.reimbursmentRepository.findByreimbid(reimbursmentid)!=null;
        if (idcheck) {
            Reimbursment oldReimbursment = this.reimbursmentRepository.findByreimbid(reimbursmentid);
            if (updatedReimbursment.getDescription() != null) {
                oldReimbursment.setDescription(updatedReimbursment.getDescription());
            }
            else {
                System.out.println(updatedReimbursment.getStatus());
                oldReimbursment.setStatus(updatedReimbursment.getStatus());
            }
            return this.reimbursmentRepository.save(oldReimbursment);
        }
        return null;
    }

    public Object deleteReimbursment(int reimbursmentid) {
        boolean idcheck = this.reimbursmentRepository.findByreimbid(reimbursmentid)!=null;
        if (idcheck) {
            this.reimbursmentRepository.deleteById((long) reimbursmentid);
            return "Reimbursment with id "+reimbursmentid+" deleted";
        }
        return null;
    }


}

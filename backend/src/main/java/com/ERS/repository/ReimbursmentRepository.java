package com.ERS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ERS.entity.Reimbursment;

@Repository
public interface ReimbursmentRepository extends JpaRepository<Reimbursment, Long> {

    List<Reimbursment> findByuserid(int userid);

    Reimbursment findByreimbid(int reimb_id);

}

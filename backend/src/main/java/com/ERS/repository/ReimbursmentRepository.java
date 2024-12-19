package com.ERS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ERS.entity.Reimbursment;

@Repository
public interface ReimbursmentRepository extends JpaRepository<Reimbursment, Long> {

    Object findByuserid(int userid);

    Object findByreimbid(int reimb_id);

}

package com.ERS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ERS.entity.Reinbursment;

@Repository
public interface ReinbursmentRepository extends JpaRepository<Reinbursment, Long> {

}

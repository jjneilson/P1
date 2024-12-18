package com.ERS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ERS.entity.Reinbursment;

@Repository
public interface ReinbursmentRepository extends JpaRepository<Reinbursment, Long> {
    
    Reinbursment findByReinbursmentId(int reinbursmentId);

    List<Reinbursment> findByPostedBy(int postedBy);

    @Modifying
    @Query("UPDATE Reinbursment SET status = :status WHERE reinbursmentId = :reinbursmentId")
    public void updateByReinbursmentId(@Param("reinbursmentId") int reinbursmentId, @Param("status") String status);

    @Modifying
    @Query("DELETE from Reinbursment WHERE reinbursmentId = :reinbursmentId")
    public void deleteByReinbursmentId(@Param("reinbursmentId") int reinbursmentId);

}

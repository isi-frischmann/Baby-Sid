package com.isabell.authentication.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isabell.authentication.models.Parent;

@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {
    Parent findByEmail(String email);
    
    
    @Modifying
    @Transactional
    @Query("UPDATE Parent p SET p.fname = ?2, p.lname = ?3, p.email = ?4, p.phone = ?5, p.amountKid = ?6 WHERE p.id = ?1")
    void updateParentDetails(Long id, String fname, String lname, String email, String phone, Integer amountKid);
}

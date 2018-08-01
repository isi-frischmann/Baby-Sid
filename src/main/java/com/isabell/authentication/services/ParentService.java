package com.isabell.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.isabell.authentication.models.Parent;
import com.isabell.authentication.repositories.ParentRepository;

@Service
public class ParentService {
    private final ParentRepository parentRepository;
    
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
    
    // register parent and hash their password
    public Parent registerParent(Parent parent) {
        String hashed = BCrypt.hashpw(parent.getPassword(), BCrypt.gensalt());
        parent.setPassword(hashed);
        return parentRepository.save(parent);
    }
    
    // find parent by email
    public Parent findByEmail(String email) {
        return parentRepository.findByEmail(email);
    }
    
    // find parent by id
    public Parent findParentById(Long id) {
    	Optional<Parent> u = parentRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate parent
    public boolean authenticateParent(String email, String password) {
        // first find the parent by email
        Parent parent = parentRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(parent == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, parent.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
//    update the profile from the parent
    public void updateParent(Long id, Parent p) {
    	parentRepository.updateParentDetails(id, p.getFname(), p.getLname(), p.getEmail(), p.getPhone(), p.getAmountKid());
    }
}
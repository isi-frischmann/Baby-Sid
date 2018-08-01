package com.isabell.authentication.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.isabell.authentication.models.Nanny;
import com.isabell.authentication.repositories.NannyRepository;

@Service
public class NannyService {
    private final NannyRepository nannyRepository;
    
    public NannyService(NannyRepository nannyRepository) {
        this.nannyRepository = nannyRepository;
    }
    
    // register nanny and hash their password
    public Nanny registerNanny(Nanny nanny) {
        String hashed = BCrypt.hashpw(nanny.getPassword(), BCrypt.gensalt());
        nanny.setPassword(hashed);
        return nannyRepository.save(nanny);
    }
    
    // find nanny by email
    public Nanny findByEmail(String email) {
        return nannyRepository.findByEmail(email);
    }
    
    // find nanny by id
    public Nanny findNannyById(Long id) {
    	Optional<Nanny> u = nannyRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate nanny
    public boolean authenticateNanny(String email, String password) {
        // first find the nanny by email
        Nanny nanny = nannyRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(nanny == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, nanny.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public List <Nanny> findByAddress2(String address){
    	return nannyRepository.findByAddress(address);
    }
    
    public List <Nanny> findNannyByAddress(String address) {
    	return nannyRepository.findAllNannysWithAddress(address);
    }
}

package com.isabell.authentication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabell.authentication.models.Nanny;

@Repository
public interface NannyRepository extends CrudRepository<Nanny, Long>{
	Nanny findByEmail(String email);
	
	List<Nanny> findByAddress(String address);
    
	@Query(value = "SELECT * FROM BabySid.nannys n WHERE n.address = ?1", nativeQuery = true)
	List<Nanny> findAllNannysWithAddress(String address);
}

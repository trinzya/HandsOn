package com.cognizant.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Country;

@Repository

public interface CountryRepository extends JpaRepository<Country, String> {
	
	
public List<Country>  findByNameContaining(String word);
public List<Country>  findByNameStartingWith(String prefix);

@Query("SELECT m FROM Country m WHERE m.name LIKE %:title% order by m.name")
List<Country> searchByNameLike(@Param("title") String title); 


}




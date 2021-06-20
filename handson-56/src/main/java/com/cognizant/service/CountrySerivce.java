package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Repository.CountryRepository;
import com.cognizant.model.Country;
import com.cognizant.service.Exception.CountryNotFoundException;

@Service
public class CountrySerivce { 
	
	@Autowired
	private CountryRepository repo;
	@Transactional
	public List<Country> getAllCountries(){
		return repo.findAll();
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = repo.findById(countryCode);
		
		if(!result.isPresent()) {
			throw new CountryNotFoundException("Country not found with code"+countryCode);
			
			
		}
		
		else {
			return result.get();
		}
	}
	
	@Transactional

	public void addCountry(Country country) {
		repo.save(country);
	}
	
	@Transactional
	public void updateCountry(Country country) throws CountryNotFoundException {
		Optional<Country> result = repo.findById(country.getCode());
		if(!result.isPresent()) {
			throw new CountryNotFoundException("Country not found with code"+country);
			
			
		}
		
		else {
			Country c= result.get();
			c.setName(country.getName());
			repo.save(c);
		}
		
		
	}
	
	@Transactional
	public void deleteCountry(String countryCode) { 
		
		repo.deleteById(countryCode);
		
		
		
	}
	@Transactional
	public List<Country> serachCountryByName(String word){
		return repo.findByNameContaining(word);

}
	public List<Country> searchandorder(String word){
		return repo.searchByNameLike(word);
	}
	
	@Transactional
	public List<Country> serachStartCountryByName(String prefix){
		return repo.findByNameStartingWith(prefix);

}
	
	
}

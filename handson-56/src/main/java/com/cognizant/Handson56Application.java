package com.cognizant;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Country;
import com.cognizant.service.CountrySerivce;

@SpringBootApplication
public class Handson56Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Handson56Application.class);
	private static CountrySerivce countryService;
	
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	
	private static void getAllCountriesTest() {

		LOGGER.info("Start");
            try {
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
            }
            catch(Exception e){
            	System.out.println(e);
            }

	

		LOGGER.info("End");

		}
	public static void testAddCountry() {
		Country c = new Country() ;
		
			c.setCode("A");
			c.setName("my country");
			
			countryService.addCountry(c);
		    try {
				Country country = countryService.findCountryByCode("A");
				LOGGER.debug("Country:{}", country);
		            }
		            catch(Exception e){
		            	System.out.println(e);
		            }	
		
	}
	
	public static void testUpdateCountry() {
		Country c= new Country();
		c.setCode("A");
		c.setName("Hello update Country");
		try {
			countryService.updateCountry(c);
			Country country = countryService.findCountryByCode("A");
			LOGGER.debug("Country:{}", country);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
	} 
	
	public static void testDeleteCountry() {
		countryService.deleteCountry("A");
		
		try {
			
			Country country = countryService.findCountryByCode("A");
			LOGGER.debug("Country:{}", country);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		
	}
	
	
	public static void testFindCountryName() {
		List<Country> countries=	countryService.serachCountryByName("ou");
		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");
	}
	

	public static void testFindCountryNameOrder() {
		List<Country> countries=	countryService.searchandorder("ou");
		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");
	}
	

	public static void testFindCountryNameStart() {
		List<Country> countries=	countryService.serachStartCountryByName("Z");
		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");
	}
	
	public static void main(String[] args) {
//		SpringApplication.run(Handson56Application.class, args);
		LOGGER.info("Inside main"); 
		
		ApplicationContext context = SpringApplication.run(Handson56Application.class, args);

		countryService = context.getBean(CountrySerivce.class);
		
//		 testGetAllCountries(); 
//		 getAllCountriesTest();
		 
		
//		 testAddCountry(); 
//		testUpdateCountry();
//		testDeleteCountry();
//		testFindCountryName();
//		testFindCountryNameOrder();
		
		testFindCountryNameStart();
		
	}

}

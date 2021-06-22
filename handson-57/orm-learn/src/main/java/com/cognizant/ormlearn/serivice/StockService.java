package com.cognizant.ormlearn.serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;



@Service
public class StockService  {
	
	@Autowired
	private StockRepository  sRepo; 
	
	public String findstocksep() {
	List<Stock>	 l = sRepo.findBydate();
	System.out.println(l);
	return "list printed";
	}
	
	public  String  findByclose(){
		List<Stock>	 l = sRepo.findByclose();
		System.out.println(l);
		return "list printed";
		
	}

	public String   findBymaxvolume() {
		List<Stock>	 l = sRepo.findBymaxvolume();
		System.out.println(l);
		return "list printed";

}
	public String  	findByminvolume() {
		
		List<Stock>	 l = sRepo.findByminvolume();
		System.out.println(l);
		return "list printed";

	}
}

package com.cognizant.ormlearn.repository;


import com.cognizant.ormlearn.model.Stock;


import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository  extends JpaRepository<Stock,String> {  
	
	@Query("select s from Stock s where s.st_date like '2019-09%' and s.st_code='FB'")
	 List<Stock>  findBydate();
	
	@Query("select s from Stock s where s.st_close >1250  and s.st_code='GOOGL'")
	 List<Stock>  findByclose();
	
	@Query( value="select *  from Stock s where  s.st_code='FB' order by s.st_volume desc Limit 3", nativeQuery = true)
	 List<Stock>  findBymaxvolume();
	
	@Query( value="select *  from Stock s where  s.st_code='NFLX' order by s.st_volume  Limit 3", nativeQuery = true)
	 List<Stock>  findByminvolume();
	
	
	
	
}


package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.serivice.StockService;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);


	public static void main(String[] args) {
	
		

		LOGGER.info("Inside main");
		
	ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

StockService	stockService = context.getBean(StockService.class);
System.out.println(stockService.findstocksep());
System.out.println(stockService.findByclose());
	System.out.println(stockService.findBymaxvolume());
	System.out.println(stockService.findByminvolume());

		}
	}



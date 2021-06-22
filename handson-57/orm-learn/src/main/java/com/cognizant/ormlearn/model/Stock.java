package com.cognizant.ormlearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "stock")
public class Stock {
	
	@Id
	private int st_id;
	
	private String st_code;
	private Date st_date;
	private BigDecimal st_open;
	private BigDecimal st_close;
	private BigDecimal st_volume;
	
	
}

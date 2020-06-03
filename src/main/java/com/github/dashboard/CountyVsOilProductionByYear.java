package com.github.dashboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountyVsOilProductionByYear {

	@Id
	private int id;
	
	@Column
	private String county;
	
	private double oil_production;
	private int year;
	
	public CountyVsOilProductionByYear() {
		
	}

	public CountyVsOilProductionByYear(String county, double oil_production, int year) {
		super();
		this.county = county;
		this.oil_production = oil_production;
		this.year = year;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public double getOil_production() {
		return oil_production;
	}

	public void setOil_production(double oil_production) {
		this.oil_production = oil_production;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}

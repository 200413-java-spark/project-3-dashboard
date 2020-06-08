package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CountyVsOilProductionByYear")
public class CountyVsOilProductionByYearModel {
	@Id
	private int id;

	private String county;
	private double oilProduction;
	private int year;

	public CountyVsOilProductionByYearModel() {
	}

	public CountyVsOilProductionByYearModel(String county, double oil_production, int year) {
		this.county = county;
		this.oilProduction = oil_production;
		this.year = year;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public double getOil_production() {
		return oilProduction;
	}

	public void setOil_production(double oil_production) {
		this.oilProduction = oil_production;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}

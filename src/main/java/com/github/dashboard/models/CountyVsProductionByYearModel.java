package com.github.dashboard.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CountyVsOilProductionByYear")
public class CountyVsProductionByYearModel {
	@Id
	private int id;

	private String company;
	private String county;
	private Double oilProduction;
	private Double gasProduction;
	private Double waterProduction;
	private int year;

	public CountyVsProductionByYearModel() {
	}

	public CountyVsProductionByYearModel(String company, String county, Double oilProduction, Double gasProduction,
			Double waterProduction, int year) {
		this.company = company;
		this.county = county;
		this.oilProduction = oilProduction;
		this.gasProduction = gasProduction;
		this.waterProduction = waterProduction;
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public String getCounty() {
		return county;
	}

	public Double getOilProduction() {
		return oilProduction;
	}

	public Double getGasProduction() {
		return gasProduction;
	}

	public Double getWaterProduction() {
		return waterProduction;
	}

	public int getYear() {
		return year;
	}

}

package com.github.dashboard.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CountyVsOilProductionByYear")
public class CountyVsOilProductionByYearModel {
	@Id
	private int id;

	private String county;
	private Double oilProduction;
	private Double gasProduction;
	private Double waterProduction;
	private int year;

	public CountyVsOilProductionByYearModel() {
	}

	public CountyVsOilProductionByYearModel(String county, Double oilProduction, Double gasProduction,
			Double waterProduction, int year) {
		this.county = county;
		this.oilProduction = oilProduction;
		this.gasProduction = gasProduction;
		this.waterProduction = waterProduction;
		this.year = year;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Double getOilProduction() {
		return oilProduction;
	}

//	public void setOilProduction(double oilproduction) {
//		this.oilProduction = oilproduction;
//	}

	public Double getGasProduction() {
		return gasProduction;
	}

//	public void setGasProduction(double gasProduction) {
//		this.gasProduction = gasProduction;
//	}

	public Double getWaterProduction() {
		return waterProduction;
	}

//	public void setWaterProduction(double waterProduction) {
//		this.waterProduction = waterProduction;
//	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}

package com.github.dashboard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity(name = "CountyVsOilProductionByYear")

@NamedNativeQueries({
		@NamedNativeQuery(name = "getByCounty", query = "Select * From County_Vs_Oil_Production_By_Year "
				+ "WHERE county LIKE ?", resultClass = CountyVsOilProductionByYearModel.class),

		@NamedNativeQuery(name = "getByYear", query = "Select * From County_Vs_Oil_Production_By_Year "
				+ "WHERE year=?", resultClass = CountyVsOilProductionByYearModel.class) })

public class CountyVsOilProductionByYearModel {

	@Id
	private int id;

	@Column(name = "county")
	private String county;

	private double oil_production;

	@Column(name = "year")
	private int year;

	public CountyVsOilProductionByYearModel() {

	}

	public CountyVsOilProductionByYearModel(String county, double oil_production, int year) {
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

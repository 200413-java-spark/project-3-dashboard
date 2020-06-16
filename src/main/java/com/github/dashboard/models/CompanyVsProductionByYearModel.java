package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "allcompany")
public class CompanyVsProductionByYearModel {

	@Id
	private int id;
	private String companyname;
	private Double totaloil;
	private Double totalwater;
	private Double gastotal;
	private String year;

	public CompanyVsProductionByYearModel() {
	}

	public CompanyVsProductionByYearModel(String companyname, Double totaloil, Double totalwater, Double gastotal,
			String year) {
		this.companyname = companyname;
		this.totaloil = totaloil;
		this.totalwater = totalwater;
		this.gastotal = gastotal;
		this.year = year;
	}

	public String getCompanyname() {
		return companyname;
	}

	public Double getTotaloil() {
		return totaloil;
	}

	public Double getTotalwater() {
		return totalwater;
	}

	public Double getgastotal() {
		return gastotal;
	}

	public String getyear() {
		return year;
	}

}

package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "allcompany")
@IdClass(CompanyId.class)
public class CompanyVsProductionByYearModel {

	@Id
	private String companyname;
	private Double totaloil;
	private Double totalwater;
	private Double gastotal;
	@Id
	private Integer year;

	public CompanyVsProductionByYearModel() {
	}

	public CompanyVsProductionByYearModel(String companyname, Double totaloil, Double totalwater, Double gastotal,
			Integer year) {
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

	public Integer getyear() {
		return year;
	}


}

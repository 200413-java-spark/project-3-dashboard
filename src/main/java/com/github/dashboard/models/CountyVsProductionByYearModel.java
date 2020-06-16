package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "countyvsoilproductionbyyear")
public class CountyVsProductionByYearModel {

	@Id
	private int id;
	private String county;
	private Double totaloil;
	private Double totalwater;
	private Double totalgas;
	private String reportingyear;

	public CountyVsProductionByYearModel() {
	}

	public CountyVsProductionByYearModel(String county, Double totaloil, Double totalwater, Double totalgas,
			String reportingyear) {
		this.county = county;
		this.totaloil = totaloil;
		this.totalwater = totalwater;
		this.totalgas = totalgas;
		this.reportingyear = reportingyear;
	}

	public String getCounty() {
		return county;
	}

	public Double getTotaloil() {
		return totaloil;
	}

	public Double getTotalwater() {
		return totalwater;
	}

	public Double getTotalgas() {
		return totalgas;
	}

	public String getReportingyear() {
		return reportingyear;
	}

}

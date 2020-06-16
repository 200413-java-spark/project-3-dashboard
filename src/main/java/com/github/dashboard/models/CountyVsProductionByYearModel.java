package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "countyvsoilproductionbyyear")
@IdClass(CountyId.class)
public class CountyVsProductionByYearModel {

	@Id
	private String county;
	private Double totaloil;
	private Double totalwater;
	private Double totalgas;
	@Id
	private Integer reportingyear;

	public CountyVsProductionByYearModel() {
	}

	public CountyVsProductionByYearModel(String county, Double totaloil, Double totalwater, Double totalgas,
			Integer reportingyear) {
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

	public Integer getReportingyear() {
		return reportingyear;
	}


}

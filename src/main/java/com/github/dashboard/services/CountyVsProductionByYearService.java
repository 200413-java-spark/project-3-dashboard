package com.github.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dashboard.models.CountyVsProductionByYearModel;
import com.github.dashboard.repositories.CountyVsProductionByYearRepo;

@Service
public class CountyVsProductionByYearService {

	@Autowired
	private CountyVsProductionByYearRepo countyVsProductionByYearRepo;

	public List<CountyVsProductionByYearModel> findAll() {
		return countyVsProductionByYearRepo.findAll();
	}

	public CountyVsProductionByYearModel findById(int id) {
		return countyVsProductionByYearRepo.findById(id).get();
	}

	public List<CountyVsProductionByYearModel> findByCounty(String county) {
		return countyVsProductionByYearRepo.findByCounty(county);
	}

	public List<CountyVsProductionByYearModel> findByreportingyear(int year) {
		return countyVsProductionByYearRepo.findByreportingyear(year);
	}
}

package com.github.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;
import com.github.dashboard.repositories.CountyVsOilProductionByYearRepo;


@Service
public class CountyVsOilProductionByYearService {
	
	@Autowired
	private CountyVsOilProductionByYearRepo countyVsOilProductionByYearRepo;
	
	public List<CountyVsOilProductionByYearModel> findAll() {
		return countyVsOilProductionByYearRepo.findAll();
	}
	
	public CountyVsOilProductionByYearModel findById(int id) {
		return countyVsOilProductionByYearRepo.findById(id).get();
	}
	
	public List<CountyVsOilProductionByYearModel> findByCounty(String county) {
		return countyVsOilProductionByYearRepo.findByCounty(county);
	}
	
	public List<CountyVsOilProductionByYearModel> findByYear(int year) {
		return countyVsOilProductionByYearRepo.findByYear(year);
	}
	
	public List<CountyVsOilProductionByYearModel> findByOilProductionGreaterThanEqual(double oilProduction) {
		return countyVsOilProductionByYearRepo.findByOilProductionGreaterThanEqual(oilProduction);
	}

	public List<CountyVsOilProductionByYearModel> findByOilProductionLessThanEqual(double oilProduction) {
		return countyVsOilProductionByYearRepo.findByOilProductionLessThanEqual(oilProduction);
	}
	
	
}

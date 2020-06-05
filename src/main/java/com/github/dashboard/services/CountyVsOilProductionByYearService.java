package com.github.dashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;
import com.github.dashboard.repositories.CountyVsOilProductionByYearRepo;


@Service
public class CountyVsOilProductionByYearService {
	
	@Autowired
	private CountyVsOilProductionByYearRepo countyVsOilProductionByYearRepo;
	
	public List<CountyVsOilProductionByYearModel> getAllData() {
		List<CountyVsOilProductionByYearModel> data = new ArrayList<>();
		countyVsOilProductionByYearRepo.findAll()
		.forEach(data::add);
		return data;
	}
	
	public CountyVsOilProductionByYearModel getData(int id) {
		return countyVsOilProductionByYearRepo.findById(id).get();
	}
	
	public List<CountyVsOilProductionByYearModel> getFilteredCounty(String county) {
		return countyVsOilProductionByYearRepo.getByCounty(county);
	}
	
	public List<CountyVsOilProductionByYearModel> getFilteredYear(int year) {
		return countyVsOilProductionByYearRepo.getByYear(year);
	}
}

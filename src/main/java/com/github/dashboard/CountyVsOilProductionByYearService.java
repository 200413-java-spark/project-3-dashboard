package com.github.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountyVsOilProductionByYearService {
	
	@Autowired
	private CountyVsOilProductionByYearRepo countyVsOilProductionByYearRepo;
	
	public List<CountyVsOilProductionByYear> getAllData() {
		List<CountyVsOilProductionByYear> data = new ArrayList<>();
		countyVsOilProductionByYearRepo.findAll()
		.forEach(data::add);
		return data;
	}
	
	public CountyVsOilProductionByYear getData(int id) {
		return countyVsOilProductionByYearRepo.findById(id).get();
	}
}

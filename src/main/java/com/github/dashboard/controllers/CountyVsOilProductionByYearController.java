package com.github.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;
import com.github.dashboard.services.CountyVsOilProductionByYearService;

@RestController
public class CountyVsOilProductionByYearController {
	
	@Autowired
	private CountyVsOilProductionByYearService countyVsOilProductionByYearService;
	
	@RequestMapping("/CountyVsOilProductionByYear")
	public List<CountyVsOilProductionByYearModel> getAllData() {
		return countyVsOilProductionByYearService.getAllData();
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/{id}")
	public CountyVsOilProductionByYearModel getSpecificDataById(@PathVariable int id) {
		return countyVsOilProductionByYearService.getData(id);
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/filter/county/{county}")
	public List<CountyVsOilProductionByYearModel> getFilteredByCounty(@PathVariable String county){
		return countyVsOilProductionByYearService.getFilteredCounty(county);
		
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/filter/year/{year}")
	public List<CountyVsOilProductionByYearModel> getFilteredByYear(@PathVariable int year){
		return countyVsOilProductionByYearService.getFilteredYear(year);
	}

}

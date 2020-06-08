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
	public List<CountyVsOilProductionByYearModel> findAll() {
		return countyVsOilProductionByYearService.findAll();
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/{id}")
	public CountyVsOilProductionByYearModel findById(@PathVariable int id) {
		return countyVsOilProductionByYearService.findById(id);
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/filter/county/{county}")
	public List<CountyVsOilProductionByYearModel> findByCounty(@PathVariable String county){
		return countyVsOilProductionByYearService.findByCounty(county);
		
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/filter/year/{year}")
	public List<CountyVsOilProductionByYearModel> findByYear(@PathVariable int year){
		return countyVsOilProductionByYearService.findByYear(year);
	}
	
	@RequestMapping("/CountyVsOilProductionByYear/filter/oilproductiongreaterthan/{oilProduction}")
	public List<CountyVsOilProductionByYearModel> findByOilProductionGreaterThanEqual(@PathVariable double oilProduction){
		return countyVsOilProductionByYearService.findByOilProductionGreaterThanEqual(oilProduction);
	}

	@RequestMapping("/CountyVsOilProductionByYear/filter/oilproductionlessthan/{oilProduction}")
	public List<CountyVsOilProductionByYearModel> findByOilProductionLessThanEqual(@PathVariable double oilProduction) {
		return countyVsOilProductionByYearService.findByOilProductionLessThanEqual(oilProduction);
	}
	
	

}

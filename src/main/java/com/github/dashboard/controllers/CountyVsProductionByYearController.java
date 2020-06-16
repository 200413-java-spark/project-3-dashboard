package com.github.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dashboard.models.CountyVsProductionByYearModel;
import com.github.dashboard.services.CountyVsProductionByYearService;

@RestController
public class CountyVsProductionByYearController {

	@Autowired
	private CountyVsProductionByYearService countyVsProductionByYearService;

	@RequestMapping("/CountyVsOilProductionByYear")
	public List<CountyVsProductionByYearModel> findAll() {
		return countyVsProductionByYearService.findAll();
	}

	@RequestMapping("/CountyVsProductionByYear/{id}")
	public CountyVsProductionByYearModel findById(@PathVariable int id) {
		return countyVsProductionByYearService.findById(id);
	}

	@RequestMapping("/CountyVsProductionByYear/filter/county/{county}")
	public List<CountyVsProductionByYearModel> findByCounty(@PathVariable String county) {
		return countyVsProductionByYearService.findByCounty(county);

	}

	@RequestMapping("/CountyVsProductionByYear/filter/year/{year}")
	public List<CountyVsProductionByYearModel> findByYear(@PathVariable int year) {
		return countyVsProductionByYearService.findByYear(year);
	}

}

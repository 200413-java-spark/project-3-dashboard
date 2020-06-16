package com.github.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dashboard.models.CountyVsProductionByYearModel;
import com.github.dashboard.services.CountyVsProductionByYearService;

@RestController
public class CountyVsProductionByYearController {

	@Autowired
	private CountyVsProductionByYearService countyVsProductionByYearService;

	@RequestMapping("/CountyVsProductionByYear")
	public List<CountyVsProductionByYearModel> findAll() {
		return countyVsProductionByYearService.findAll();
	}

}

package com.github.dashboard;

import java.util.List;

import com.github.dashboard.services.CountyVsOilProductionByYearService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountyVsOilProductionByYearController {

	@Autowired
	private CountyVsOilProductionByYearService countyVsOilProductionByYearService;

	@RequestMapping("/CountyVsOilProductionByYear")
	public List<CountyVsOilProductionByYear> getAllTopics() {
		return countyVsOilProductionByYearService.getAllData();
	}

	@RequestMapping("/CountyVsOilProductionByYear/{id}")
	public CountyVsOilProductionByYear getTopic(@PathVariable int id) {
		return countyVsOilProductionByYearService.getData(id);
	}
}

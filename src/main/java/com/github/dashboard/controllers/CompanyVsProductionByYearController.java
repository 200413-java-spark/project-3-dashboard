package com.github.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dashboard.models.CompanyVsProductionByYearModel;
import com.github.dashboard.services.CompanyVsProductionByYearService;

@RestController
public class CompanyVsProductionByYearController {

	@Autowired
	private CompanyVsProductionByYearService companyVsProductionByYearService;

	@RequestMapping("/CompanyVsProductionByYear")
	public List<CompanyVsProductionByYearModel> findAll() {
		return companyVsProductionByYearService.findAll();
	}

}

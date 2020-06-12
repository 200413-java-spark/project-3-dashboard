package com.github.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/CountyVsProductionByYearView")
	public String CountyVsProductionByYearView() {
		return "CountyVsProductionByYearView";
	}

	@RequestMapping("/MapView")
	public String MapView() {
		return "MapView";
	}

	@RequestMapping("/CompanyView")
	public String CompanyView() {
		return "CompanyView";
	}

	@RequestMapping("/About")
	public String AboutView() {
		return "About";
	}

}

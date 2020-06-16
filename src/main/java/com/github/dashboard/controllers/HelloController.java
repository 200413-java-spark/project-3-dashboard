package com.github.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/CountyVsOilProductionByYearView")
	public String CountyVsOilProductionByYearView() {
		return "CountyVsOilProductionByYearView";
	}

	@RequestMapping("/MapView")
	public String MapView() {
		return "MapView";
	}

	@RequestMapping("/CompanyView")
	public String CompanyView() {
		return "CompanyView";
	}

	@RequestMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}

	@RequestMapping("/members")
	public String members() {
		return "members";
	}

	@RequestMapping("/technologies")
	public String technologies() {
		return "technologies";
	}

	@RequestMapping("/Graph1")
	public String Graph1() {
		return "Graph1";
	}

}

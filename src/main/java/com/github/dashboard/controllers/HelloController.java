package com.github.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/CompanyVsProductionByYearView")
	public String CompanyVsProductionByYearView() {
		return "CompanyVsProductionByYearView";
	}

	@RequestMapping("/About")
	public String AboutView() {
		return "About";
	}

	@RequestMapping("/StackBarD3")
	public String StackBarD3() {
		return "StackBarD3";
	}

	@RequestMapping("/county/{county}")
	public String specificCounty(@PathVariable String county) {
		return "County";
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

	@RequestMapping("/futurework")
	public String futurework() {
		return "futurework";
	}

}

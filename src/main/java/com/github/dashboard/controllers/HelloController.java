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

}

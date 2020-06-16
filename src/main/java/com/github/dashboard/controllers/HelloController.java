package com.github.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* <h1>Hello Controller (CVO)</h1>
* <p>This is the Spring Boot Controller for the base URLs. This takes the main base methods used
* and maps them to their complementary URLs.
* </p>
* 
*
* @author  FillINLater
* @version 1.0
* @since   2020-06-11
*/

@Controller
public class HelloController {

	/**
   * <h2>Index</h2>
   * <p>
   * This method links the index.html page to the URL /index.
   * 
   * </p>
   * 
   * @return This returns String "index" to link to the index page.
   */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/**
   * <h2>County Vs Oil Production By Year View</h2>
   * <p>
   * This method links the CountyVsOilProductionByYearView.html page to the URL /CountyVsOilProductionByYearView.
   * 
   * </p>
   * 
   * @return This returns String "CountyVsOilProductionByYearView" to link to the CountyVsOilProductionByYearView page.
   */
	@RequestMapping("/CountyVsOilProductionByYearView")
	public String CountyVsOilProductionByYearView() {
		return "CountyVsOilProductionByYearView";
	}
	/**
	* <h2>Map View</h2>
	* <p>
	* This method links the MapView.html page to the URL /MapView.
	* 
	* </p>
	* 
	* @return This returns String "MapView" to link to the MapView page.
	*/
	@RequestMapping("/MapView")
	public String MapView() {
		return "MapView";
	}

	/**
	* <h2>Company View</h2>
	* <p>
	* This method links the CompanyView.html page to the URL /CompanyView.
	* 
	* </p>
	* 
	* @return This returns String "CompanyView" to link to the CompanyView page.
	*/	
	@RequestMapping("/CompanyView")
	public String CompanyView() {
		return "CompanyView";
	}

}

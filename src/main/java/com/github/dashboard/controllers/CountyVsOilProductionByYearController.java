package com.github.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;
import com.github.dashboard.services.CountyVsOilProductionByYearService;


/**
* <h1>County Vs Oil Production By Year Controller (CVO Controller)</h1>
* <p>This is the Spring Boot Controller for CVO Controller. This maps the current
*requested methods to specified URLs.
* </p>
* 
*
* @author  FillINLater
* @version 1.0
* @since   2020-06-11
*/


@RestController
public class CountyVsOilProductionByYearController {

	@Autowired
	private CountyVsOilProductionByYearService countyVsOilProductionByYearService;

   /**
   * <h2>findAll()</h2>
   * <p>
   * This method invokes the findAll method from CVO Controller service and maps
   * it to the URL CountyVsOilProductionByYear.
   * </p>
   * 
   * @return This returns a List of all CVO Controller's.
   */
	@RequestMapping("/CountyVsOilProductionByYear")
	public List<CountyVsOilProductionByYearModel> findAll() {
		return countyVsOilProductionByYearService.findAll();
	}

   /**
   * <h2>findById()</h2>
   * <p>
   * This method invokes the findById method from CVO Controller service and maps
   * it to the URL CountyVsOilProductionByYear/id.
   * </p>
   * 
   * @return This returns a List of CVO Controller's filtered by Id.
   * @param id The id of the county, given by the user on the webpage. 
   */

	@RequestMapping("/CountyVsOilProductionByYear/{id}")
	public CountyVsOilProductionByYearModel findById(@PathVariable int id) {
		return countyVsOilProductionByYearService.findById(id);
	}

	   /**
   * <h2>findById()</h2>
   * <p>
   * This method invokes the findByCounty method from CVO Controller service and maps
   * it to the URL CountyVsOilProductionByYear/county.
   * </p>
   * 
   * @return This returns a List of CVO Controller's filtered by County.
   * @param county The name of the county, given by the user on the webpage.
   */
	@RequestMapping("/CountyVsOilProductionByYear/filter/county/{county}")
	public List<CountyVsOilProductionByYearModel> findByCounty(@PathVariable String county) {
		return countyVsOilProductionByYearService.findByCounty(county);

	}

   /**
   * <h2>findById()</h2>
   * <p>
   * This method invokes the findByYear method from CVO Controller service and maps
   * it to the URL CountyVsOilProductionByYear/year.
   * </p>
   * 
   * @return This returns a List of CVO Controller's filtered by year.
   * @param year The year the information was recorded, given by the user on the webpage.
   */
	@RequestMapping("/CountyVsOilProductionByYear/filter/year/{year}")
	public List<CountyVsOilProductionByYearModel> findByYear(@PathVariable int year) {
		return countyVsOilProductionByYearService.findByYear(year);
	}

   /**
   * <h2>findByOilProductionGreaterThanEqual()</h2>
   * <p>
   * This method invokes the findByOilProductionGreaterThanEqual method from CVO Controller service and maps
   * it to the URL OilProductionThanEqual/oilProduction.
   * </p>
   * @param oilProduction This is a double representing the amount of Oil Production for a county
   * @return This returns a List of CVO Controller's filtered by production greater then or equal to given double, given by the user on the webpage.
   */
	@RequestMapping("/CountyVsOilProductionByYear/filter/oilproductiongreaterthan/{oilProduction}")
	public List<CountyVsOilProductionByYearModel> findByOilProductionGreaterThanEqual(
			@PathVariable double oilProduction) {
		return countyVsOilProductionByYearService.findByOilProductionGreaterThanEqual(oilProduction);
	}

   /**
   * <h2>findByOilProductionLessThanEqual()</h2>
   * <p>
   * This method invokes the findByOilProductionLessThanEqual method from CVO Controller service and maps
   * it to the URL CountyVsOilProductionByYear/oilProduction.
   * </p>
   * @param oilProduction This is a double representing the amount of Oil Production for a county
   * @return This returns a List of CVO Controller's filtered by production less then or equal to given double.
   */

	@RequestMapping("/CountyVsOilProductionByYear/filter/oilproductionlessthan/{oilProduction}")
	public List<CountyVsOilProductionByYearModel> findByOilProductionLessThanEqual(@PathVariable double oilProduction) {
		return countyVsOilProductionByYearService.findByOilProductionLessThanEqual(oilProduction);
	}

}

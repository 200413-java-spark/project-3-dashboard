package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
* <h1>County Vs Oil Production By Year Model (CVO Model)</h1>
* <p>This is the Spring Boot Controller for CVO Model. This class is used
*to encode data from the database into a java friendly format. Generally used in
*lists to gather all counties either by Year, Production Rate, Id, or County Name.
* </p>
* 
*
* @author  FillINLater
* @version 1.0
* @since   2020-06-11
*/

@Entity(name = "CountyVsOilProductionByYear")
public class CountyVsOilProductionByYearModel {
	/**
	 * <p>
	 * The unique id of the County
	 * </p>
	 */
	@Id
	private int id;

	/**
	 * <p>
	 * The name of the County
	 * </p>
	 */	
	private String county;
	/**
	 * <p>
	 * The amount of Oil Produced by the county
	 * </p>
	 */
	private double oilProduction;
	/**
	 * <p>
	 * The year the information was recorded
	 * </p>
	 */
	private int year;

		/**
	 * <p>
	 * The Default Constructor
	 * </p>
	 */
	public CountyVsOilProductionByYearModel() {
	}

	/**
	 * <p>
	 * The Overloaded Constructor. Creates a new COV Model with a county name, oil_production, and year
	 * </p>
	 * @param county The name of the County
	 * @param year The Year the information was recorded
	 * @param oil_production The amount of Oil Produced by that County
	 */
	public CountyVsOilProductionByYearModel(String county, double oil_production, int year) {
		this.county = county;
		this.oilProduction = oil_production;
		this.year = year;
	}

	/**
	 * @return String This returns the County's name 
	 */
	public String getCounty() {
		return county;
	}
	/**
	* <p>
	* This method Sets the County's name
	* </p>
	*/
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * @return double This returns the amount of oil produced by the county 
	 */
	public double getOil_production() {
		return oilProduction;
	}
	/**
	* <p>
	* This method Sets the County's Oil Production
	* </p>
	*/
	public void setOil_production(double oil_production) {
		this.oilProduction = oil_production;
	}
	/**
	 * @return String This returns the Year the information was recorded 
	 */
	public int getYear() {
		return year;
	}

	/**
	* <p>
	* This method Sets the County's Year
	* </p>
	*/
	public void setYear(int year) {
		this.year = year;
	}
}

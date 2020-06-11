package com.github.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;

/**
* <h1>County Vs Oil Production By Year Repository (CVO Repository)</h1>
* <p>This Class acts as the main connection between the COV Controller and the COV Service classes.
* </p>
* 
*
* @author  FillINLater
* @version 1.0
* @since   2020-06-11
*/

@Repository
public interface CountyVsOilProductionByYearRepo extends JpaRepository<CountyVsOilProductionByYearModel, Integer> {
	
	List<CountyVsOilProductionByYearModel> findByCounty(String county);
	
	List<CountyVsOilProductionByYearModel> findByYear(int year);
	
	List<CountyVsOilProductionByYearModel> findByOilProductionGreaterThanEqual(double oilProduction);
	
	List<CountyVsOilProductionByYearModel> findByOilProductionLessThanEqual(double oilProduction);
}

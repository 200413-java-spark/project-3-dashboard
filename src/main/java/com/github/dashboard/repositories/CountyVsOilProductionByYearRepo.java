package com.github.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;

@Repository
public interface CountyVsOilProductionByYearRepo extends JpaRepository<CountyVsOilProductionByYearModel, Integer> {
	
	List<CountyVsOilProductionByYearModel> findByCounty(String county);
	
	List<CountyVsOilProductionByYearModel> findByYear(int year);
	
	List<CountyVsOilProductionByYearModel> findByOilProductionGreaterThanEqual(double oilProduction);
	
	List<CountyVsOilProductionByYearModel> findByOilProductionLessThanEqual(double oilProduction);
}

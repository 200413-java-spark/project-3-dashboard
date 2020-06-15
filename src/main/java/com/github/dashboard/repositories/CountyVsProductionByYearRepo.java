package com.github.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CountyVsProductionByYearModel;

@Repository
public interface CountyVsProductionByYearRepo extends JpaRepository<CountyVsProductionByYearModel, Integer> {
	
	List<CountyVsProductionByYearModel> findByCounty(String county);
	
	List<CountyVsProductionByYearModel> findByYear(int year);
	
	List<CountyVsProductionByYearModel> findByOilProductionGreaterThanEqual(double oilProduction);
	
	List<CountyVsProductionByYearModel> findByOilProductionLessThanEqual(double oilProduction);
}

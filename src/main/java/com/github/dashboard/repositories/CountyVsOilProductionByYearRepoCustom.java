package com.github.dashboard.repositories;

import java.util.List;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;

public interface CountyVsOilProductionByYearRepoCustom {
	
	public List<CountyVsOilProductionByYearModel> getByCounty(String county);
	
	public List<CountyVsOilProductionByYearModel> getByYear(int year);
}


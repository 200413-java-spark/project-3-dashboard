package com.github.dashboard.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;

@Repository
public class CountyVsOilProductionByYearRepoImpl implements CountyVsOilProductionByYearRepoCustom{
	
	@PersistenceContext
	EntityManager entityManager;

	public List<CountyVsOilProductionByYearModel> getByCounty(String county) {
		TypedQuery<CountyVsOilProductionByYearModel> query = 
				entityManager.createNamedQuery("getByCounty", CountyVsOilProductionByYearModel.class)
				.setParameter(1, county + "%");
		
		return query.getResultList();
	}
	
	public List<CountyVsOilProductionByYearModel> getByYear(int year) {
		TypedQuery<CountyVsOilProductionByYearModel> query = 
				entityManager.createNamedQuery("getByYear", CountyVsOilProductionByYearModel.class)
				.setParameter(1, year);
		
		return query.getResultList();
	}

}

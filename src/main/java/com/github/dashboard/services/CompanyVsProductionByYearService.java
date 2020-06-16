package com.github.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dashboard.models.CompanyVsProductionByYearModel;
import com.github.dashboard.repositories.CompanyVsProductionByYearRepo;

@Service
public class CompanyVsProductionByYearService {
	
	@Autowired
	private CompanyVsProductionByYearRepo companyVsProductionByYearRepo;
	
	public List<CompanyVsProductionByYearModel> findAll() {
		return companyVsProductionByYearRepo.findAll();
	}	
}

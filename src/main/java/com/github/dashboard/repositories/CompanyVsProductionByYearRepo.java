package com.github.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CompanyVsProductionByYearModel;

@Repository
public interface CompanyVsProductionByYearRepo extends JpaRepository<CompanyVsProductionByYearModel, Integer> {

}

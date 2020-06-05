package com.github.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CountyVsOilProductionByYearModel;

@Repository
public interface CountyVsOilProductionByYearRepo extends JpaRepository<CountyVsOilProductionByYearModel, Integer>, CountyVsOilProductionByYearRepoCustom{


}

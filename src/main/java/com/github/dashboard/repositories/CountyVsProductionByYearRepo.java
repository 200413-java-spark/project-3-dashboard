package com.github.dashboard.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dashboard.models.CountyVsProductionByYearModel;

@Repository
public interface CountyVsProductionByYearRepo extends JpaRepository<CountyVsProductionByYearModel, Integer> {

}

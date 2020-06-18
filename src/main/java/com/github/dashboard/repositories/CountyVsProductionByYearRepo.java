package com.github.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.github.dashboard.models.CountyVsProductionByYearModel;

@Repository
public interface CountyVsProductionByYearRepo extends JpaRepository<CountyVsProductionByYearModel, Integer> {
  List<CountyVsProductionByYearModel> findByCounty(String county);

  List<CountyVsProductionByYearModel> findByreportingyear(String year);

  // List<CountyVsProductionByYearModel>
  // findByOilProductionGreaterThanEqual(double oilProduction);

  // List<CountyVsProductionByYearModel> findByOilProductionLessThanEqual(double
  // oilProduction);
}

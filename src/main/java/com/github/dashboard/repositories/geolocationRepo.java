package com.github.dashboard.repositories;

import java.util.List;

import com.github.dashboard.models.geolocationModel;

import org.hibernate.internal.util.type.PrimitiveWrapperHelper.IntegerDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface geolocationRepo extends JpaRepository<geolocationModel, IntegerDescriptor> {
  List<geolocationModel> findAll();

  @Query(value = "select longitude, latitude, town, county, year, id, coalesce(gas,'0') as gas, coalesce(water,'0') as water, coalesce(oil,'0') as oil from locationyearly", nativeQuery = true)
  List<geolocationModel> findAllNotNull();
}
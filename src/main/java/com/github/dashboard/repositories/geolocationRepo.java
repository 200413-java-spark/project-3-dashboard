package com.github.dashboard.repositories;

import java.util.List;

import com.github.dashboard.models.geolocationModel;

import org.hibernate.internal.util.type.PrimitiveWrapperHelper.IntegerDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface geolocationRepo extends JpaRepository<geolocationModel, IntegerDescriptor> {

  List<geolocationModel> findAll();
}
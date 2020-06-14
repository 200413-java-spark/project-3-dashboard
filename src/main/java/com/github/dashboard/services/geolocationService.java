package com.github.dashboard.services;

import java.util.List;

import com.github.dashboard.models.geolocationModel;
import com.github.dashboard.repositories.geolocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class geolocationService {
  @Autowired
  private geolocationRepo GeolocationRepo;

  public List<geolocationModel> findAll() {
    return GeolocationRepo.findAll();
  }
}
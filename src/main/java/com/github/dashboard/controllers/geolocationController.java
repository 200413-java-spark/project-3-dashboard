package com.github.dashboard.controllers;

import java.util.List;

import com.github.dashboard.models.geolocationModel;
import com.github.dashboard.services.geolocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class geolocationController {

  @Nullable
  @Autowired
  private geolocationService GeolocationService;

  @RequestMapping("/geolocation")
  public List<geolocationModel> findAll() {
    return GeolocationService.findAll();
  }

  @RequestMapping("/geolocationNotNull")
  public List<geolocationModel> findAllNotNull() {
    return GeolocationService.findAllNotNull();
  }
}
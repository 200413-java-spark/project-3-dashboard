package com.github.dashboard.controllers;

import java.util.List;

import com.github.dashboard.models.geolocationModel;
import com.github.dashboard.services.geolocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class geolocationController {

  @Autowired
  private geolocationService GeolocationService;

  @RequestMapping("/geolocation")
  public List<geolocationModel> findAll() {
    return GeolocationService.findAll();
  }
}
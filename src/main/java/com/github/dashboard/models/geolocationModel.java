package com.github.dashboard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

@Entity(name = "locationyearly")
public class geolocationModel {
  @Id
  private Integer id;
  private String county;
  private String town;

  private Double longitude;

  private Double latitude;

  @Column(nullable = true)
  private String gas;

  @Column(nullable = true)
  private String oil;

  @Column(nullable = true)
  private String water;

  private Integer year;

  public geolocationModel() {

  }

  public geolocationModel(String county, String town, Double latitude, Double longitude, String gas, String water,
      String oil, Integer year) {
    this.county = county;
    this.town = town;
    this.longitude = longitude;
    this.latitude = latitude;
    this.gas = gas;
    this.oil = oil;
    this.water = water;
    this.year = year;
  }

  public String getCounty() {
    return county;
  }

  public String getTown() {
    return town;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Integer getYear() {
    return year;
  }

  @Nullable
  public String getGas() {
    return gas;
  }

  @Nullable
  public String getOil() {
    return oil;
  }

  @Nullable
  public String getWater() {
    return water;
  }
}
package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "latlongyearly")
public class geolocationModel {
  @Id
  // private int id;
  private String county;
  private String city;
  private double longitude;
  private double latitude;
  private double gas;
  private double oil;
  private double water;
  private int year;

  public geolocationModel() {

  }

  public geolocationModel(String county, String city, double longitude, double latitude, double gas, double oil,
      double water, int year) {
    this.county = county;
    this.city = city;
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

  public String getCity() {
    return city;
  }

  public double getLongitude() {
    return longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public int getYear() {
    return year;
  }

  public double getGas() {
    return gas;
  }

  public double getOil() {
    return oil;
  }

  public double getWater() {
    return water;
  }
}
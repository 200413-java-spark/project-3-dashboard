package com.github.dashboard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "geolocation")
public class geolocationModel {
  @Id
  private int id;

  private String county;
  private String city;
  private double longitude;
  private double latitude;
  private int year;

  public geolocationModel() {

  }

  public geolocationModel(String county, String city, double longitude, double latitude, int year) {
    this.county = county;
    this.city = city;
    this.longitude = longitude;
    this.latitude = latitude;
    this.year = year;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

}
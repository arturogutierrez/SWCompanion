package com.arturogutierrez.swcompanion.data.net.model;

import java.util.List;

public class PeopleApiModel {

  String peopleId;
  String name;
  String gender;
  String height;
  String mass;
  String url;

  List<String> films;
  List<String> species;
  List<String> starships;
  List<String> vehicles;

  public String getPeopleId() {
    return peopleId;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public String getHeight() {
    return height;
  }

  public String getMass() {
    return mass;
  }

  public String getUrl() {
    return url;
  }

  public List<String> getFilms() {
    return films;
  }

  public List<String> getSpecies() {
    return species;
  }

  public List<String> getStarships() {
    return starships;
  }

  public List<String> getVehicles() {
    return vehicles;
  }
}

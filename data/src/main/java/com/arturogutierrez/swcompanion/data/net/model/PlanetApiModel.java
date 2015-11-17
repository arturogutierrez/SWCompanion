package com.arturogutierrez.swcompanion.data.net.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PlanetApiModel {

  String planetId;
  String name;
  String diameter;
  String gravity;
  String population;
  String url;

  @SerializedName("rotation_period")
  String rotationPeriodHours;

  @SerializedName("orbital_period")
  String orbitalPeriodDays;

  List<String> films;
  List<String> residents;

  public String getPlanetId() {
    return planetId;
  }

  public String getName() {
    return name;
  }

  public String getDiameter() {
    return diameter;
  }

  public String getGravity() {
    return gravity;
  }

  public String getPopulation() {
    return population;
  }

  public String getUrl() {
    return url;
  }

  public String getRotationPeriodHours() {
    return rotationPeriodHours;
  }

  public String getOrbitalPeriodDays() {
    return orbitalPeriodDays;
  }

  public List<String> getFilms() {
    return films;
  }

  public List<String> getResidents() {
    return residents;
  }
}

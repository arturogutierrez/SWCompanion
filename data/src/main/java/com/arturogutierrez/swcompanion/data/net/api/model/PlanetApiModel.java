package com.arturogutierrez.swcompanion.data.net.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class PlanetApiModel {

  String name;
  String diameter;
  String gravity;
  String population;
  String url;
  @SerializedName("rotation_period")
  String rotationPeriodHours;
  @SerializedName("orbital_period")
  String orbitalPeriodDays;
  @SerializedName("created")
  Date createdAt;
  @SerializedName("edited")
  Date updatedAt;

  List<String> films;
  List<String> residents;

  public PlanetApiModel(String name, String diameter, String gravity, String population, String url,
      String rotationPeriodHours, String orbitalPeriodDays, Date createdAt, Date updatedAt,
      List<String> films, List<String> residents) {
    this.name = name;
    this.diameter = diameter;
    this.gravity = gravity;
    this.population = population;
    this.url = url;
    this.rotationPeriodHours = rotationPeriodHours;
    this.orbitalPeriodDays = orbitalPeriodDays;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.films = films;
    this.residents = residents;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }
}

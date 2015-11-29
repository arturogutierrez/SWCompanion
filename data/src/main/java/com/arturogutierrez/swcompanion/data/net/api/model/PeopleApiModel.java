package com.arturogutierrez.swcompanion.data.net.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class PeopleApiModel {

  String name;
  String gender;
  String height;
  String mass;
  String homeworld;
  String url;
  @SerializedName("created")
  Date createdAt;
  @SerializedName("edited")
  Date updatedAt;

  List<String> films;
  List<String> species;
  List<String> starships;
  List<String> vehicles;

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

  public String getHomeworld() {
    return homeworld;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }
}

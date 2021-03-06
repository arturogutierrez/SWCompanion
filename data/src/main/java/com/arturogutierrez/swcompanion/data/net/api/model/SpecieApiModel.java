package com.arturogutierrez.swcompanion.data.net.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class SpecieApiModel {

  String name;
  String classification;
  String designation;
  @SerializedName("average_height")
  String averageHeight;
  @SerializedName("average_lifespan")
  String averageLifespan;
  @SerializedName("eye_colors")
  String eyeColors;
  @SerializedName("hair_colors")
  String hairColors;
  @SerializedName("skin_colors")
  String skinColors;
  String language;
  String homeworld;
  String url;
  @SerializedName("created")
  Date createdAt;
  @SerializedName("edited")
  Date updatedAt;

  List<String> films;
  List<String> people;

  public SpecieApiModel(String name, String classification, String designation,
      String averageHeight, String averageLifespan, String eyeColors, String hairColors,
      String skinColors, String language, String homeworld, String url, Date createdAt,
      Date updatedAt, List<String> films, List<String> people) {
    this.name = name;
    this.classification = classification;
    this.designation = designation;
    this.averageHeight = averageHeight;
    this.averageLifespan = averageLifespan;
    this.eyeColors = eyeColors;
    this.hairColors = hairColors;
    this.skinColors = skinColors;
    this.language = language;
    this.homeworld = homeworld;
    this.url = url;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.films = films;
    this.people = people;
  }

  public String getName() {
    return name;
  }

  public String getClassification() {
    return classification;
  }

  public String getDesignation() {
    return designation;
  }

  public String getAverageHeight() {
    return averageHeight;
  }

  public String getAverageLifespan() {
    return averageLifespan;
  }

  public String getEyeColors() {
    return eyeColors;
  }

  public String getHairColors() {
    return hairColors;
  }

  public String getSkinColors() {
    return skinColors;
  }

  public String getLanguage() {
    return language;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public String getUrl() {
    return url;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public List<String> getFilms() {
    return films;
  }

  public List<String> getPeople() {
    return people;
  }
}

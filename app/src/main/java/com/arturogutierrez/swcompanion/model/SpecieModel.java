package com.arturogutierrez.swcompanion.model;

import java.util.List;

public class SpecieModel extends ItemModel {

  private final String specieId;
  private final String name;
  private final String classification;
  private final String designation;
  private final float averageHeight;
  private final int averageLifespan;
  private final String eyeColors;
  private final String hairColors;
  private final String skinColors;
  private final String language;
  private final String homeworld;
  private final List<FilmModel> films;
  private final List<PeopleModel> people;

  public SpecieModel(String specieId, String name, String classification, String designation,
      float averageHeight, int averageLifespan, String eyeColors, String hairColors,
      String skinColors, String language, String homeworld, List<FilmModel> films,
      List<PeopleModel> people, String mediaURL, boolean dirty, long updatedAt, long createdAt) {
    super(mediaURL, dirty, updatedAt, createdAt);

    this.specieId = specieId;
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
    this.films = films;
    this.people = people;
  }

  public String getSpecieId() {
    return specieId;
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

  public float getAverageHeight() {
    return averageHeight;
  }

  public int getAverageLifespan() {
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

  public List<FilmModel> getFilms() {
    return films;
  }

  public List<PeopleModel> getPeople() {
    return people;
  }
}

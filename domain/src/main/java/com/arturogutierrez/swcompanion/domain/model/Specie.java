package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Specie extends Item {

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
  private final Planet homeworld;
  private final List<Film> films;
  private final List<People> people;

  public Specie(String specieId, String name, String classification, String designation,
      float averageHeight, int averageLifespan, String eyeColors, String hairColors,
      String skinColors, String language, Planet homeworld, List<Film> films, List<People> people,
      boolean dirty, long updatedAt, long createdAt) {
    super(dirty, updatedAt, createdAt);

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

  public Specie(String specieId) {
    super();

    this.specieId = specieId;
    this.name = null;
    this.classification = null;
    this.designation = null;
    this.averageHeight = 0f;
    this.averageLifespan = 0;
    this.eyeColors = null;
    this.hairColors = null;
    this.skinColors = null;
    this.language = null;
    this.homeworld = null;
    this.films = null;
    this.people = null;
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

  public Planet getHomeworld() {
    return homeworld;
  }

  public List<Film> getFilms() {
    return films;
  }

  public List<People> getPeople() {
    return people;
  }
}

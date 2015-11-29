package com.arturogutierrez.swcompanion.model;

import java.util.List;

public class PlanetModel extends ItemModel {

  private final String planetId;
  private final String name;
  private final int diameter;
  private final float gravity;
  private final long population;
  private final int rotationPeriodHours;
  private final int orbitalPeriodDays;
  private final List<FilmModel> films;
  private final List<PeopleModel> residents;

  public PlanetModel(String planetId, String name, int diameter, float gravity, long population,
      int rotationPeriodHours, int orbitalPeriodDays, List<FilmModel> films,
      List<PeopleModel> residents, boolean dirty, long updatedAt, long createdAt) {
    super(dirty, updatedAt, createdAt);

    this.planetId = planetId;
    this.name = name;
    this.diameter = diameter;
    this.gravity = gravity;
    this.population = population;
    this.rotationPeriodHours = rotationPeriodHours;
    this.orbitalPeriodDays = orbitalPeriodDays;
    this.films = films;
    this.residents = residents;
  }

  public String getPlanetId() {
    return planetId;
  }

  public String getName() {
    return name;
  }

  public int getDiameter() {
    return diameter;
  }

  public float getGravity() {
    return gravity;
  }

  public long getPopulation() {
    return population;
  }

  public int getRotationPeriodHours() {
    return rotationPeriodHours;
  }

  public int getOrbitalPeriodDays() {
    return orbitalPeriodDays;
  }

  public List<FilmModel> getFilms() {
    return films;
  }

  public List<PeopleModel> getResidents() {
    return residents;
  }
}

package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Planet extends Item {

  private final String planetId;
  private final String name;
  private final int diameter;
  private final float gravity;
  private final long population;
  private final int rotationPeriodHours;
  private final int orbitalPeriodDays;
  private final List<Film> films;
  private final List<People> residents;

  public Planet(String planetId, String name, int diameter, float gravity, long population,
      int rotationPeriodHours, int orbitalPeriodDays, List<Film> films, List<People> residents,
      String mediaURL, boolean dirty, long updatedAt, long createdAt) {
    super(mediaURL, dirty, updatedAt, createdAt);

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

  public Planet(String planetId) {
    super();

    this.planetId = planetId;
    this.name = null;
    this.diameter = 0;
    this.gravity = 0f;
    this.population = 0;
    this.rotationPeriodHours = 0;
    this.orbitalPeriodDays = 0;
    this.films = null;
    this.residents = null;
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

  public List<Film> getFilms() {
    return films;
  }

  public List<People> getResidents() {
    return residents;
  }
}

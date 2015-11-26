package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Planet {

  private final String planetId;
  private final String name;
  private final int diameter;
  private final float gravity;
  private final long population;
  private final int rotationPeriodHours;
  private final int orbitalPeriodDays;
  private final List<Film> films;
  private final List<People> residents;
  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  public Planet(String planetId, String name, int diameter, float gravity, long population,
      int rotationPeriodHours, int orbitalPeriodDays, List<Film> films, List<People> residents,
      boolean dirty, long updatedAt, long createdAt) {
    this.planetId = planetId;
    this.name = name;
    this.diameter = diameter;
    this.gravity = gravity;
    this.population = population;
    this.rotationPeriodHours = rotationPeriodHours;
    this.orbitalPeriodDays = orbitalPeriodDays;
    this.films = films;
    this.residents = residents;
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
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

  public boolean isDirty() {
    return dirty;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public long getCreatedAt() {
    return createdAt;
  }
}

package com.arturogutierrez.swcompanion.data.entity;

import java.math.BigInteger;

public class PlanetEntity {

  private final String planetId;
  private final String name;
  private final int rotationPeriodHours;
  private final int orbitalPeriodDays;
  private final String gravity;
  private final BigInteger population;

  public PlanetEntity(String planetId, String name, int rotationPeriodHours, int orbitalPeriodDays,
      String gravity, BigInteger population) {
    this.planetId = planetId;
    this.name = name;
    this.rotationPeriodHours = rotationPeriodHours;
    this.orbitalPeriodDays = orbitalPeriodDays;
    this.gravity = gravity;
    this.population = population;
  }

  public String getPlanetId() {
    return planetId;
  }

  public String getName() {
    return name;
  }

  public int getRotationPeriodHours() {
    return rotationPeriodHours;
  }

  public int getOrbitalPeriodDays() {
    return orbitalPeriodDays;
  }

  public String getGravity() {
    return gravity;
  }

  public BigInteger getPopulation() {
    return population;
  }
}

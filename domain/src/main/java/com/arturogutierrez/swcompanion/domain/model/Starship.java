package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Starship {

  private final String starshipId;
  private final String name;
  private final String model;
  private final String starshipClass;
  private final String manufacturer;
  private final long costInCredits;
  private final int length;
  private final int crewNumber;
  private final int passengersNumber;
  private final List<Film> films;
  private final List<People> pilots;
  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  public Starship(String starshipId, String name, String model, String starshipClass,
      String manufacturer, long costInCredits, int length, int crewNumber, int passengersNumber,
      List<Film> films, List<People> pilots, boolean dirty, long updatedAt, long createdAt) {
    this.starshipId = starshipId;
    this.name = name;
    this.model = model;
    this.starshipClass = starshipClass;
    this.manufacturer = manufacturer;
    this.costInCredits = costInCredits;
    this.length = length;
    this.crewNumber = crewNumber;
    this.passengersNumber = passengersNumber;
    this.films = films;
    this.pilots = pilots;
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
  }

  public String getStarshipId() {
    return starshipId;
  }

  public String getName() {
    return name;
  }

  public String getModel() {
    return model;
  }

  public String getStarshipClass() {
    return starshipClass;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public long getCostInCredits() {
    return costInCredits;
  }

  public int getLength() {
    return length;
  }

  public int getCrewNumber() {
    return crewNumber;
  }

  public int getPassengersNumber() {
    return passengersNumber;
  }

  public List<Film> getFilms() {
    return films;
  }

  public List<People> getPilots() {
    return pilots;
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

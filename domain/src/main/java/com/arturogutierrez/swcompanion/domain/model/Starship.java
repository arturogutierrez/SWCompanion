package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Starship extends Item {

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

  public Starship(String starshipId, String name, String model, String starshipClass,
      String manufacturer, long costInCredits, int length, int crewNumber, int passengersNumber,
      List<Film> films, List<People> pilots, boolean dirty, long updatedAt, long createdAt) {
    super(dirty, updatedAt, createdAt);

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
  }

  public Starship(String starshipId) {
    super();

    this.starshipId = starshipId;
    this.name = null;
    this.model = null;
    this.starshipClass = null;
    this.manufacturer = null;
    this.costInCredits = 0L;
    this.length = 0;
    this.crewNumber = 0;
    this.passengersNumber = 0;
    this.films = null;
    this.pilots = null;
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
}

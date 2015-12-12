package com.arturogutierrez.swcompanion.model;

import java.util.List;

public class StarshipModel extends ItemModel {

  private final String starshipId;
  private final String name;
  private final String model;
  private final String starshipClass;
  private final String manufacturer;
  private final long costInCredits;
  private final int length;
  private final int crewNumber;
  private final int passengersNumber;
  private final List<FilmModel> films;
  private final List<PeopleModel> pilots;

  public StarshipModel(String starshipId, String name, String model, String starshipClass,
      String manufacturer, long costInCredits, int length, int crewNumber, int passengersNumber,
      List<FilmModel> films, List<PeopleModel> pilots, String mediaURL, boolean dirty,
      long updatedAt, long createdAt) {
    super(mediaURL, dirty, updatedAt, createdAt);

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

  public List<FilmModel> getFilms() {
    return films;
  }

  public List<PeopleModel> getPilots() {
    return pilots;
  }
}

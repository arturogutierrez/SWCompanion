package com.arturogutierrez.swcompanion.model;

import java.util.List;

public class PeopleModel extends ItemModel {

  private final String peopleId;
  private final String name;
  private final String gender;
  private final int height;
  private final int mass;
  private final PlanetModel homeworld;
  private final List<FilmModel> films;
  private final List<SpecieModel> species;
  private final List<StarshipModel> starships;
  private final List<VehicleModel> vehicles;

  public PeopleModel(String peopleId, String name, String gender, int height, int mass,
      PlanetModel homeworld, List<FilmModel> films, List<SpecieModel> species,
      List<StarshipModel> starships, List<VehicleModel> vehicles, String mediaURL, boolean dirty,
      long updatedAt, long createdAt) {
    super(mediaURL, dirty, updatedAt, createdAt);

    this.peopleId = peopleId;
    this.name = name;
    this.gender = gender;
    this.height = height;
    this.mass = mass;
    this.homeworld = homeworld;
    this.films = films;
    this.species = species;
    this.starships = starships;
    this.vehicles = vehicles;
  }

  public String getPeopleId() {
    return peopleId;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public int getHeight() {
    return height;
  }

  public int getMass() {
    return mass;
  }

  public PlanetModel getHomeworld() {
    return homeworld;
  }

  public List<FilmModel> getFilms() {
    return films;
  }

  public List<SpecieModel> getSpecies() {
    return species;
  }

  public List<StarshipModel> getStarships() {
    return starships;
  }

  public List<VehicleModel> getVehicles() {
    return vehicles;
  }
}

package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class People extends Item {

  private final String peopleId;
  private final String name;
  private final String gender;
  private final int height;
  private final int mass;
  private final Planet homeworld;
  private final List<Film> films;
  private final List<Specie> species;
  private final List<Starship> starships;
  private final List<Vehicle> vehicles;

  public People(String peopleId, String name, String gender, int height, int mass, Planet homeworld,
      List<Film> films, List<Specie> species, List<Starship> starships, List<Vehicle> vehicles,
      boolean dirty, long updatedAt, long createdAt) {
    super(dirty, updatedAt, createdAt);

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

  public Planet getHomeworld() {
    return homeworld;
  }

  public List<Film> getFilms() {
    return films;
  }

  public List<Specie> getSpecies() {
    return species;
  }

  public List<Starship> getStarships() {
    return starships;
  }

  public List<Vehicle> getVehicles() {
    return vehicles;
  }
}

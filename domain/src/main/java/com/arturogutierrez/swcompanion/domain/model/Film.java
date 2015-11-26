package com.arturogutierrez.swcompanion.domain.model;

import java.util.Date;
import java.util.List;

public class Film {

  private final String filmId;
  private final String title;
  private final int episode;
  private final String openingCrawl;
  private final String producer;
  private final Date releaseDate;
  private final List<People> characters;
  private final List<Planet> planets;
  private final List<Specie> species;
  private final List<Starship> starships;
  private final List<Vehicle> vehicles;
  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  public Film(String filmId, String title, int episode, String openingCrawl, String producer,
      Date releaseDate, List<People> characters, List<Planet> planets,
      List<Specie> species, List<Starship> starships, List<Vehicle> vehicles,
      boolean dirty, long updatedAt, long createdAt) {
    this.filmId = filmId;
    this.title = title;
    this.episode = episode;
    this.openingCrawl = openingCrawl;
    this.producer = producer;
    this.releaseDate = releaseDate;
    this.characters = characters;
    this.planets = planets;
    this.species = species;
    this.starships = starships;
    this.vehicles = vehicles;
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
  }

  public String getFilmId() {
    return filmId;
  }

  public String getTitle() {
    return title;
  }

  public int getEpisode() {
    return episode;
  }

  public String getOpeningCrawl() {
    return openingCrawl;
  }

  public String getProducer() {
    return producer;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public List<People> getCharacters() {
    return characters;
  }

  public List<Planet> getPlanets() {
    return planets;
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

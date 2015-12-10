package com.arturogutierrez.swcompanion.domain.model;

import java.util.Date;
import java.util.List;

public class Film extends Item {

  private final String filmId;
  private final String title;
  private final String director;
  private final int episode;
  private final String openingCrawl;
  private final String producer;
  private final Date releaseDate;
  private final List<People> characters;
  private final List<Planet> planets;
  private final List<Specie> species;
  private final List<Starship> starships;
  private final List<Vehicle> vehicles;

  public Film(String filmId, String title, String director, int episode, String openingCrawl,
      String producer, Date releaseDate, List<People> characters, List<Planet> planets,
      List<Specie> species, List<Starship> starships, List<Vehicle> vehicles, String mediaURL,
      boolean dirty, long updatedAt, long createdAt) {
    super(mediaURL, dirty, updatedAt, createdAt);

    this.filmId = filmId;
    this.title = title;
    this.director = director;
    this.episode = episode;
    this.openingCrawl = openingCrawl;
    this.producer = producer;
    this.releaseDate = releaseDate;
    this.characters = characters;
    this.planets = planets;
    this.species = species;
    this.starships = starships;
    this.vehicles = vehicles;
  }

  public Film(String filmId) {
    super();

    this.filmId = filmId;
    this.title = null;
    this.director = null;
    this.episode = 0;
    this.openingCrawl = null;
    this.producer = null;
    this.releaseDate = null;
    this.characters = null;
    this.planets = null;
    this.species = null;
    this.starships = null;
    this.vehicles = null;
  }

  public String getFilmId() {
    return filmId;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
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
}

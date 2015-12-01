package com.arturogutierrez.swcompanion.model;

import java.util.Date;
import java.util.List;

public class FilmModel extends ItemModel {

  private final String filmId;
  private final String title;
  private final String director;
  private final int episode;
  private final String openingCrawl;
  private final String producer;
  private final Date releaseDate;
  private final List<PeopleModel> characters;
  private final List<PlanetModel> planets;
  private final List<SpecieModel> species;
  private final List<StarshipModel> starships;
  private final List<VehicleModel> vehicles;

  public FilmModel(String filmId, String title, String director, int episode, String openingCrawl,
      String producer, Date releaseDate, List<PeopleModel> characters, List<PlanetModel> planets,
      List<SpecieModel> species, List<StarshipModel> starships, List<VehicleModel> vehicles,
      boolean dirty, long updatedAt, long createdAt) {
    super(dirty, updatedAt, createdAt);

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

  public List<PeopleModel> getCharacters() {
    return characters;
  }

  public List<PlanetModel> getPlanets() {
    return planets;
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

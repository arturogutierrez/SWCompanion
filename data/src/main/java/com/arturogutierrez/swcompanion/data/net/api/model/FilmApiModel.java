package com.arturogutierrez.swcompanion.data.net.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class FilmApiModel {

  String title;
  String director;
  @SerializedName("episode_id")
  String episode;
  @SerializedName("opening_crawl")
  String openingCrawl;
  String producer;
  @SerializedName("release_date")
  Date releaseDate;
  String url;
  @SerializedName("created")
  Date createdAt;
  @SerializedName("edited")
  Date updatedAt;

  List<String> characters;
  List<String> planets;
  List<String> species;
  List<String> starships;
  List<String> vehicles;

  public FilmApiModel(String title, String director, String episode, String openingCrawl,
      String producer, Date releaseDate, String url, Date createdAt, Date updatedAt,
      List<String> characters, List<String> planets, List<String> species, List<String> starships,
      List<String> vehicles) {
    this.title = title;
    this.director = director;
    this.episode = episode;
    this.openingCrawl = openingCrawl;
    this.producer = producer;
    this.releaseDate = releaseDate;
    this.url = url;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.characters = characters;
    this.planets = planets;
    this.species = species;
    this.starships = starships;
    this.vehicles = vehicles;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public String getEpisode() {
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

  public String getUrl() {
    return url;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public List<String> getCharacters() {
    return characters;
  }

  public List<String> getPlanets() {
    return planets;
  }

  public List<String> getSpecies() {
    return species;
  }

  public List<String> getStarships() {
    return starships;
  }

  public List<String> getVehicles() {
    return vehicles;
  }
}

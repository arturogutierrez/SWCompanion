package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.util.Date;

public class RealmFilm extends RealmObject {

  @PrimaryKey
  private String filmId;
  private String title;
  private int episode;
  private String openingCrawl;
  private String producer;
  private Date releaseDate;
  private RealmList<RealmPeople> characters;
  private RealmList<RealmPlanet> planets;
  private RealmList<RealmSpecie> species;
  private RealmList<RealmStarship> starships;
  private RealmList<RealmVehicle> vehicles;
  private String mediaURL;
  private boolean dirty;
  private long updatedAt;
  private long createdAt;

  public String getFilmId() {
    return filmId;
  }

  public void setFilmId(String filmId) {
    this.filmId = filmId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getEpisode() {
    return episode;
  }

  public void setEpisode(int episode) {
    this.episode = episode;
  }

  public String getOpeningCrawl() {
    return openingCrawl;
  }

  public void setOpeningCrawl(String openingCrawl) {
    this.openingCrawl = openingCrawl;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public RealmList<RealmPeople> getCharacters() {
    return characters;
  }

  public void setCharacters(RealmList<RealmPeople> characters) {
    this.characters = characters;
  }

  public RealmList<RealmPlanet> getPlanets() {
    return planets;
  }

  public void setPlanets(RealmList<RealmPlanet> planets) {
    this.planets = planets;
  }

  public RealmList<RealmSpecie> getSpecies() {
    return species;
  }

  public void setSpecies(RealmList<RealmSpecie> species) {
    this.species = species;
  }

  public RealmList<RealmStarship> getStarships() {
    return starships;
  }

  public void setStarships(RealmList<RealmStarship> starships) {
    this.starships = starships;
  }

  public RealmList<RealmVehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(RealmList<RealmVehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public String getMediaURL() {
    return mediaURL;
  }

  public void setMediaURL(String mediaURL) {
    this.mediaURL = mediaURL;
  }

  public boolean isDirty() {
    return dirty;
  }

  public void setDirty(boolean dirty) {
    this.dirty = dirty;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(long updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }
}

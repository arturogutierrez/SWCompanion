package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.util.Date;

public class FilmRealm extends RealmObject {

  @PrimaryKey
  private String filmId;
  private String title;
  private String director;
  private int episode;
  private String openingCrawl;
  private String producer;
  private Date releaseDate;
  private RealmList<PeopleRealm> characters;
  private RealmList<PlanetRealm> planets;
  private RealmList<SpecieRealm> species;
  private RealmList<StarshipRealm> starships;
  private RealmList<VehicleRealm> vehicles;
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

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
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

  public RealmList<PeopleRealm> getCharacters() {
    return characters;
  }

  public void setCharacters(RealmList<PeopleRealm> characters) {
    this.characters = characters;
  }

  public RealmList<PlanetRealm> getPlanets() {
    return planets;
  }

  public void setPlanets(RealmList<PlanetRealm> planets) {
    this.planets = planets;
  }

  public RealmList<SpecieRealm> getSpecies() {
    return species;
  }

  public void setSpecies(RealmList<SpecieRealm> species) {
    this.species = species;
  }

  public RealmList<StarshipRealm> getStarships() {
    return starships;
  }

  public void setStarships(RealmList<StarshipRealm> starships) {
    this.starships = starships;
  }

  public RealmList<VehicleRealm> getVehicles() {
    return vehicles;
  }

  public void setVehicles(RealmList<VehicleRealm> vehicles) {
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

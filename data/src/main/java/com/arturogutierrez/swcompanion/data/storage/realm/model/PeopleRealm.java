package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PeopleRealm extends RealmObject {

  @PrimaryKey
  private String peopleId;
  private String name;
  private String gender;
  private int height;
  private int mass;
  private PlanetRealm homeworld;
  private RealmList<FilmRealm> films;
  private RealmList<SpecieRealm> species;
  private RealmList<StarshipRealm> starships;
  private RealmList<VehicleRealm> vehicles;
  private String mediaURL;
  private boolean dirty;
  private long updatedAt;
  private long createdAt;

  public String getPeopleId() {
    return peopleId;
  }

  public void setPeopleId(String peopleId) {
    this.peopleId = peopleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getMass() {
    return mass;
  }

  public void setMass(int mass) {
    this.mass = mass;
  }

  public PlanetRealm getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(PlanetRealm homeworld) {
    this.homeworld = homeworld;
  }

  public RealmList<FilmRealm> getFilms() {
    return films;
  }

  public void setFilms(RealmList<FilmRealm> films) {
    this.films = films;
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

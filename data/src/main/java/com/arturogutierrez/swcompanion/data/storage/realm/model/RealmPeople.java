package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmPeople extends RealmObject {

  @PrimaryKey
  private String peopleId;
  private String name;
  private String gender;
  private int height;
  private int mass;
  private RealmPlanet homeworld;
  private RealmList<RealmFilm> films;
  private RealmList<RealmSpecie> species;
  private RealmList<RealmStarship> starships;
  private RealmList<RealmVehicle> vehicles;
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

  public RealmPlanet getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(RealmPlanet homeworld) {
    this.homeworld = homeworld;
  }

  public RealmList<RealmFilm> getFilms() {
    return films;
  }

  public void setFilms(RealmList<RealmFilm> films) {
    this.films = films;
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

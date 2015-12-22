package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PlanetRealm extends RealmObject {

  @PrimaryKey
  private String planetId;
  private String name;
  private int diameter;
  private float gravity;
  private long population;
  private int rotationPeriodHours;
  private int orbitalPeriodDays;
  private RealmList<FilmRealm> films;
  private RealmList<PeopleRealm> residents;
  private String mediaURL;
  private boolean dirty;
  private long updatedAt;
  private long createdAt;

  public String getPlanetId() {
    return planetId;
  }

  public void setPlanetId(String planetId) {
    this.planetId = planetId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDiameter() {
    return diameter;
  }

  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }

  public float getGravity() {
    return gravity;
  }

  public void setGravity(float gravity) {
    this.gravity = gravity;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }

  public int getRotationPeriodHours() {
    return rotationPeriodHours;
  }

  public void setRotationPeriodHours(int rotationPeriodHours) {
    this.rotationPeriodHours = rotationPeriodHours;
  }

  public int getOrbitalPeriodDays() {
    return orbitalPeriodDays;
  }

  public void setOrbitalPeriodDays(int orbitalPeriodDays) {
    this.orbitalPeriodDays = orbitalPeriodDays;
  }

  public RealmList<FilmRealm> getFilms() {
    return films;
  }

  public void setFilms(RealmList<FilmRealm> films) {
    this.films = films;
  }

  public RealmList<PeopleRealm> getResidents() {
    return residents;
  }

  public void setResidents(RealmList<PeopleRealm> residents) {
    this.residents = residents;
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

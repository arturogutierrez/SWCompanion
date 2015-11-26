package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmStarship extends RealmObject {

  @PrimaryKey
  private String starshipId;
  private String name;
  private String model;
  private String starshipClass;
  private String manufacturer;
  private long costInCredits;
  private int length;
  private int crewNumber;
  private int passengersNumber;
  private RealmList<RealmFilm> films;
  private RealmList<RealmPeople> pilots;
  private boolean dirty;
  private long updatedAt;
  private long createdAt;

  public String getStarshipId() {
    return starshipId;
  }

  public void setStarshipId(String starshipId) {
    this.starshipId = starshipId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getStarshipClass() {
    return starshipClass;
  }

  public void setStarshipClass(String starshipClass) {
    this.starshipClass = starshipClass;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public long getCostInCredits() {
    return costInCredits;
  }

  public void setCostInCredits(long costInCredits) {
    this.costInCredits = costInCredits;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getCrewNumber() {
    return crewNumber;
  }

  public void setCrewNumber(int crewNumber) {
    this.crewNumber = crewNumber;
  }

  public int getPassengersNumber() {
    return passengersNumber;
  }

  public void setPassengersNumber(int passengersNumber) {
    this.passengersNumber = passengersNumber;
  }

  public RealmList<RealmFilm> getFilms() {
    return films;
  }

  public void setFilms(RealmList<RealmFilm> films) {
    this.films = films;
  }

  public RealmList<RealmPeople> getPilots() {
    return pilots;
  }

  public void setPilots(RealmList<RealmPeople> pilots) {
    this.pilots = pilots;
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

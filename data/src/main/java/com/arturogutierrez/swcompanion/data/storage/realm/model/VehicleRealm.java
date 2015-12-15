package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VehicleRealm extends RealmObject {

  @PrimaryKey
  private String vehicleId;
  private String name;
  private String model;
  private String vehicleClass;
  private String manufacturer;
  private int length;
  private int crewNumber;
  private int passengersNumber;
  private RealmList<FilmRealm> films;
  private RealmList<PeopleRealm> pilots;
  private String mediaURL;
  private boolean dirty;
  private long updatedAt;
  private long createdAt;

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
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

  public String getVehicleClass() {
    return vehicleClass;
  }

  public void setVehicleClass(String vehicleClass) {
    this.vehicleClass = vehicleClass;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
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

  public RealmList<FilmRealm> getFilms() {
    return films;
  }

  public void setFilms(RealmList<FilmRealm> films) {
    this.films = films;
  }

  public RealmList<PeopleRealm> getPilots() {
    return pilots;
  }

  public void setPilots(RealmList<PeopleRealm> pilots) {
    this.pilots = pilots;
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

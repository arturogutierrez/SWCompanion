package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Vehicle {

  private final String vehicleId;
  private final String name;
  private final String model;
  private final String vehicleClass;
  private final String manufacturer;
  private final int length;
  private final int crewNumber;
  private final int passengersNumber;
  private final List<Film> films;
  private final List<People> pilots;
  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  public Vehicle(String vehicleId, String name, String model, String vehicleClass,
      String manufacturer, int length, int crewNumber, int passengersNumber, List<Film> films,
      List<People> pilots, boolean dirty, long updatedAt, long createdAt) {
    this.vehicleId = vehicleId;
    this.name = name;
    this.model = model;
    this.vehicleClass = vehicleClass;
    this.manufacturer = manufacturer;
    this.length = length;
    this.crewNumber = crewNumber;
    this.passengersNumber = passengersNumber;
    this.films = films;
    this.pilots = pilots;
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public String getName() {
    return name;
  }

  public String getModel() {
    return model;
  }

  public String getVehicleClass() {
    return vehicleClass;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public int getLength() {
    return length;
  }

  public int getCrewNumber() {
    return crewNumber;
  }

  public int getPassengersNumber() {
    return passengersNumber;
  }

  public List<Film> getFilms() {
    return films;
  }

  public List<People> getPilots() {
    return pilots;
  }

  public boolean isDirty() {
    return dirty;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public long getCreatedAt() {
    return createdAt;
  }
}

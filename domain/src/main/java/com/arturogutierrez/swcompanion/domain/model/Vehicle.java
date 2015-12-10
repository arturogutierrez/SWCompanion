package com.arturogutierrez.swcompanion.domain.model;

import java.util.List;

public class Vehicle extends Item {

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

  public Vehicle(String vehicleId, String name, String model, String vehicleClass,
      String manufacturer, int length, int crewNumber, int passengersNumber, List<Film> films,
      List<People> pilots, String mediaURL, boolean dirty, long updatedAt, long createdAt) {
    super(mediaURL, dirty, updatedAt, createdAt);

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
  }

  public Vehicle(String vehicleId) {
    super();

    this.vehicleId = vehicleId;
    this.name = null;
    this.model = null;
    this.vehicleClass = null;
    this.manufacturer = null;
    this.length = 0;
    this.crewNumber = 0;
    this.passengersNumber = 0;
    this.films = null;
    this.pilots = null;
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
}

package com.arturogutierrez.swcompanion.model;

import java.util.List;

public class VehicleModel extends ItemModel {

  private final String vehicleId;
  private final String name;
  private final String model;
  private final String vehicleClass;
  private final String manufacturer;
  private final int length;
  private final int crewNumber;
  private final int passengersNumber;
  private final List<FilmModel> films;
  private final List<PeopleModel> pilots;

  public VehicleModel(String vehicleId, String name, String model, String vehicleClass,
      String manufacturer, int length, int crewNumber, int passengersNumber, List<FilmModel> films,
      List<PeopleModel> pilots, String mediaURL, boolean dirty, long updatedAt, long createdAt) {
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

  public List<FilmModel> getFilms() {
    return films;
  }

  public List<PeopleModel> getPilots() {
    return pilots;
  }
}

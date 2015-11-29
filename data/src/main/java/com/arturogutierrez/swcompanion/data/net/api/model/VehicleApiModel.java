package com.arturogutierrez.swcompanion.data.net.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class VehicleApiModel {

  String name;
  String model;
  @SerializedName("vehicle_class")
  String vehicleClass;
  String manufacturer;
  String length;
  @SerializedName("crew")
  String crewNumber;
  @SerializedName("passengers")
  String passengersNumber;
  String url;
  @SerializedName("created")
  Date createdAt;
  @SerializedName("edited")
  Date updatedAt;

  List<String> films;
  List<String> pilots;

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

  public String getLength() {
    return length;
  }

  public String getCrewNumber() {
    return crewNumber;
  }

  public String getPassengersNumber() {
    return passengersNumber;
  }

  public String getUrl() {
    return url;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public List<String> getFilms() {
    return films;
  }

  public List<String> getPilots() {
    return pilots;
  }
}

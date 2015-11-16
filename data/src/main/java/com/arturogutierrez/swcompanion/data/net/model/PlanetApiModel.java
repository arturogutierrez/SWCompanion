package com.arturogutierrez.swcompanion.data.net.model;

import com.google.gson.annotations.SerializedName;

public class PlanetApiModel {

  String planetId;
  String name;
  String gravity;
  String population;
  String url;

  @SerializedName("rotation_period")
  String rotationPeriodHours;

  @SerializedName("orbital_period")
  String orbitalPeriodDays;
}

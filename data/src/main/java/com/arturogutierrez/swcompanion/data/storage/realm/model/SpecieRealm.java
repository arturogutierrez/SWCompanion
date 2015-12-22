package com.arturogutierrez.swcompanion.data.storage.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SpecieRealm extends RealmObject {

  @PrimaryKey
  private String specieId;
  private String name;
  private String classification;
  private String designation;
  private float averageHeight;
  private int averageLifespan;
  private String eyeColors;
  private String hairColors;
  private String skinColors;
  private String language;
  private PlanetRealm homeworld;
  private RealmList<FilmRealm> films;
  private RealmList<PeopleRealm> people;
  private String mediaURL;
  private boolean dirty;
  private long updatedAt;
  private long createdAt;

  public String getSpecieId() {
    return specieId;
  }

  public void setSpecieId(String specieId) {
    this.specieId = specieId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public float getAverageHeight() {
    return averageHeight;
  }

  public void setAverageHeight(float averageHeight) {
    this.averageHeight = averageHeight;
  }

  public int getAverageLifespan() {
    return averageLifespan;
  }

  public void setAverageLifespan(int averageLifespan) {
    this.averageLifespan = averageLifespan;
  }

  public String getEyeColors() {
    return eyeColors;
  }

  public void setEyeColors(String eyeColors) {
    this.eyeColors = eyeColors;
  }

  public String getHairColors() {
    return hairColors;
  }

  public void setHairColors(String hairColors) {
    this.hairColors = hairColors;
  }

  public String getSkinColors() {
    return skinColors;
  }

  public void setSkinColors(String skinColors) {
    this.skinColors = skinColors;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
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

  public RealmList<PeopleRealm> getPeople() {
    return people;
  }

  public void setPeople(RealmList<PeopleRealm> people) {
    this.people = people;
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

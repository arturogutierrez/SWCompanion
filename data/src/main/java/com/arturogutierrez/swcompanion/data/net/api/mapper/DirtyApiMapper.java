package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import com.arturogutierrez.swcompanion.domain.model.Starship;
import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class DirtyApiMapper extends ApiMapper {

  @Inject
  public DirtyApiMapper() {

  }

  public List<People> transformEmptyPeople(List<String> characterURLs) {
    List<People> peopleList = new ArrayList<>(characterURLs.size());
    for (String URL : characterURLs) {
      String peopleId = extractId(URL);
      People people = new People(peopleId);
      peopleList.add(people);
    }
    return peopleList;
  }

  public Planet transformEmptyPlanet(String URL) {
    String planetId = extractId(URL);
    return new Planet(planetId);
  }

  public List<Planet> transformEmptyPlanets(List<String> planetURLs) {
    List<Planet> planetList = new ArrayList<>(planetURLs.size());
    for (String URL : planetURLs) {
      Planet planet = transformEmptyPlanet(URL);
      planetList.add(planet);
    }
    return planetList;
  }

  public List<Specie> transformEmptySpecies(List<String> specieURLs) {
    List<Specie> specieList = new ArrayList<>(specieURLs.size());
    for (String URL : specieURLs) {
      String specieId = extractId(URL);
      Specie specie = new Specie(specieId);
      specieList.add(specie);
    }
    return specieList;
  }

  public List<Starship> transformEmptyStarships(List<String> starshipURLs) {
    List<Starship> starshipList = new ArrayList<>(starshipURLs.size());
    for (String URL : starshipURLs) {
      String starshipId = extractId(URL);
      Starship starship = new Starship(starshipId);
      starshipList.add(starship);
    }
    return starshipList;
  }

  public List<Vehicle> transformEmptyVechicles(List<String> vehicleURLs) {
    List<Vehicle> vehicleList = new ArrayList<>(vehicleURLs.size());
    for (String URL : vehicleURLs) {
      String vehicleId = extractId(URL);
      Vehicle vehicle = new Vehicle(vehicleId);
      vehicleList.add(vehicle);
    }
    return vehicleList;
  }

  public List<Film> transformEmptyFilms(List<String> filmURLs) {
    List<Film> vehicleList = new ArrayList<>(filmURLs.size());
    for (String URL : filmURLs) {
      String filmId = extractId(URL);
      Film film = new Film(filmId);
      vehicleList.add(film);
    }
    return vehicleList;
  }
}

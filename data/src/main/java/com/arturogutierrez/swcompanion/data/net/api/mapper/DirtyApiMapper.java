package com.arturogutierrez.swcompanion.data.net.api.mapper;

import android.support.annotation.NonNull;
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

  @NonNull
  public People transformEmptyPeople(String URL) {
    String peopleId = extractId(URL);
    return new People(peopleId);
  }

  public List<People> transformEmptyPeople(List<String> characterURLs) {
    List<People> peopleList = new ArrayList<>(characterURLs.size());
    for (String URL : characterURLs) {
      People people = transformEmptyPeople(URL);
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

  public Specie transformEmptySpecie(String URL) {
    String specieId = extractId(URL);
    return new Specie(specieId);
  }

  public List<Specie> transformEmptySpecies(List<String> specieURLs) {
    List<Specie> specieList = new ArrayList<>(specieURLs.size());
    for (String URL : specieURLs) {
      Specie specie = transformEmptySpecie(URL);
      specieList.add(specie);
    }
    return specieList;
  }

  public Starship transformEmptyStarship(String URL) {
    String starshipId = extractId(URL);
    return new Starship(starshipId);
  }

  public List<Starship> transformEmptyStarships(List<String> starshipURLs) {
    List<Starship> starshipList = new ArrayList<>(starshipURLs.size());
    for (String URL : starshipURLs) {
      Starship starship = transformEmptyStarship(URL);
      starshipList.add(starship);
    }
    return starshipList;
  }

  public Vehicle transformEmptyVehicle(String URL) {
    String vehicleId = extractId(URL);
    return new Vehicle(vehicleId);
  }

  public List<Vehicle> transformEmptyVechicles(List<String> vehicleURLs) {
    List<Vehicle> vehicleList = new ArrayList<>(vehicleURLs.size());
    for (String URL : vehicleURLs) {
      Vehicle vehicle = transformEmptyVehicle(URL);
      vehicleList.add(vehicle);
    }
    return vehicleList;
  }

  public Film transformEmptyFilm(String URL) {
    String filmId = extractId(URL);
    return new Film(filmId);
  }

  public List<Film> transformEmptyFilms(List<String> filmURLs) {
    List<Film> vehicleList = new ArrayList<>(filmURLs.size());
    for (String URL : filmURLs) {
      Film film = transformEmptyFilm(URL);
      vehicleList.add(film);
    }
    return vehicleList;
  }
}

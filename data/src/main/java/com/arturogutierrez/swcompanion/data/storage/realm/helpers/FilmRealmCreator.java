package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PlanetRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.SpecieRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.StarshipRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.VehicleRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import com.arturogutierrez.swcompanion.domain.model.Starship;
import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import io.realm.Realm;
import io.realm.RealmList;
import java.util.List;

public class FilmRealmCreator {

  public FilmRealm createOrUpdateFilmRealmFromFilm(Realm realm, Film film) {
    FilmRealm filmRealm = getOrCreateEmptyFilmRealm(realm, film.getFilmId());
    copyPropertiesToFilmRealm(filmRealm, film);
    copyRelationshipsToFilmRealm(realm, filmRealm, film);
    return filmRealm;
  }

  private FilmRealm getOrCreateEmptyFilmRealm(Realm realm, String filmId) {
    FilmRealm filmRealm = realm.where(FilmRealm.class).equalTo("filmId", filmId).findFirst();
    if (filmRealm == null) {
      filmRealm = realm.createObject(FilmRealm.class);
      filmRealm.setDirty(true);
    }
    return filmRealm;
  }

  private void copyPropertiesToFilmRealm(FilmRealm filmRealm, Film film) {
    filmRealm.setFilmId(film.getFilmId());

    if (!film.isDirty()) {
      filmRealm.setTitle(film.getTitle());
      filmRealm.setDirector(film.getDirector());
      filmRealm.setEpisode(film.getEpisode());
      filmRealm.setOpeningCrawl(film.getOpeningCrawl());
      filmRealm.setProducer(film.getProducer());
      filmRealm.setReleaseDate(film.getReleaseDate());
      filmRealm.setMediaURL(film.getMediaURL());
      filmRealm.setDirty(film.isDirty());
      filmRealm.setCreatedAt(film.getCreatedAt());
      filmRealm.setUpdatedAt(film.getUpdatedAt());
    }
  }

  private void copyRelationshipsToFilmRealm(Realm realm, FilmRealm filmRealm, Film film) {
    if (film.isDirty()) {
      return;
    }

    copyPeopleRelationshipsToFilmRealm(realm, filmRealm, film.getCharacters());
    copyPlanetsRelationshipsToFilmRealm(realm, filmRealm, film.getPlanets());
    copySpeciesRelationshipsToFilmRealm(realm, filmRealm, film.getSpecies());
    copyStarshipsRelationshipsToFilmRealm(realm, filmRealm, film.getStarships());
    copyVehiclesRelationshipsToFilmRealm(realm, filmRealm, film.getVehicles());
  }

  private void copyPeopleRelationshipsToFilmRealm(Realm realm, FilmRealm filmRealm,
      List<People> peopleList) {
    PeopleRealmCreator peopleRealmCreator = new PeopleRealmCreator();
    RealmList<PeopleRealm> peopleRealmList = filmRealm.getCharacters();
    for (People people : peopleList) {
      PeopleRealm peopleRealm =
          peopleRealmCreator.createOrUpdatePeopleRealmFromPeople(realm, people);
      peopleRealmList.add(peopleRealm);
    }
  }

  private void copyPlanetsRelationshipsToFilmRealm(Realm realm, FilmRealm filmRealm,
      List<Planet> planets) {
    PlanetRealmCreator planetRealmCreator = new PlanetRealmCreator();
    RealmList<PlanetRealm> planetRealmList = filmRealm.getPlanets();
    for (Planet planet : planets) {
      PlanetRealm planetRealm =
          planetRealmCreator.createOrUpdatePlanetRealmFromPlanet(realm, planet);
      planetRealmList.add(planetRealm);
    }
  }

  private void copySpeciesRelationshipsToFilmRealm(Realm realm, FilmRealm filmRealm,
      List<Specie> species) {
    SpecieRealmCreator specieRealmCreator = new SpecieRealmCreator();
    RealmList<SpecieRealm> specieRealmList = filmRealm.getSpecies();
    for (Specie specie : species) {
      SpecieRealm specieRealm =
          specieRealmCreator.createOrUpdateSpecieRealmFromSpecie(realm, specie);
      specieRealmList.add(specieRealm);
    }
  }

  private void copyStarshipsRelationshipsToFilmRealm(Realm realm, FilmRealm filmRealm,
      List<Starship> starships) {
    StarshipRealmCreator starshipRealmCreator = new StarshipRealmCreator();
    RealmList<StarshipRealm> starshipRealmList = filmRealm.getStarships();
    for (Starship starship : starships) {
      StarshipRealm starshipRealm =
          starshipRealmCreator.createOrUpdateStarshipRealmFromStarship(realm, starship);
      starshipRealmList.add(starshipRealm);
    }
  }

  private void copyVehiclesRelationshipsToFilmRealm(Realm realm, FilmRealm filmRealm,
      List<Vehicle> vehicles) {
    VehicleRealmCreator vehicleRealmCreator = new VehicleRealmCreator();
    RealmList<VehicleRealm> vehicleRealmList = filmRealm.getVehicles();
    for (Vehicle vehicle : vehicles) {
      VehicleRealm vehicleRealm =
          vehicleRealmCreator.createOrUpdateVehicleRealmFromVehicle(realm, vehicle);
      vehicleRealmList.add(vehicleRealm);
    }
  }
}

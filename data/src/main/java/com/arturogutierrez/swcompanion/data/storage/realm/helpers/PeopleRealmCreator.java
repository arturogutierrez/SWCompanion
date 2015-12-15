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

public class PeopleRealmCreator {

  public PeopleRealm createOrUpdatePeopleRealmFromPeople(Realm realm, People people) {
    PeopleRealm peopleRealm = getOrCreateEmptyPeopleRealm(realm, people.getPeopleId());
    copyPropertiesToPeopleRealm(peopleRealm, people);
    copyRelationshipsToPeopleRealm(realm, peopleRealm, people);
    return peopleRealm;
  }

  private PeopleRealm getOrCreateEmptyPeopleRealm(Realm realm, String peopleId) {
    PeopleRealm peopleRealm =
        realm.where(PeopleRealm.class).equalTo("peopleId", peopleId).findFirst();
    if (peopleRealm == null) {
      peopleRealm = realm.createObject(PeopleRealm.class);
      peopleRealm.setDirty(true);
    }
    return peopleRealm;
  }

  private void copyPropertiesToPeopleRealm(PeopleRealm peopleRealm, People people) {
    peopleRealm.setPeopleId(people.getPeopleId());

    if (!people.isDirty()) {
      peopleRealm.setName(people.getName());
      peopleRealm.setGender(people.getGender());
      peopleRealm.setHeight(people.getHeight());
      peopleRealm.setMass(people.getMass());
      peopleRealm.setMediaURL(people.getMediaURL());
      peopleRealm.setDirty(people.isDirty());
      peopleRealm.setCreatedAt(people.getCreatedAt());
      peopleRealm.setUpdatedAt(people.getUpdatedAt());
    }
  }

  private void copyRelationshipsToPeopleRealm(Realm realm, PeopleRealm peopleRealm, People people) {
    if (people.isDirty()) {
      return;
    }

    copyPlanetRelationshipsToPeopleRealm(realm, peopleRealm, people.getHomeworld());
    copyFilmsRelationshipsToPeopleRealm(realm, peopleRealm, people.getFilms());
    copySpeciesRelationshipsToPeopleRealm(realm, peopleRealm, people.getSpecies());
    copyStarshipsRelationshipsToPeopleRealm(realm, peopleRealm, people.getStarships());
    copyVehiclesRelationshipsToPeopleRealm(realm, peopleRealm, people.getVehicles());
  }

  private void copyPlanetRelationshipsToPeopleRealm(Realm realm, PeopleRealm peopleRealm,
      Planet planet) {
    PlanetRealmCreator planetRealmCreator = new PlanetRealmCreator();
    PlanetRealm planetRealm = planetRealmCreator.createOrUpdatePlanetRealmFromPlanet(realm, planet);
    peopleRealm.setHomeworld(planetRealm);
  }

  private void copyFilmsRelationshipsToPeopleRealm(Realm realm, PeopleRealm peopleRealm,
      List<Film> films) {
    FilmRealmCreator filmRealmCreator = new FilmRealmCreator();
    RealmList<FilmRealm> filmRealmList = peopleRealm.getFilms();
    for (Film film : films) {
      FilmRealm filmRealm = filmRealmCreator.createOrUpdateFilmRealmFromFilm(realm, film);
      filmRealmList.add(filmRealm);
    }
  }

  private void copySpeciesRelationshipsToPeopleRealm(Realm realm, PeopleRealm peopleRealm,
      List<Specie> species) {
    SpecieRealmCreator specieRealmCreator = new SpecieRealmCreator();
    RealmList<SpecieRealm> specieRealmList = peopleRealm.getSpecies();
    for (Specie specie : species) {
      SpecieRealm specieRealm =
          specieRealmCreator.createOrUpdateSpecieRealmFromSpecie(realm, specie);
      specieRealmList.add(specieRealm);
    }
  }

  private void copyStarshipsRelationshipsToPeopleRealm(Realm realm, PeopleRealm peopleRealm,
      List<Starship> starships) {
    StarshipRealmCreator starshipRealmCreator = new StarshipRealmCreator();
    RealmList<StarshipRealm> starshipRealmList = peopleRealm.getStarships();
    for (Starship starship : starships) {
      StarshipRealm starshipRealm =
          starshipRealmCreator.createOrUpdateStarshipRealmFromStarship(realm, starship);
      starshipRealmList.add(starshipRealm);
    }
  }

  private void copyVehiclesRelationshipsToPeopleRealm(Realm realm, PeopleRealm peopleRealm,
      List<Vehicle> vehicles) {
    VehicleRealmCreator vehicleRealmCreator = new VehicleRealmCreator();
    RealmList<VehicleRealm> vehicleRealmList = peopleRealm.getVehicles();
    for (Vehicle vehicle : vehicles) {
      VehicleRealm vehicleRealm =
          vehicleRealmCreator.createOrUpdateVehicleRealmFromVehicle(realm, vehicle);
      vehicleRealmList.add(vehicleRealm);
    }
  }
}

package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PlanetRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import io.realm.Realm;
import io.realm.RealmList;
import java.util.List;

public class PlanetRealmCreator {

  public PlanetRealm createOrUpdatePlanetRealmFromPlanet(Realm realm, Planet planet) {
    PlanetRealm planetRealm = getOrCreateEmptyPlanetRealm(realm, planet.getPlanetId());
    copyPropertiesToPlanetRealm(planetRealm, planet);
    copyRelationshipsToPlanetRealm(realm, planetRealm, planet);
    return planetRealm;
  }

  private PlanetRealm getOrCreateEmptyPlanetRealm(Realm realm, String planetId) {
    PlanetRealm planetRealm =
        realm.where(PlanetRealm.class).equalTo("planetId", planetId).findFirst();
    if (planetRealm == null) {
      planetRealm = realm.createObject(PlanetRealm.class);
      planetRealm.setDirty(true);
    }
    return planetRealm;
  }

  private void copyPropertiesToPlanetRealm(PlanetRealm planetRealm, Planet planet) {
    planetRealm.setPlanetId(planet.getPlanetId());

    if (!planet.isDirty()) {
      planetRealm.setName(planet.getName());
      planetRealm.setDiameter(planet.getDiameter());
      planetRealm.setGravity(planet.getGravity());
      planetRealm.setPopulation(planet.getPopulation());
      planetRealm.setRotationPeriodHours(planet.getRotationPeriodHours());
      planetRealm.setOrbitalPeriodDays(planet.getOrbitalPeriodDays());
      planetRealm.setMediaURL(planet.getMediaURL());
      planetRealm.setDirty(planet.isDirty());
      planetRealm.setCreatedAt(planet.getCreatedAt());
      planetRealm.setUpdatedAt(planet.getUpdatedAt());
    }
  }

  private void copyRelationshipsToPlanetRealm(Realm realm, PlanetRealm planetRealm, Planet planet) {
    if (planet.isDirty()) {
      return;
    }

    copyFilmsRelationshipsToPlanetRealm(realm, planetRealm, planet.getFilms());
    copyPeopleRelationshipsToPlanetRealm(realm, planetRealm, planet.getResidents());
  }

  private void copyFilmsRelationshipsToPlanetRealm(Realm realm, PlanetRealm planetRealm,
      List<Film> films) {
    FilmRealmCreator filmRealmCreator = new FilmRealmCreator();
    RealmList<FilmRealm> filmRealmList = planetRealm.getFilms();
    for (Film film : films) {
      FilmRealm filmRealm = filmRealmCreator.createOrUpdateFilmRealmFromFilm(realm, film);
      filmRealmList.add(filmRealm);
    }
  }

  private void copyPeopleRelationshipsToPlanetRealm(Realm realm, PlanetRealm planetRealm,
      List<People> residents) {
    PeopleRealmCreator peopleRealmCreator = new PeopleRealmCreator();
    RealmList<PeopleRealm> peopleRealmList = planetRealm.getResidents();
    for (People people : residents) {
      PeopleRealm peopleRealm =
          peopleRealmCreator.createOrUpdatePeopleRealmFromPeople(realm, people);
      peopleRealmList.add(peopleRealm);
    }
  }
}

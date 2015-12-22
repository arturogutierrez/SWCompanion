package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PlanetRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.SpecieRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import io.realm.Realm;
import io.realm.RealmList;
import java.util.List;

public class SpecieRealmCreator {

  public SpecieRealm createOrUpdateSpecieRealmFromSpecie(Realm realm, Specie specie) {
    SpecieRealm specieRealm = getOrCreateEmptySpecieRealm(realm, specie.getSpecieId());
    copyPropertiesToSpecieRealm(specieRealm, specie);
    copyRelationshipsToSpecieRealm(realm, specieRealm, specie);
    return specieRealm;
  }

  private SpecieRealm getOrCreateEmptySpecieRealm(Realm realm, String specieId) {
    SpecieRealm specieRealm =
        realm.where(SpecieRealm.class).equalTo("specieId", specieId).findFirst();
    if (specieRealm == null) {
      specieRealm = realm.createObject(SpecieRealm.class);
      specieRealm.setDirty(true);
    }
    return specieRealm;
  }

  private void copyPropertiesToSpecieRealm(SpecieRealm specieRealm, Specie specie) {
    specieRealm.setSpecieId(specie.getSpecieId());

    if (!specie.isDirty()) {
      specieRealm.setName(specie.getName());
      specieRealm.setClassification(specie.getClassification());
      specieRealm.setDesignation(specie.getDesignation());
      specieRealm.setAverageHeight(specie.getAverageHeight());
      specieRealm.setAverageLifespan(specie.getAverageLifespan());
      specieRealm.setEyeColors(specie.getEyeColors());
      specieRealm.setHairColors(specie.getHairColors());
      specieRealm.setSkinColors(specie.getSkinColors());
      specieRealm.setLanguage(specie.getLanguage());
      specieRealm.setMediaURL(specie.getMediaURL());
      specieRealm.setDirty(specie.isDirty());
      specieRealm.setCreatedAt(specie.getCreatedAt());
      specieRealm.setUpdatedAt(specie.getUpdatedAt());
    }
  }

  private void copyRelationshipsToSpecieRealm(Realm realm, SpecieRealm specieRealm, Specie specie) {
    if (specie.isDirty()) {
      return;
    }

    copyPlanetRelationshipsToSpecieRealm(realm, specieRealm, specie.getHomeworld());
    copyFilmsRelationshipsToSpecieRealm(realm, specieRealm, specie.getFilms());
    copyPeopleRelationshipsToSpecieRealm(realm, specieRealm, specie.getPeople());
  }

  private void copyPlanetRelationshipsToSpecieRealm(Realm realm, SpecieRealm specieRealm,
      Planet homeworld) {
    PlanetRealmCreator planetRealmCreator = new PlanetRealmCreator();
    PlanetRealm planetRealm =
        planetRealmCreator.createOrUpdatePlanetRealmFromPlanet(realm, homeworld);
    specieRealm.setHomeworld(planetRealm);
  }

  private void copyFilmsRelationshipsToSpecieRealm(Realm realm, SpecieRealm specieRealm,
      List<Film> films) {
    FilmRealmCreator filmRealmCreator = new FilmRealmCreator();
    RealmList<FilmRealm> filmRealmList = specieRealm.getFilms();
    for (Film film : films) {
      FilmRealm filmRealm = filmRealmCreator.createOrUpdateFilmRealmFromFilm(realm, film);
      filmRealmList.add(filmRealm);
    }
  }

  private void copyPeopleRelationshipsToSpecieRealm(Realm realm, SpecieRealm specieRealm,
      List<People> peopleList) {
    PeopleRealmCreator peopleRealmCreator = new PeopleRealmCreator();
    RealmList<PeopleRealm> peopleRealmList = specieRealm.getPeople();
    for (People people : peopleList) {
      PeopleRealm peopleRealm =
          peopleRealmCreator.createOrUpdatePeopleRealmFromPeople(realm, people);
      peopleRealmList.add(peopleRealm);
    }
  }
}

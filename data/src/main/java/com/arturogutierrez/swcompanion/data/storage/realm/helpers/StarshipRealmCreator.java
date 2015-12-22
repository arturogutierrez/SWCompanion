package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.StarshipRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Starship;
import io.realm.Realm;
import io.realm.RealmList;
import java.util.List;

public class StarshipRealmCreator {

  public StarshipRealm createOrUpdateStarshipRealmFromStarship(Realm realm, Starship starship) {
    StarshipRealm starshipRealm = getOrCreateEmptyStarshipRealm(realm, starship.getStarshipId());
    copyPropertiesToStarshipRealm(starshipRealm, starship);
    copyRelationshipsToStarshipRealm(realm, starshipRealm, starship);
    return starshipRealm;
  }

  private StarshipRealm getOrCreateEmptyStarshipRealm(Realm realm, String starshipId) {
    StarshipRealm starshipRealm =
        realm.where(StarshipRealm.class).equalTo("starshipId", starshipId).findFirst();
    if (starshipRealm == null) {
      starshipRealm = realm.createObject(StarshipRealm.class);
      starshipRealm.setDirty(true);
    }
    return starshipRealm;
  }

  private void copyPropertiesToStarshipRealm(StarshipRealm starshipRealm, Starship starship) {
    starshipRealm.setStarshipId(starship.getStarshipId());

    if (!starship.isDirty()) {
      starshipRealm.setName(starship.getName());
      starshipRealm.setModel(starship.getModel());
      starshipRealm.setStarshipClass(starship.getStarshipClass());
      starshipRealm.setManufacturer(starship.getManufacturer());
      starshipRealm.setCostInCredits(starship.getCostInCredits());
      starshipRealm.setLength(starship.getLength());
      starshipRealm.setCrewNumber(starship.getCrewNumber());
      starshipRealm.setPassengersNumber(starship.getPassengersNumber());
      starshipRealm.setMediaURL(starship.getMediaURL());
      starshipRealm.setDirty(starship.isDirty());
      starshipRealm.setCreatedAt(starship.getCreatedAt());
      starshipRealm.setUpdatedAt(starship.getUpdatedAt());
    }
  }

  private void copyRelationshipsToStarshipRealm(Realm realm, StarshipRealm starshipRealm,
      Starship starship) {
    if (starship.isDirty()) {
      return;
    }

    copyFilmsRelationshipsToStarshipRealm(realm, starshipRealm, starship.getFilms());
    copyPeopleRelationshipsToStarshipRealm(realm, starshipRealm, starship.getPilots());
  }

  private void copyFilmsRelationshipsToStarshipRealm(Realm realm, StarshipRealm starshipRealm,
      List<Film> films) {
    FilmRealmCreator filmRealmCreator = new FilmRealmCreator();
    RealmList<FilmRealm> filmRealmList = starshipRealm.getFilms();
    for (Film film : films) {
      FilmRealm filmRealm = filmRealmCreator.createOrUpdateFilmRealmFromFilm(realm, film);
      filmRealmList.add(filmRealm);
    }
  }

  private void copyPeopleRelationshipsToStarshipRealm(Realm realm, StarshipRealm starshipRealm,
      List<People> peopleList) {
    PeopleRealmCreator peopleRealmCreator = new PeopleRealmCreator();
    RealmList<PeopleRealm> peopleRealmList = starshipRealm.getPilots();
    for (People people : peopleList) {
      PeopleRealm peopleRealm =
          peopleRealmCreator.createOrUpdatePeopleRealmFromPeople(realm, people);
      peopleRealmList.add(peopleRealm);
    }
  }
}

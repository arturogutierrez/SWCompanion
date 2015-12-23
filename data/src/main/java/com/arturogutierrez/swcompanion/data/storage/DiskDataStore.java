package com.arturogutierrez.swcompanion.data.storage;

import android.util.Log;
import com.arturogutierrez.swcompanion.data.repository.datasource.SWLocalDataStore;
import com.arturogutierrez.swcompanion.data.storage.realm.helpers.FilmRealmCreator;
import com.arturogutierrez.swcompanion.data.storage.realm.helpers.rx.RealmObservable;
import com.arturogutierrez.swcompanion.data.storage.realm.mapper.FilmRealmMapper;
import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import io.realm.Realm;
import java.util.List;
import rx.Observable;

public class DiskDataStore implements SWLocalDataStore {

  private final FilmRealmMapper filmRealmMapper;

  public DiskDataStore(FilmRealmMapper filmRealmMapper) {
    this.filmRealmMapper = filmRealmMapper;
  }

  @Override
  public Observable<List<Film>> getFilms() {
    return RealmObservable.results(realm -> realm.where(FilmRealm.class).findAll())
        .map(filmRealms -> filmRealmMapper.transform(filmRealms, true));
  }

  @Override
  public Observable<Film> getFilm(String filmId) {
    return RealmObservable.object(
        realm -> realm.where(FilmRealm.class).equalTo("filmId", filmId).findFirst())
        .map(filmRealm -> filmRealmMapper.transform(filmRealm, true));
  }

  @Override
  public void saveFilm(Film film) {
    Log.d(DiskDataStore.class.toString(), "Saving Film to database");

    Realm defaultRealm = Realm.getDefaultInstance();
    defaultRealm.executeTransaction(realm -> {
      FilmRealmCreator filmRealmCreator = new FilmRealmCreator();
      filmRealmCreator.createOrUpdateFilmRealmFromFilm(realm, film);
    });
  }
}

package com.arturogutierrez.swcompanion.data.storage;

import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStore;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.List;
import rx.Observable;
import rx.Observer;

public class DiskDataStore implements SWDataStore {

  @Override
  public Observable<List<Film>> getFilms(int page) {
    // TODO: Query to DB
    return Observable.create(Observer::onCompleted);
  }

  @Override
  public Observable<Film> getFilm(String filmId) {
    // TODO: Query to DB
    return Observable.create(Observer::onCompleted);
  }
}

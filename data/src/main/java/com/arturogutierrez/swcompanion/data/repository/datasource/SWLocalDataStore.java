package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.domain.model.Film;
import rx.Observable;

public interface SWLocalDataStore extends SWDataStore {

  Observable<Film> getFilm(String filmId);

  void saveFilm(Film film);
}

package com.arturogutierrez.swcompanion.data.repository;

import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.repository.FilmRepository;
import java.util.List;
import rx.Observable;

public class FilmRepositoryImpl implements FilmRepository {

  @Override
  public Observable<List<Film>> getFilms(int page) {
    return null;
  }

  @Override
  public Observable<Film> getFilm(int filmId) {
    return null;
  }
}

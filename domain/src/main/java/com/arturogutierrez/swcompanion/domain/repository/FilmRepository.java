package com.arturogutierrez.swcompanion.domain.repository;

import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.List;
import rx.Observable;

public interface FilmRepository {

  Observable<List<Film>> getFilms(int page);

  Observable<Film> getFilm(int filmId);
}

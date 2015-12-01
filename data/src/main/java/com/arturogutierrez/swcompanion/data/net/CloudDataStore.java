package com.arturogutierrez.swcompanion.data.net;

import com.arturogutierrez.swcompanion.data.net.api.SWRestApi;
import com.arturogutierrez.swcompanion.data.net.api.SWRestApiFactory;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStore;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class CloudDataStore implements SWDataStore {

  private final FilmApiMapper filmApiMapper;
  private final SWRestApi restApi;

  @Inject
  public CloudDataStore(FilmApiMapper filmApiMapper) {
    this.filmApiMapper = filmApiMapper;
    this.restApi = SWRestApiFactory.createNewApi();
  }

  @Override
  public Observable<List<Film>> getFilms(int page) {
    return restApi.getFilms(page).map(filmApiMapper::transform);
  }

  @Override
  public Observable<Film> getFilm(String filmId) {
    return restApi.getFilm(filmId).map(filmApiMapper::transform);
  }
}

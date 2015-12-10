package com.arturogutierrez.swcompanion.data.net;

import com.arturogutierrez.swcompanion.data.net.api.SWRestApi;
import com.arturogutierrez.swcompanion.data.net.api.SWRestApiFactory;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.bing.BingSearchApi;
import com.arturogutierrez.swcompanion.data.net.bing.BingSearchApiFactory;
import com.arturogutierrez.swcompanion.data.net.bing.model.BingImageApiModel;
import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStore;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class CloudDataStore implements SWDataStore {

  private final FilmApiMapper filmApiMapper;
  private final SWRestApi restApi;
  private final BingSearchApi bingSearchApi;

  @Inject
  public CloudDataStore(FilmApiMapper filmApiMapper) {
    this.filmApiMapper = filmApiMapper;
    this.restApi = SWRestApiFactory.createNewApi();
    this.bingSearchApi = BingSearchApiFactory.createNewApi();
  }

  @Override
  public Observable<List<Film>> getFilms(int page) {
    return restApi.getFilms(page).map(filmApiMapper::transform);
  }

  @Override
  public Observable<Film> getFilm(String filmId) {
    Observable<FilmApiModel> filmObservable = restApi.getFilm(filmId);
    return filmObservable.flatMap(filmApiModel -> {
      String query = "'star wars " + filmApiModel.getTitle() + " poster'";
      Observable<List<BingImageApiModel>> imageApiModelObservable = bingSearchApi.getImages(query);

      return Observable.zip(imageApiModelObservable, Observable.just(filmApiModel),
          (bingImageApiModels, previousFilmApiModel) -> {
            BingImageApiModel firstImageApiModel = bingImageApiModels.get(0);
            return filmApiMapper.transform(previousFilmApiModel, firstImageApiModel.getMediaURL());
          });
    });
  }
}

package com.arturogutierrez.swcompanion.data.net;

import com.arturogutierrez.swcompanion.data.net.api.SWRestApi;
import com.arturogutierrez.swcompanion.data.net.api.SWRestApiFactory;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.ListApiModel;
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
  public Observable<List<Film>> getFilms() {
    return getAllFilms().flatMap(filmApiModelList -> Observable.from(filmApiModelList.getResults()))
        .concatMap(this::getFilmWithMedia)
        .toList();
  }

  private Observable<ListApiModel<FilmApiModel>> getAllFilms() {
    return getFilmsFromPage(SWRestApi.FIRST_PAGE);
  }

  private Observable<ListApiModel<FilmApiModel>> getFilmsFromPage(int page) {
    return restApi.getFilms(page).concatMap(filmApiModelList -> {
      if (filmApiModelList.getNext() == null) {
        return Observable.just(filmApiModelList);
      }
      return Observable.just(filmApiModelList).concatWith(restApi.getFilms(page + 1));
    });
  }

  private Observable<Film> getFilmWithMedia(FilmApiModel filmApiModel) {
    String query = "'star wars " + filmApiModel.getTitle() + " poster'";
    String imageFilter = "'Aspect:Wide'";
    Observable<List<BingImageApiModel>> imageApiModelObservable =
        bingSearchApi.getImages(query, imageFilter);

    return imageApiModelObservable.flatMap(bingImageApiModels -> {
      BingImageApiModel firstImageApiModel = bingImageApiModels.get(0);
      Film film = filmApiMapper.transform(filmApiModel, firstImageApiModel.getMediaURL());
      return Observable.just(film);
    });
  }
}

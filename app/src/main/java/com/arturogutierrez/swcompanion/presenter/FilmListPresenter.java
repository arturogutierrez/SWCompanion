package com.arturogutierrez.swcompanion.presenter;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.domain.interactor.DefaultSubscriber;
import com.arturogutierrez.swcompanion.domain.interactor.FilmListInteractor;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.model.FilmModel;
import com.arturogutierrez.swcompanion.model.mapper.FilmModelMapper;
import com.arturogutierrez.swcompanion.view.FilmListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class FilmListPresenter extends DefaultSubscriber<List<Film>> implements Presenter {

  private final FilmListInteractor filmListInteractor;
  private final FilmModelMapper filmModelMapper;
  private final List<Film> filmList;

  private FilmListView filmListView;

  @Inject
  public FilmListPresenter(FilmListInteractor filmListInteractor, FilmModelMapper filmModelMapper) {
    this.filmListInteractor = filmListInteractor;
    this.filmModelMapper = filmModelMapper;
    this.filmList = new ArrayList<>();
  }

  public void setView(FilmListView filmListView) {
    this.filmListView = filmListView;
  }

  @Override
  public void resume() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void destroy() {
    filmListInteractor.unsubscribe();
  }

  public void loadFilms() {
    showLoading();
    retrieveFilms();
  }

  @Override
  public void onCompleted() {
    hideLoading();
  }

  @Override
  public void onError(Throwable e) {
    hideLoading();

    filmListView.viewNoItems();
  }

  @Override
  public void onNext(List<Film> filmListLoaded) {
    if (filmListLoaded == null || filmListLoaded.size() == 0) {
      filmListView.viewNoItems();
      return;
    }

    filmList.clear();
    filmList.addAll(filmListLoaded);
    sortFilms(filmList);

    List<FilmModel> itemModelList = filmModelMapper.transform(filmList);
    filmListView.renderFilms(itemModelList);
  }

  public void showDetailsFromItemAtPosition(int position) {
    Film film = filmList.get(position);
    filmListView.showDetails(filmModelMapper.transform(film));
  }

  private void showLoading() {
    filmListView.showLoading();
  }

  private void hideLoading() {
    filmListView.hideLoading();
  }

  private void retrieveFilms() {
    filmListInteractor.execute(this);
  }

  private void sortFilms(List<Film> films) {
    Collections.sort(films, (lhs, rhs) -> lhs.getEpisode() - rhs.getEpisode());
  }
}

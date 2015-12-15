package com.arturogutierrez.swcompanion.data.repository;

import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStore;
import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStoreFactory;
import com.arturogutierrez.swcompanion.data.repository.datasource.SWLocalDataStore;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.repository.SWRepository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class SWRepositoryImpl implements SWRepository {

  private final SWDataStoreFactory dataStoreFactory;

  @Inject
  public SWRepositoryImpl(SWDataStoreFactory dataStoreFactory) {
    this.dataStoreFactory = dataStoreFactory;
  }

  @Override
  public Observable<List<Film>> getFilms(int page) {
    SWDataStore cloudDataStore = dataStoreFactory.createCloudStore();
    SWDataStore diskDataStore = dataStoreFactory.createDiskStore();

    Observable<List<Film>> cloudObservable = cloudDataStore.getFilms(page);
    Observable<List<Film>> diskObservable = diskDataStore.getFilms(page);

    return Observable.concat(diskObservable, cloudObservable).first();
  }

  @Override
  public Observable<Film> getFilm(String filmId) {
    SWDataStore cloudDataStore = dataStoreFactory.createCloudStore();
    SWLocalDataStore diskDataStore = dataStoreFactory.createDiskStore();

    Observable<Film> diskObservable = diskDataStore.getFilm(filmId);
    Observable<Film> cloudObservable =
        cloudDataStore.getFilm(filmId).doOnNext(diskDataStore::saveFilm);

    return Observable.concat(diskObservable, cloudObservable).first();
  }
}

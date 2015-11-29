package com.arturogutierrez.swcompanion.data.repository;

import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStore;
import com.arturogutierrez.swcompanion.data.repository.datasource.SWDataStoreFactory;
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
    // TODO: Concat and first from cloud and disk
    return cloudDataStore.getFilms(page);
  }

  @Override
  public Observable<Film> getFilm(int filmId) {
    return null;
  }
}

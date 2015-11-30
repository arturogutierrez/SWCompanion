package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.data.net.CloudDataStore;
import com.arturogutierrez.swcompanion.data.net.api.mapper.DirtyApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import javax.inject.Inject;

public class SWDataStoreFactory {

  @Inject
  public SWDataStoreFactory() {

  }

  public SWDataStore createCloudStore() {
    FilmApiMapper filmApiMapper = createFilmApiMapper();
    return new CloudDataStore(filmApiMapper);
  }

  private FilmApiMapper createFilmApiMapper() {
    DirtyApiMapper dirtyApiMapper = new DirtyApiMapper();
    return new FilmApiMapper(dirtyApiMapper);
  }
}

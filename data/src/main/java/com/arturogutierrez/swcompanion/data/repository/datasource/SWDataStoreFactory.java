package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.data.net.CloudDataStore;
import com.arturogutierrez.swcompanion.data.net.api.mapper.DirtyApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import com.arturogutierrez.swcompanion.data.storage.DiskDataStore;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SWDataStoreFactory {

  @Inject
  public SWDataStoreFactory() {

  }

  public SWDataStore createCloudStore() {
    FilmApiMapper filmApiMapper = createFilmApiMapper();
    return new CloudDataStore(filmApiMapper);
  }

  public SWLocalDataStore createDiskStore() {
    return new DiskDataStore();
  }

  private FilmApiMapper createFilmApiMapper() {
    DirtyApiMapper dirtyApiMapper = new DirtyApiMapper();
    return new FilmApiMapper(dirtyApiMapper);
  }
}

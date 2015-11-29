package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.data.net.CloudDataStore;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import javax.inject.Inject;

public class SWDataStoreFactory {

  @Inject
  public SWDataStoreFactory() {

  }

  public SWDataStore createCloudStore() {
    FilmApiMapper filmApiMapper = new FilmApiMapper();
    return new CloudDataStore(filmApiMapper);
  }
}

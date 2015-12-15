package com.arturogutierrez.swcompanion.data.repository.datasource;

import android.content.Context;
import com.arturogutierrez.swcompanion.data.net.CloudDataStore;
import com.arturogutierrez.swcompanion.data.net.api.mapper.DirtyApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import com.arturogutierrez.swcompanion.data.storage.DiskDataStore;
import com.arturogutierrez.swcompanion.data.storage.realm.mapper.FilmRealmMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SWDataStoreFactory {

  private final Context context;

  @Inject
  public SWDataStoreFactory(Context context) {
    this.context = context;
  }

  public SWDataStore createCloudStore() {
    FilmApiMapper filmApiMapper = createFilmApiMapper();
    return new CloudDataStore(filmApiMapper);
  }

  public SWLocalDataStore createDiskStore() {
    FilmRealmMapper filmRealmMapper = createFilmRealmMapper();
    return new DiskDataStore(context, filmRealmMapper);
  }

  private FilmApiMapper createFilmApiMapper() {
    DirtyApiMapper dirtyApiMapper = new DirtyApiMapper();
    return new FilmApiMapper(dirtyApiMapper);
  }

  private FilmRealmMapper createFilmRealmMapper() {
    return new FilmRealmMapper();
  }
}

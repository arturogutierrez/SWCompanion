package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.data.net.CloudDataStore;
import com.arturogutierrez.swcompanion.data.net.api.mapper.CharacterApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.FilmApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.PlanetApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.SpecieApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.StarshipApiMapper;
import com.arturogutierrez.swcompanion.data.net.api.mapper.VehicleApiMapper;
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
    CharacterApiMapper characterApiMapper = new CharacterApiMapper();
    PlanetApiMapper planetApiMapper = new PlanetApiMapper();
    SpecieApiMapper specieApiMapper = new SpecieApiMapper();
    StarshipApiMapper starshipApiMapper = new StarshipApiMapper();
    VehicleApiMapper vehicleApiMapper = new VehicleApiMapper();

    return new FilmApiMapper(characterApiMapper, planetApiMapper, specieApiMapper,
        starshipApiMapper, vehicleApiMapper);
  }
}

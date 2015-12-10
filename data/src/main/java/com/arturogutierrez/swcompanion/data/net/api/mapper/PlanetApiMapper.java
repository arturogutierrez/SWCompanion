package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.net.api.model.PlanetApiModel;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import javax.inject.Inject;

public class PlanetApiMapper extends ApiMapper {

  private final DirtyApiMapper dirtyApiMapper;

  @Inject
  public PlanetApiMapper(DirtyApiMapper dirtyApiMapper) {
    super();

    this.dirtyApiMapper = dirtyApiMapper;
  }

  public Planet transform(PlanetApiModel planetApiModel, String mediaURL) {
    String planetId = extractId(planetApiModel.getUrl());
    return new Planet(planetId, planetApiModel.getName(), intForText(planetApiModel.getDiameter()),
        floatForText(planetApiModel.getGravity()), longForText(planetApiModel.getPopulation()),
        intForText(planetApiModel.getRotationPeriodHours()),
        intForText(planetApiModel.getOrbitalPeriodDays()),
        dirtyApiMapper.transformEmptyFilms(planetApiModel.getFilms()),
        dirtyApiMapper.transformEmptyPeople(planetApiModel.getResidents()), mediaURL, false,
        getTimeFromDate(planetApiModel.getUpdatedAt()),
        getTimeFromDate(planetApiModel.getCreatedAt()));
  }
}

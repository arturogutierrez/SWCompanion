package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.net.api.model.SpecieApiModel;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import javax.inject.Inject;

public class SpecieApiMapper extends ApiMapper {

  private final DirtyApiMapper dirtyApiMapper;

  @Inject
  public SpecieApiMapper(DirtyApiMapper dirtyApiMapper) {
    super();

    this.dirtyApiMapper = dirtyApiMapper;
  }

  public Specie transform(SpecieApiModel specieApiModel) {
    String specieId = extractId(specieApiModel.getUrl());
    return new Specie(specieId, specieApiModel.getName(), specieApiModel.getClassification(),
        specieApiModel.getDesignation(), floatForText(specieApiModel.getAverageHeight()),
        intForText(specieApiModel.getAverageLifespan()), specieApiModel.getEyeColors(),
        specieApiModel.getHairColors(), specieApiModel.getSkinColors(),
        specieApiModel.getLanguage(),
        dirtyApiMapper.transformEmptyPlanet(specieApiModel.getHomeworld()),
        dirtyApiMapper.transformEmptyFilms(specieApiModel.getFilms()),
        dirtyApiMapper.transformEmptyPeople(specieApiModel.getPeople()), false,
        getTimeFromDate(specieApiModel.getUpdatedAt()),
        getTimeFromDate(specieApiModel.getCreatedAt()));
  }
}

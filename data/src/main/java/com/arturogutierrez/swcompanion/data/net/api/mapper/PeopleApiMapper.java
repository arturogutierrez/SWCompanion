package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.net.api.model.PeopleApiModel;
import com.arturogutierrez.swcompanion.domain.model.People;
import javax.inject.Inject;

public class PeopleApiMapper extends ApiMapper {

  private final DirtyApiMapper dirtyApiMapper;

  @Inject
  public PeopleApiMapper(DirtyApiMapper dirtyApiMapper) {
    super();

    this.dirtyApiMapper = dirtyApiMapper;
  }

  public People transform(PeopleApiModel peopleApiModel, String mediaURL) {
    People people = null;
    if (peopleApiModel != null) {
      String peopleId = extractId(peopleApiModel.getUrl());
      people = new People(peopleId, peopleApiModel.getName(), peopleApiModel.getGender(),
          intForText(peopleApiModel.getHeight()), intForText(peopleApiModel.getMass()),
          dirtyApiMapper.transformEmptyPlanet(peopleApiModel.getHomeworld()),
          dirtyApiMapper.transformEmptyFilms(peopleApiModel.getFilms()),
          dirtyApiMapper.transformEmptySpecies(peopleApiModel.getSpecies()),
          dirtyApiMapper.transformEmptyStarships(peopleApiModel.getStarships()),
          dirtyApiMapper.transformEmptyVechicles(peopleApiModel.getVehicles()), mediaURL, false,
          getTimeFromDate(peopleApiModel.getUpdatedAt()),
          getTimeFromDate(peopleApiModel.getCreatedAt()));
    }

    return people;
  }
}

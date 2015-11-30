package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.domain.model.Starship;
import java.util.List;
import javax.inject.Inject;

public class StarshipApiMapper extends ApiMapper {

  @Inject
  public StarshipApiMapper() {
    super();
  }

  public List<Starship> transform(List<String> starships) {
    // TODO: Parse starships
    return null;
  }
}

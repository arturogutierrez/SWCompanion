package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.domain.model.Planet;
import java.util.List;
import javax.inject.Inject;

public class PlanetApiMapper extends ApiMapper {

  @Inject
  public PlanetApiMapper() {
    super();
  }

  public List<Planet> transform(List<String> planets) {
    // TODO: Parse planets
    return null;
  }
}

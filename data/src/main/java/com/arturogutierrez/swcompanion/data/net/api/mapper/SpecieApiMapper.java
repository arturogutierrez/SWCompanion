package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.domain.model.Specie;
import java.util.List;
import javax.inject.Inject;

public class SpecieApiMapper extends ApiMapper {

  @Inject
  public SpecieApiMapper() {
    super();
  }

  public List<Specie> transform(List<String> species) {
    // TODO: Parse Species
    return null;
  }
}

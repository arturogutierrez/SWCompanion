package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import java.util.List;
import javax.inject.Inject;

public class VehicleApiMapper extends ApiMapper {

  @Inject
  public VehicleApiMapper() {
    super();
  }

  public List<Vehicle> transform(List<String> vehicles) {
    // TODO: Parse vehicles
    return null;
  }
}

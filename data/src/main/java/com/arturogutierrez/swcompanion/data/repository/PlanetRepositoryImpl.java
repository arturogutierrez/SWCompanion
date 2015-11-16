package com.arturogutierrez.swcompanion.data.repository;

import com.arturogutierrez.swcompanion.domain.model.PlanetModel;
import com.arturogutierrez.swcompanion.domain.repository.PlanetRepository;
import java.util.List;
import rx.Observable;

public class PlanetRepositoryImpl implements PlanetRepository {

  @Override
  public Observable<List<PlanetModel>> getAllPlanets(int page) {
    return null;
  }

  @Override
  public Observable<PlanetModel> getPlanet(int planetId) {
    return null;
  }
}

package com.arturogutierrez.swcompanion.data.repository;

import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.repository.PlanetRepository;
import java.util.List;
import rx.Observable;

public class PlanetRepositoryImpl implements PlanetRepository {

  @Override
  public Observable<List<Planet>> getAllPlanets(int page) {
    return null;
  }

  @Override
  public Observable<Planet> getPlanet(int planetId) {
    return null;
  }
}

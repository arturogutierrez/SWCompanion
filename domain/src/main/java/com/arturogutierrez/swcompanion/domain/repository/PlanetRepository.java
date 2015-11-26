package com.arturogutierrez.swcompanion.domain.repository;

import com.arturogutierrez.swcompanion.domain.model.PlanetModel;

import java.util.List;

import rx.Observable;

public interface PlanetRepository {

    Observable<List<PlanetModel>> getAllPlanets(int page);

    Observable<PlanetModel> getPlanet(int planetId);
}

package com.arturogutierrez.swcompanion.domain.repository;

import com.arturogutierrez.swcompanion.domain.model.Planet;

import java.util.List;

import rx.Observable;

public interface PlanetRepository {

    Observable<List<Planet>> getAllPlanets(int page);

    Observable<Planet> getPlanet(int planetId);
}

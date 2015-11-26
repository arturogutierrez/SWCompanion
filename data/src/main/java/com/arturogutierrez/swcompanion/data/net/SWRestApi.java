package com.arturogutierrez.swcompanion.data.net;

import com.arturogutierrez.swcompanion.data.net.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.model.ListApiModel;
import com.arturogutierrez.swcompanion.data.net.model.PeopleApiModel;
import com.arturogutierrez.swcompanion.data.net.model.PlanetApiModel;
import com.arturogutierrez.swcompanion.data.net.model.SpecieApiModel;
import com.arturogutierrez.swcompanion.data.net.model.StarshipApiModel;
import com.arturogutierrez.swcompanion.data.net.model.VehicleApiModel;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface SWRestApi {

  String API_BASE_URL = "http://swapi.co/api";

  @GET("/films/")
  Observable<ListApiModel<FilmApiModel>> getAllFilms(@Query("page") int page);

  @GET("/films/{id}/")
  Observable<FilmApiModel> getFilm(@Path("id") int filmId);

  @GET("/people/")
  Observable<ListApiModel<PeopleApiModel>> getAllPeople(@Query("page") int page);

  @GET("/people/{id}/")
  Observable<PeopleApiModel> getPeople(@Path("id") int peopleId);

  @GET("/starships/")
  Observable<ListApiModel<StarshipApiModel>> getAllStarships(@Query("page") int page);

  @GET("/starships/{id}/")
  Observable<StarshipApiModel> getStarship(@Path("id") int starshipId);

  @GET("/vehicles/")
  Observable<ListApiModel<VehicleApiModel>> getAllVehicles(@Query("page") int page);

  @GET("/vehicles/{id}/")
  Observable<VehicleApiModel> getVechicle(@Path("id") int vehicleId);

  @GET("/species/")
  Observable<ListApiModel<SpecieApiModel>> getAllSpecies(@Query("page") int page);

  @GET("/species/{id}/")
  Observable<SpecieApiModel> getSpecie(@Path("id") int specieId);

  @GET("/planets/")
  Observable<ListApiModel<PlanetApiModel>> getAllPlanets(@Query("page") int page);

  @GET("/planets/{id}/")
  Observable<PlanetApiModel> getPlanet(@Path("id") int planetId);
}


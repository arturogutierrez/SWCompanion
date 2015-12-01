package com.arturogutierrez.swcompanion.data.net.api;

import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.ListApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.PeopleApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.PlanetApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.SpecieApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.StarshipApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.VehicleApiModel;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface SWRestApi {

  String API_BASE_URL = "http://swapi.co/api";

  @GET("/films/")
  Observable<ListApiModel<FilmApiModel>> getFilms(@Query("page") int page);

  @GET("/films/{id}/")
  Observable<FilmApiModel> getFilm(@Path("id") String filmId);

  @GET("/people/")
  Observable<ListApiModel<PeopleApiModel>> getAllPeople(@Query("page") int page);

  @GET("/people/{id}/")
  Observable<PeopleApiModel> getPeople(@Path("id") String peopleId);

  @GET("/starships/")
  Observable<ListApiModel<StarshipApiModel>> getStarships(@Query("page") int page);

  @GET("/starships/{id}/")
  Observable<StarshipApiModel> getStarship(@Path("id") String starshipId);

  @GET("/vehicles/")
  Observable<ListApiModel<VehicleApiModel>> getVehicles(@Query("page") int page);

  @GET("/vehicles/{id}/")
  Observable<VehicleApiModel> getVechicle(@Path("id") String vehicleId);

  @GET("/species/")
  Observable<ListApiModel<SpecieApiModel>> getSpecies(@Query("page") int page);

  @GET("/species/{id}/")
  Observable<SpecieApiModel> getSpecie(@Path("id") String specieId);

  @GET("/planets/")
  Observable<ListApiModel<PlanetApiModel>> getPlanets(@Query("page") int page);

  @GET("/planets/{id}/")
  Observable<PlanetApiModel> getPlanet(@Path("id") String planetId);
}


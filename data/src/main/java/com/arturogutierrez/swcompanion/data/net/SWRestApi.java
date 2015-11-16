package com.arturogutierrez.swcompanion.data.net;

import com.arturogutierrez.swcompanion.data.net.model.ListApiModel;
import com.arturogutierrez.swcompanion.data.net.model.PlanetApiModel;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface SWRestApi {

  String API_BASE_URL = "http://swapi.co/api";

  @GET("/planets/")
  Observable<ListApiModel<PlanetApiModel>> getAllPlanets(@Query("page") int page);

  @GET("/planets/{id}/")
  Observable<PlanetApiModel> getPlanet(@Path("id") int planetId);
}


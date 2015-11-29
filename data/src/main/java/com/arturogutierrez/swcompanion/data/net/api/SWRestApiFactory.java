package com.arturogutierrez.swcompanion.data.net.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class SWRestApiFactory {

  public static SWRestApi createNewApi() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(SWRestApi.API_BASE_URL)
        .setRequestInterceptor(createRequestInterceptor())
        .setConverter(createGsonConverter())
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    return restAdapter.create(SWRestApi.class);
  }

  private static RequestInterceptor createRequestInterceptor() {
    return request -> request.addHeader("Accept", "application/json");
  }

  private static GsonConverter createGsonConverter() {
    Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer()).create();

    return new GsonConverter(gson);
  }
}

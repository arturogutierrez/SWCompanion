package com.arturogutierrez.swcompanion.data.net;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class SWRestApiFactory {

  public static SWRestApi createNewApi() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(SWRestApi.API_BASE_URL)
        .setRequestInterceptor(createRequestInterceptor())
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    return restAdapter.create(SWRestApi.class);
  }

  private static RequestInterceptor createRequestInterceptor() {
    return request -> request.addHeader("Accept", "application/json");
  }
}

package com.arturogutierrez.swcompanion.data.net.bing;

import android.util.Base64;
import com.arturogutierrez.swcompanion.data.BuildConfig;
import com.arturogutierrez.swcompanion.data.net.bing.model.BingImageApiModel;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class BingSearchApiFactory {

  public static BingSearchApi createNewApi() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BingSearchApi.API_BASE_URL)
        .setRequestInterceptor(createRequestInterceptor())
        .setConverter(createGsonConverter())
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    return restAdapter.create(BingSearchApi.class);
  }

  private static RequestInterceptor createRequestInterceptor() {
    return request -> {
      request.addHeader("Accept", "application/json");

      String authorizationBase64 = getAuthorizationHeader();
      request.addHeader("Authorization", "Basic " + authorizationBase64);
      request.addHeader("Accept", "application/json");
      request.addEncodedQueryParam("$format", "json");
    };
  }

  private static String getAuthorizationHeader() {
    String bingKey = BuildConfig.BING_SEARCH_CONSUMER_KEY;
    String authorizationText = String.format("%s:%s", bingKey, bingKey);
    return Base64.encodeToString(authorizationText.getBytes(), Base64.NO_WRAP);
  }

  private static GsonConverter createGsonConverter() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Type bingImageApiModelListType = new TypeToken<List<BingImageApiModel>>() {
    }.getType();
    gsonBuilder.registerTypeAdapter(bingImageApiModelListType, new BingImageSerializer());

    return new GsonConverter(gsonBuilder.create());
  }
}

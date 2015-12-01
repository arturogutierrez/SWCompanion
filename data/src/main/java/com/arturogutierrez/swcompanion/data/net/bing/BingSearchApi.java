package com.arturogutierrez.swcompanion.data.net.bing;

import com.arturogutierrez.swcompanion.data.net.bing.model.BingImageApiModel;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface BingSearchApi {

  String API_BASE_URL = "https://api.datamarket.azure.com/Bing/Search/v1";

  @GET("/Image")
  Observable<List<BingImageApiModel>> getImages(@Query("Query") String query);
}


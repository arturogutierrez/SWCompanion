package com.arturogutierrez.swcompanion.data.net.bing;

import com.arturogutierrez.swcompanion.data.net.bing.model.BingImageApiModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.List;

public class BingImageSerializer implements JsonDeserializer<List<BingImageApiModel>> {

  @Override
  public List<BingImageApiModel> deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {

    JsonObject parentObject = json.getAsJsonObject().get("d").getAsJsonObject();
    JsonArray jsonArray = parentObject.get("results").getAsJsonArray();

    return new Gson().fromJson((JsonElement) jsonArray, typeOfT);
  }
}

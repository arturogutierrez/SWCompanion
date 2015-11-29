package com.arturogutierrez.swcompanion.data.net.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DateSerializer implements JsonDeserializer<Date> {

  private static final SimpleDateFormat[] DATE_FORMATS = new SimpleDateFormat[] {
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"), new SimpleDateFormat("yyyy-MM-dd"),
  };

  @Override
  public Date deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    String dateString = jsonElement.getAsString();
    for (SimpleDateFormat format : DATE_FORMATS) {
      try {
        return format.parse(dateString);
      } catch (ParseException ignored) {
      }
    }
    throw new JsonParseException(
        String.format("Unparseable date: %s Supported formats: %s", jsonElement.getAsString(),
            Arrays.toString(DATE_FORMATS)));
  }
}

package com.arturogutierrez.swcompanion.data.net.api.mapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ApiMapper {

  public ApiMapper() {

  }

  protected String extractId(String URL) {
    Pattern pattern = Pattern.compile("/(\\d+)/?$");
    Matcher matcher = pattern.matcher(URL);
    boolean isMatch = matcher.find();
    if (isMatch) {
      return matcher.group(1);
    }

    return null;
  }
}

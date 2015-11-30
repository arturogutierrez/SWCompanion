package com.arturogutierrez.swcompanion.data.net.api.mapper;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ApiMapper {

  public ApiMapper() {

  }

  protected String extractId(String URL) {
    if (URL == null) {
      return null;
    }

    Pattern pattern = Pattern.compile("/(\\d+)/?$");
    Matcher matcher = pattern.matcher(URL);
    boolean isMatch = matcher.find();
    if (isMatch) {
      return matcher.group(1);
    }

    return null;
  }

  protected long getTimeFromDate(Date date) {
    if (date == null) {
      return 0;
    }

    return date.getTime();
  }

  protected int intForText(String text) {
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException nfe) {
      return 0;
    }
  }
}

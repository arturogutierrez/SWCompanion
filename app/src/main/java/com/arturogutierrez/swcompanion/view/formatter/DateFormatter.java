package com.arturogutierrez.swcompanion.view.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

  public DateFormatter() {

  }

  public String formatReleaseDate(Date releaseDate) {
    return SimpleDateFormat.getDateInstance().format(releaseDate);
  }
}

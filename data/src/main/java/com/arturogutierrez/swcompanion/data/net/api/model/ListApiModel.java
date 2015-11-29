package com.arturogutierrez.swcompanion.data.net.api.model;

import java.util.List;

public class ListApiModel<T> {

  int count;
  String next;
  String previous;
  List<T> results;

  public int getCount() {
    return count;
  }

  public String getNext() {
    return next;
  }

  public String getPrevious() {
    return previous;
  }

  public List<T> getResults() {
    return results;
  }
}

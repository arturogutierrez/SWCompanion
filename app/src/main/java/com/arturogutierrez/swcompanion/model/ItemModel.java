package com.arturogutierrez.swcompanion.model;

public class ItemModel {

  private final String mediaURL;
  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  protected ItemModel(String mediaURL, boolean dirty, long updatedAt, long createdAt) {
    this.mediaURL = mediaURL;
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
  }

  public String getMediaURL() {
    return mediaURL;
  }

  public boolean isDirty() {
    return dirty;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public long getCreatedAt() {
    return createdAt;
  }
}

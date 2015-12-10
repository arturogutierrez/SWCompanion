package com.arturogutierrez.swcompanion.domain.model;

public abstract class Item {

  private final String mediaURL;
  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  protected Item(String mediaURL, boolean dirty, long updatedAt, long createdAt) {
    this.mediaURL = mediaURL;
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
  }

  protected Item() {
    this.mediaURL = null;
    this.dirty = true;
    this.updatedAt = 0;
    this.createdAt = 0;
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

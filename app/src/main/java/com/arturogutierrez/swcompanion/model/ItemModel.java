package com.arturogutierrez.swcompanion.model;

public class ItemModel {

  private final boolean dirty;
  private final long updatedAt;
  private final long createdAt;

  protected ItemModel(boolean dirty, long updatedAt, long createdAt) {
    this.dirty = dirty;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
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

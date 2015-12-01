package com.arturogutierrez.swcompanion.data.net.bing.model;

import com.google.gson.annotations.SerializedName;

public class BingImageApiModel {

  @SerializedName("ID")
  String id;
  @SerializedName("Title")
  String title;
  @SerializedName("MediaUrl")
  String mediaURL;
  @SerializedName("SourceUrl")
  String sourceURL;
  @SerializedName("DisplayUrl")
  String displayURL;
  @SerializedName("Width")
  int width;
  @SerializedName("Height")
  int height;
  @SerializedName("FileSize")
  long fileSize;
  @SerializedName("ContentType")
  String contentType;

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getMediaURL() {
    return mediaURL;
  }

  public String getSourceURL() {
    return sourceURL;
  }

  public String getDisplayURL() {
    return displayURL;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public long getFileSize() {
    return fileSize;
  }

  public String getContentType() {
    return contentType;
  }
}

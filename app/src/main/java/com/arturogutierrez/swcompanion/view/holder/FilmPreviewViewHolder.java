package com.arturogutierrez.swcompanion.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.model.FilmModel;
import com.bumptech.glide.Glide;

public class FilmPreviewViewHolder extends PreviewItemViewHolder {

  @Bind(R.id.tv_title)
  public TextView tvTitle;
  @Bind(R.id.iv_thumb)
  public ImageView ivThumbnail;

  public FilmPreviewViewHolder(View itemView) {
    super(itemView);
  }

  public void showFilm(Context context, FilmModel filmModel) {
    showTitle(filmModel.getTitle());
    showThumbnail(context, filmModel.getMediaURL());
  }

  private void showTitle(String title) {
    tvTitle.setText(title);
  }

  private void showThumbnail(Context context, String URL) {
    Glide.with(context).load(URL).crossFade().into(ivThumbnail);
  }
}

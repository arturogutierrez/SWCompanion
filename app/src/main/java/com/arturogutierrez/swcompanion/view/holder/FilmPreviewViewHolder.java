package com.arturogutierrez.swcompanion.view.holder;

import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.model.FilmModel;

public class FilmPreviewViewHolder extends PreviewItemViewHolder {

  @Bind(R.id.tv_title)
  public TextView tvTitle;

  public FilmPreviewViewHolder(View itemView) {
    super(itemView);
  }

  public void showFilm(FilmModel filmModel) {
    tvTitle.setText(filmModel.getTitle());
  }
}

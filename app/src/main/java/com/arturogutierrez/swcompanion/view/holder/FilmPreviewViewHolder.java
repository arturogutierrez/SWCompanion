package com.arturogutierrez.swcompanion.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.model.FilmModel;
import com.arturogutierrez.swcompanion.view.formatter.DateFormatter;
import java.util.Date;

public class FilmPreviewViewHolder extends PreviewItemViewHolder {

  @Bind(R.id.tv_title)
  public TextView tvTitle;
  @Bind(R.id.tv_episode)
  public TextView tvEpisode;
  @Bind(R.id.tv_director)
  public TextView tvDirector;
  @Bind(R.id.tv_release_date)
  public TextView tvReleaseDate;

  public FilmPreviewViewHolder(View itemView) {
    super(itemView);
  }

  public void showFilm(Context context, FilmModel filmModel) {
    tvTitle.setText(filmModel.getTitle());
    tvEpisode.setText(getEpisodeText(context, filmModel.getEpisode()));
    tvDirector.setText(filmModel.getDirector());
    tvReleaseDate.setText(formatReleaseDate(filmModel.getReleaseDate()));
  }

  private String getEpisodeText(Context context, int numEpisode) {
    return context.getString(R.string.episode, numEpisode);
  }

  private String formatReleaseDate(Date releaseDate) {
    DateFormatter dateFormatter = new DateFormatter();
    return dateFormatter.formatReleaseDate(releaseDate);
  }
}

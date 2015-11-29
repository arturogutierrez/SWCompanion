package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.ListApiModel;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FilmApiMapper {

  @Inject
  public FilmApiMapper() {

  }

  public List<Film> transform(ListApiModel<FilmApiModel> filmApiModelList) {
    List<Film> films = new ArrayList<>(filmApiModelList.getCount());
    for (FilmApiModel filmApiModel : filmApiModelList.getResults()) {
      Film film = transform(filmApiModel);
      films.add(film);
    }
    return films;
  }

  public Film transform(FilmApiModel filmApiModel) {
    Film film = null;
    if (filmApiModel != null) {
      // TODO: Map dependencies
      film = new Film(null, filmApiModel.getTitle(), Integer.parseInt(filmApiModel.getEpisode()),
          filmApiModel.getOpeningCrawl(), filmApiModel.getProducer(), filmApiModel.getReleaseDate(),
          null, null, null, null, null, false, filmApiModel.getUpdatedAt().getTime(),
          filmApiModel.getCreatedAt().getTime());
    }
    return film;
  }
}

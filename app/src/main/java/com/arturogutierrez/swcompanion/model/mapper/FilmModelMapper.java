package com.arturogutierrez.swcompanion.model.mapper;

import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.model.FilmModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FilmModelMapper {

  @Inject
  public FilmModelMapper() {

  }

  public FilmModel transform(Film film) {
    FilmModel filmModel = null;
    if (film != null) {
      filmModel =
          new FilmModel(film.getFilmId(), film.getTitle(), film.getDirector(), film.getEpisode(),
              film.getOpeningCrawl(), film.getProducer(), film.getReleaseDate(), null, null, null,
              null, null, film.getMediaURL(), film.isDirty(), film.getUpdatedAt(),
              film.getCreatedAt());
    }
    return filmModel;
  }

  public List<FilmModel> transform(List<Film> filmList) {
    ArrayList<FilmModel> filmModelList = new ArrayList<>(filmList.size());
    for (Film film : filmList) {
      FilmModel filmModel = transform(film);
      filmModelList.add(filmModel);
    }
    return filmModelList;
  }
}

package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.ListApiModel;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FilmApiMapper extends ApiMapper {

  private final DirtyApiMapper dirtyApiMapper;

  @Inject
  public FilmApiMapper(DirtyApiMapper dirtyApiMapper) {
    super();

    this.dirtyApiMapper = dirtyApiMapper;
  }

  public List<Film> transform(ListApiModel<FilmApiModel> filmApiModelList) {
    return transform(filmApiModelList.getResults());
  }

  public List<Film> transform(List<FilmApiModel> filmApiModelList) {
    List<Film> films = new ArrayList<>(filmApiModelList.size());
    for (FilmApiModel filmApiModel : filmApiModelList) {
      Film film = transform(filmApiModel);
      films.add(film);
    }
    return films;
  }

  public Film transform(FilmApiModel filmApiModel) {
    return transform(filmApiModel, null);
  }

  public Film transform(FilmApiModel filmApiModel, String mediaURL) {
    Film film = null;
    if (filmApiModel != null) {
      String filmId = extractId(filmApiModel.getUrl());
      film = new Film(filmId, filmApiModel.getTitle(), filmApiModel.getDirector(),
          intForText(filmApiModel.getEpisode()), filmApiModel.getOpeningCrawl(),
          filmApiModel.getProducer(), filmApiModel.getReleaseDate(),
          dirtyApiMapper.transformEmptyPeople(filmApiModel.getCharacters()),
          dirtyApiMapper.transformEmptyPlanets(filmApiModel.getPlanets()),
          dirtyApiMapper.transformEmptySpecies(filmApiModel.getSpecies()),
          dirtyApiMapper.transformEmptyStarships(filmApiModel.getStarships()),
          dirtyApiMapper.transformEmptyVechicles(filmApiModel.getVehicles()), mediaURL, false,
          getTimeFromDate(filmApiModel.getUpdatedAt()),
          getTimeFromDate(filmApiModel.getCreatedAt()));
    }
    return film;
  }
}

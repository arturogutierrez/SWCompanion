package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.ListApiModel;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FilmApiMapper extends ApiMapper {

  private final CharacterApiMapper characterApiMapper;
  private final PlanetApiMapper planetApiMapper;
  private final SpecieApiMapper specieApiMapper;
  private final StarshipApiMapper starshipApiMapper;
  private final VehicleApiMapper vehicleApiMapper;

  @Inject
  public FilmApiMapper(CharacterApiMapper characterApiMapper, PlanetApiMapper planetApiMapper,
      SpecieApiMapper specieApiMapper, StarshipApiMapper starshipApiMapper,
      VehicleApiMapper vehicleApiMapper) {
    super();

    this.characterApiMapper = characterApiMapper;
    this.planetApiMapper = planetApiMapper;
    this.specieApiMapper = specieApiMapper;
    this.starshipApiMapper = starshipApiMapper;
    this.vehicleApiMapper = vehicleApiMapper;
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
      String filmId = extractId(filmApiModel.getUrl());
      // TODO: Map dependencies
      film = new Film(filmId, filmApiModel.getTitle(), Integer.parseInt(filmApiModel.getEpisode()),
          filmApiModel.getOpeningCrawl(), filmApiModel.getProducer(), filmApiModel.getReleaseDate(),
          characterApiMapper.transform(filmApiModel.getCharacters()),
          planetApiMapper.transform(filmApiModel.getPlanets()),
          specieApiMapper.transform(filmApiModel.getSpecies()),
          starshipApiMapper.transform(filmApiModel.getStarships()),
          vehicleApiMapper.transform(filmApiModel.getVehicles()), false,
          filmApiModel.getUpdatedAt().getTime(), filmApiModel.getCreatedAt().getTime());
    }
    return film;
  }
}

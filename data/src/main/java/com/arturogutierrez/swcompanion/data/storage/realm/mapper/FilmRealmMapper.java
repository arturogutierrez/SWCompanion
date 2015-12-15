package com.arturogutierrez.swcompanion.data.storage.realm.mapper;

import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import com.arturogutierrez.swcompanion.domain.model.Starship;
import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class FilmRealmMapper {

  private final PeopleRealmMapper peopleRealmMapper;

  public FilmRealmMapper() {
    peopleRealmMapper = new PeopleRealmMapper();
  }

  public Film transform(FilmRealm filmRealm, boolean transformRelationships) {
    List<People> peopleList = new ArrayList<>();
    List<Planet> planetList = new ArrayList<>();
    List<Specie> specieList = new ArrayList<>();
    List<Starship> starshipList = new ArrayList<>();
    List<Vehicle> vehicleList = new ArrayList<>();

    if (transformRelationships) {
      peopleList = peopleRealmMapper.transform(filmRealm.getCharacters(), false);
    }

    return new Film(filmRealm.getFilmId(), filmRealm.getTitle(), filmRealm.getDirector(),
        filmRealm.getEpisode(), filmRealm.getOpeningCrawl(), filmRealm.getProducer(),
        filmRealm.getReleaseDate(), peopleList, planetList, specieList, starshipList, vehicleList,
        filmRealm.getMediaURL(), filmRealm.isDirty(), filmRealm.getCreatedAt(),
        filmRealm.getCreatedAt());
  }
}

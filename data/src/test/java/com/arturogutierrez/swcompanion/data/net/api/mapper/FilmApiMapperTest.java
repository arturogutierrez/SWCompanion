package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.ApplicationTestCase;
import com.arturogutierrez.swcompanion.data.net.api.model.FilmApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.ListApiModel;
import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class FilmApiMapperTest extends ApplicationTestCase {

  private static final String FAKE_ID = "1";
  private static final String FAKE_TITLE = "The Force Awakens";
  private static final String FAKE_DIRECTOR = "J.J. Abrams";
  private static final String FAKE_EPISODE = "7";
  private static final String FAKE_CRAWL = "Crawl";
  private static final String FAKE_PRODUCER = "Producer";
  private static final Date FAKE_RELEASE_DATE = new Date();
  private static final String FAKE_URL = "https://www.swapi.co/film/" + FAKE_ID + "/";
  private static final Date FAKE_CREATED_AT = new Date();
  private static final Date FAKE_UPDATE_AT = new Date();

  private FilmApiMapper filmApiMapper;

  @Before
  public void setUp() {
    CharacterApiMapper characterApiMapper = new CharacterApiMapper();
    PlanetApiMapper planetApiMapper = new PlanetApiMapper();
    SpecieApiMapper specieApiMapper = new SpecieApiMapper();
    StarshipApiMapper starshipApiMapper = new StarshipApiMapper();
    VehicleApiMapper vehicleApiMapper = new VehicleApiMapper();
    filmApiMapper =
        new FilmApiMapper(characterApiMapper, planetApiMapper, specieApiMapper, starshipApiMapper,
            vehicleApiMapper);
  }

  @Test
  public void testTransformFilmApiModel() {
    FilmApiModel filmApiModel = createFakeFilmApiModel();

    Film film = filmApiMapper.transform(filmApiModel);

    assertThat(film, is(instanceOf(Film.class)));
    assertThat(film.isDirty(), is(false));
    assertThat(film.getFilmId(), is(FAKE_ID));
    assertThat(film.getTitle(), is(FAKE_TITLE));
    assertThat(film.getEpisode(), is(Integer.parseInt(FAKE_EPISODE)));
    assertThat(film.getOpeningCrawl(), is(FAKE_CRAWL));
    assertThat(film.getProducer(), is(FAKE_PRODUCER));
    assertThat(film.getReleaseDate(), is(FAKE_RELEASE_DATE));
    assertThat(film.getCreatedAt(), is(FAKE_CREATED_AT.getTime()));
    assertThat(film.getUpdatedAt(), is(FAKE_UPDATE_AT.getTime()));
  }

  @Test
  public void testTransformFilmApiModelCollection() {
    FilmApiModel mockFilmApiModelOne = mock(FilmApiModel.class);
    FilmApiModel mockFilmApiModelTwo = mock(FilmApiModel.class);

    List<FilmApiModel> filmApiModelList = new ArrayList<>(2);
    filmApiModelList.add(mockFilmApiModelOne);
    filmApiModelList.add(mockFilmApiModelTwo);
    ListApiModel<FilmApiModel> filmApiModelListApiModel =
        new ListApiModel<>(2, null, null, filmApiModelList);
    Collection<Film> userCollection = filmApiMapper.transform(filmApiModelListApiModel);

    assertThat(userCollection.toArray()[0], is(instanceOf(Film.class)));
    assertThat(userCollection.toArray()[1], is(instanceOf(Film.class)));
    assertThat(userCollection.size(), is(2));
  }

  private FilmApiModel createFakeFilmApiModel() {
    return new FilmApiModel(FAKE_TITLE, FAKE_DIRECTOR, FAKE_EPISODE, FAKE_CRAWL, FAKE_PRODUCER,
        FAKE_RELEASE_DATE, FAKE_URL, FAKE_CREATED_AT, FAKE_UPDATE_AT,
        Collections.<String>emptyList(), Collections.<String>emptyList(),
        Collections.<String>emptyList(), Collections.<String>emptyList(),
        Collections.<String>emptyList());
  }
}

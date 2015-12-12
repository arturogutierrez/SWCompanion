package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.ApplicationTestCase;
import com.arturogutierrez.swcompanion.data.net.api.model.PlanetApiModel;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import java.util.Collections;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanetApiMapperTest extends ApplicationTestCase {

  private static final String FAKE_ID = "1";
  private static final String FAKE_NAME = "Han Solo";
  private static final String FAKE_DIAMETER = "150000";
  private static final String FAKE_GRAVITY = "2";
  private static final String FAKE_POPULATION = "12345678";
  private static final String FAKE_ROTATION_PERIOD_HOURS = "24";
  private static final String FAKE_ORBITAL_PERIOD_DAYS = "365";
  private static final String FAKE_URL = "https://www.swapi.co/people/" + FAKE_ID + "/";
  private static final Date FAKE_CREATED_AT = new Date();
  private static final Date FAKE_UPDATE_AT = new Date();

  private PlanetApiMapper planetApiMapper;

  @Before
  public void setUp() {
    DirtyApiMapper dirtyApiMapper = new DirtyApiMapper();
    planetApiMapper = new PlanetApiMapper(dirtyApiMapper);
  }

  @Test
  public void testTransformPeopleApiModel() {
    PlanetApiModel planetApiModel = createFakePlanetApiModel();
    Planet planet = planetApiMapper.transform(planetApiModel, null);

    assertThat(planet, is(instanceOf(Planet.class)));
    assertThat(planet.isDirty(), is(false));
    assertThat(planet.getPlanetId(), is(FAKE_ID));
    assertThat(planet.getName(), is(FAKE_NAME));
    assertThat(planet.getDiameter(), is(Integer.parseInt(FAKE_DIAMETER)));
    assertThat(planet.getGravity(), is(Float.parseFloat(FAKE_GRAVITY)));
    assertThat(planet.getPopulation(), is(Long.parseLong(FAKE_POPULATION)));
    assertThat(planet.getRotationPeriodHours(), is(Integer.parseInt(FAKE_ROTATION_PERIOD_HOURS)));
    assertThat(planet.getOrbitalPeriodDays(), is(Integer.parseInt(FAKE_ORBITAL_PERIOD_DAYS)));
    assertThat(planet.getCreatedAt(), is(FAKE_CREATED_AT.getTime()));
    assertThat(planet.getUpdatedAt(), is(FAKE_UPDATE_AT.getTime()));
  }

  private PlanetApiModel createFakePlanetApiModel() {
    return new PlanetApiModel(FAKE_NAME, FAKE_DIAMETER, FAKE_GRAVITY, FAKE_POPULATION, FAKE_URL,
        FAKE_ROTATION_PERIOD_HOURS, FAKE_ORBITAL_PERIOD_DAYS, FAKE_CREATED_AT, FAKE_UPDATE_AT,
        Collections.<String>emptyList(), Collections.<String>emptyList());
  }
}

package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.ApplicationTestCase;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import com.arturogutierrez.swcompanion.domain.model.Starship;
import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirtyApiMapperTest extends ApplicationTestCase {

  private static final String FAKE_ID = "1";
  private static final String FAKE_URL = "https://swapi.com/planet/" + FAKE_ID + "/";
  private static final String FAKE_URLS[] = { FAKE_URL, FAKE_URL };
  private static final List<String> URLs = Arrays.asList(FAKE_URLS);

  private DirtyApiMapper dirtyApiMapper;

  @Before
  public void setUp() {
    dirtyApiMapper = new DirtyApiMapper();
  }

  @Test
  public void testTransformEmptyCharacter() {
    People people = dirtyApiMapper.transformEmptyPeople(FAKE_URL);

    assertThat(people, is(instanceOf(People.class)));
    assertThat(people.getPeopleId(), is(FAKE_ID));
    assertThat(people.isDirty(), is(true));
  }

  @Test
  public void testTransformEmptyPeople() {
    List<People> peoples = dirtyApiMapper.transformEmptyPeople(URLs);

    assertThat(peoples.toArray()[0], is(instanceOf(People.class)));
    assertThat(peoples.toArray()[1], is(instanceOf(People.class)));
    assertThat(peoples.size(), is(2));
  }

  @Test
  public void testTransformEmptyPlanet() {
    Planet planet = dirtyApiMapper.transformEmptyPlanet(FAKE_URL);

    assertThat(planet, is(instanceOf(Planet.class)));
    assertThat(planet.getPlanetId(), is(FAKE_ID));
    assertThat(planet.isDirty(), is(true));
  }

  @Test
  public void testTransformEmptyPlanets() {
    List<Planet> planets = dirtyApiMapper.transformEmptyPlanets(URLs);

    assertThat(planets.toArray()[0], is(instanceOf(Planet.class)));
    assertThat(planets.toArray()[1], is(instanceOf(Planet.class)));
    assertThat(planets.size(), is(2));
  }

  @Test
  public void testTransformEmptySpecie() {
    Specie specie = dirtyApiMapper.transformEmptySpecie(FAKE_URL);

    assertThat(specie, is(instanceOf(Specie.class)));
    assertThat(specie.getSpecieId(), is(FAKE_ID));
    assertThat(specie.isDirty(), is(true));
  }

  @Test
  public void testTransformEmptySpecies() {
    List<Specie> species = dirtyApiMapper.transformEmptySpecies(URLs);

    assertThat(species.toArray()[0], is(instanceOf(Specie.class)));
    assertThat(species.toArray()[1], is(instanceOf(Specie.class)));
    assertThat(species.size(), is(2));
  }

  @Test
  public void testTransformEmptyStarship() {
    Starship starship = dirtyApiMapper.transformEmptyStarship(FAKE_URL);

    assertThat(starship, is(instanceOf(Starship.class)));
    assertThat(starship.getStarshipId(), is(FAKE_ID));
    assertThat(starship.isDirty(), is(true));
  }

  @Test
  public void testTransformEmptyStarships() {
    List<Starship> starships = dirtyApiMapper.transformEmptyStarships(URLs);

    assertThat(starships.toArray()[0], is(instanceOf(Starship.class)));
    assertThat(starships.toArray()[1], is(instanceOf(Starship.class)));
    assertThat(starships.size(), is(2));
  }

  @Test
  public void testTransformEmptyVehicle() {
    Vehicle vehicle = dirtyApiMapper.transformEmptyVehicle(FAKE_URL);

    assertThat(vehicle, is(instanceOf(Vehicle.class)));
    assertThat(vehicle.getVehicleId(), is(FAKE_ID));
    assertThat(vehicle.isDirty(), is(true));
  }

  @Test
  public void testTransformEmptyVehicles() {
    List<Vehicle> vehicles = dirtyApiMapper.transformEmptyVechicles(URLs);

    assertThat(vehicles.toArray()[0], is(instanceOf(Vehicle.class)));
    assertThat(vehicles.toArray()[1], is(instanceOf(Vehicle.class)));
    assertThat(vehicles.size(), is(2));
  }
}

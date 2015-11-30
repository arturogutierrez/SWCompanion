package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.ApplicationTestCase;
import com.arturogutierrez.swcompanion.data.net.api.model.PeopleApiModel;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import java.util.Collections;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PeopleApiMapperTest extends ApplicationTestCase {

  private static final String FAKE_ID = "1";
  private static final String FAKE_NAME = "Han Solo";
  private static final String FAKE_GENDER = "male";
  private static final String FAKE_HEIGHT = "180";
  private static final String FAKE_MASS = "80";
  private static final String FAKE_HOMEWORLD = "https://www.swapi.co/planet/1/";
  private static final String FAKE_URL = "https://www.swapi.co/people/" + FAKE_ID + "/";
  private static final Date FAKE_CREATED_AT = new Date();
  private static final Date FAKE_UPDATE_AT = new Date();

  private PeopleApiMapper peopleApiMapper;

  @Before
  public void setUp() {
    DirtyApiMapper dirtyApiMapper = new DirtyApiMapper();
    peopleApiMapper = new PeopleApiMapper(dirtyApiMapper);
  }

  @Test
  public void testTransformCharacterApiModel() {
    PeopleApiModel peopleApiModel = createFakePeopleApiModel();
    People people = peopleApiMapper.transform(peopleApiModel);

    assertThat(people, is(instanceOf(People.class)));
    assertThat(people.isDirty(), is(false));
    assertThat(people.getPeopleId(), is(FAKE_ID));
    assertThat(people.getName(), is(FAKE_NAME));
    assertThat(people.getGender(), is(FAKE_GENDER));
    assertThat(people.getHeight(), is(Integer.parseInt(FAKE_HEIGHT)));
    assertThat(people.getMass(), is(Integer.parseInt(FAKE_MASS)));
    assertThat(people.getHomeworld(), is(instanceOf(Planet.class)));
    assertThat(people.getCreatedAt(), is(FAKE_CREATED_AT.getTime()));
    assertThat(people.getUpdatedAt(), is(FAKE_UPDATE_AT.getTime()));
  }

  private PeopleApiModel createFakePeopleApiModel() {
    return new PeopleApiModel(FAKE_NAME, FAKE_GENDER, FAKE_HEIGHT, FAKE_MASS, FAKE_HOMEWORLD,
        FAKE_URL, FAKE_CREATED_AT, FAKE_UPDATE_AT, Collections.<String>emptyList(),
        Collections.<String>emptyList(), Collections.<String>emptyList(),
        Collections.<String>emptyList());
  }
}

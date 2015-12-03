package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.data.ApplicationTestCase;
import com.arturogutierrez.swcompanion.data.net.api.model.PlanetApiModel;
import com.arturogutierrez.swcompanion.data.net.api.model.SpecieApiModel;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import java.util.Collections;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpecieApiMapperTest extends ApplicationTestCase {

  private static final String FAKE_ID = "1";
  private static final String FAKE_NAME = "Twi'lek";
  private static final String FAKE_CLASSIFICATION = "Humanoid";
  private static final String FAKE_DESIGNATION = "Designation";
  private static final String FAKE_AVERAGE_HEIGHT = "180";
  private static final String FAKE_AVERAGE_LIFESPAN = "80";
  private static final String FAKE_EYE_COLORS = "Brown";
  private static final String FAKE_HAIR_COLORS = "";
  private static final String FAKE_SKIN_COLORS = "Blue";
  private static final String FAKE_LANGUAGE = "Language";
  private static final String FAKE_HOMEWORLD = "https://www.swapi.co/planet/1/";
  private static final String FAKE_URL = "https://www.swapi.co/specie/" + FAKE_ID + "/";
  private static final Date FAKE_CREATED_AT = new Date();
  private static final Date FAKE_UPDATE_AT = new Date();

  private SpecieApiMapper specieApiMapper;

  @Before
  public void setUp() {
    DirtyApiMapper dirtyApiMapper = new DirtyApiMapper();
    specieApiMapper = new SpecieApiMapper(dirtyApiMapper);
  }

  @Test
  public void testTransformSpecieApiModel() {
    SpecieApiModel specieApiModel = createFakeSpecieApiModel();
    Specie specie = specieApiMapper.transform(specieApiModel);

    assertThat(specie, is(instanceOf(Specie.class)));
    assertThat(specie.isDirty(), is(false));
    assertThat(specie.getSpecieId(), is(FAKE_ID));
    assertThat(specie.getName(), is(FAKE_NAME));
    assertThat(specie.getClassification(), is(FAKE_CLASSIFICATION));
    assertThat(specie.getAverageHeight(), is(Float.parseFloat(FAKE_AVERAGE_HEIGHT)));
    assertThat(specie.getAverageLifespan(), is(Integer.parseInt(FAKE_AVERAGE_LIFESPAN)));
    assertThat(specie.getHairColors(), is(FAKE_HAIR_COLORS));
    assertThat(specie.getSkinColors(), is(FAKE_SKIN_COLORS));
    assertThat(specie.getLanguage(), is(FAKE_LANGUAGE));
    assertThat(specie.getHomeworld(), is(instanceOf(Planet.class)));
    assertThat(specie.getCreatedAt(), is(FAKE_CREATED_AT.getTime()));
    assertThat(specie.getUpdatedAt(), is(FAKE_UPDATE_AT.getTime()));
  }

  private SpecieApiModel createFakeSpecieApiModel() {
    return new SpecieApiModel(FAKE_NAME, FAKE_CLASSIFICATION, FAKE_DESIGNATION, FAKE_AVERAGE_HEIGHT,
        FAKE_AVERAGE_LIFESPAN, FAKE_EYE_COLORS, FAKE_HAIR_COLORS, FAKE_SKIN_COLORS, FAKE_LANGUAGE,
        FAKE_HOMEWORLD, FAKE_URL, FAKE_CREATED_AT, FAKE_UPDATE_AT,
        Collections.<String>emptyList(), Collections.<String>emptyList());
  }
}

package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.PlanetRealm;
import com.arturogutierrez.swcompanion.domain.model.Planet;
import io.realm.Realm;

public class PlanetRealmCreator {

  public PlanetRealm createOrUpdatePlanetRealmFromPlanet(Realm realm, Planet planet) {
    PlanetRealm planetRealm = getOrCreateEmptyPlanetRealm(realm, planet.getPlanetId());
    copyPropertiesToPlanetRealm(planetRealm, planet);
    copyRelationshipsToPlanetRealm(planetRealm, planet);
    return planetRealm;
  }

  private PlanetRealm getOrCreateEmptyPlanetRealm(Realm realm, String planetId) {
    PlanetRealm planetRealm =
        realm.where(PlanetRealm.class).equalTo("planetId", planetId).findFirst();
    if (planetRealm == null) {
      planetRealm = realm.createObject(PlanetRealm.class);
      planetRealm.setDirty(true);
    }
    return planetRealm;
  }

  private void copyPropertiesToPlanetRealm(PlanetRealm planetRealm, Planet planet) {
    planetRealm.setPlanetId(planet.getPlanetId());

    if (!planet.isDirty()) {
      // TODO:
    }
  }

  private void copyRelationshipsToPlanetRealm(PlanetRealm planetRealm, Planet planet) {
    if (planet.isDirty()) {
      return;
    }

    // TODO:
  }
}

package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.StarshipRealm;
import com.arturogutierrez.swcompanion.domain.model.Starship;
import io.realm.Realm;

public class StarshipRealmCreator {

  public StarshipRealm createOrUpdateStarshipRealmFromStarship(Realm realm, Starship starship) {
    StarshipRealm starshipRealm = getOrCreateEmptyStarshipRealm(realm, starship.getStarshipId());
    copyPropertiesToStarshipRealm(starshipRealm, starship);
    copyRelationshipsToStarshipRealm(starshipRealm, starship);
    return starshipRealm;
  }

  private StarshipRealm getOrCreateEmptyStarshipRealm(Realm realm, String starshipId) {
    StarshipRealm starshipRealm =
        realm.where(StarshipRealm.class).equalTo("starshipId", starshipId).findFirst();
    if (starshipRealm == null) {
      starshipRealm = realm.createObject(StarshipRealm.class);
      starshipRealm.setDirty(true);
    }
    return starshipRealm;
  }

  private void copyPropertiesToStarshipRealm(StarshipRealm starshipRealm, Starship starship) {
    starshipRealm.setStarshipId(starship.getStarshipId());

    if (!starship.isDirty()) {
      // TODO:
    }
  }

  private void copyRelationshipsToStarshipRealm(StarshipRealm starshipRealm, Starship starship) {
    if (starship.isDirty()) {
      return;
    }

    // TODO:
  }
}

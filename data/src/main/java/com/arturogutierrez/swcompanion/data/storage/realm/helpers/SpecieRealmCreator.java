package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.SpecieRealm;
import com.arturogutierrez.swcompanion.domain.model.Specie;
import io.realm.Realm;

public class SpecieRealmCreator {

  public SpecieRealm createOrUpdateSpecieRealmFromSpecie(Realm realm, Specie specie) {
    SpecieRealm specieRealm = getOrCreateEmptySpecieRealm(realm, specie.getSpecieId());
    copyPropertiesToSpecieRealm(specieRealm, specie);
    copyRelationshipsToSpecieRealm(specieRealm, specie);
    return specieRealm;
  }

  private SpecieRealm getOrCreateEmptySpecieRealm(Realm realm, String specieId) {
    SpecieRealm specieRealm =
        realm.where(SpecieRealm.class).equalTo("specieId", specieId).findFirst();
    if (specieRealm == null) {
      specieRealm = realm.createObject(SpecieRealm.class);
      specieRealm.setDirty(true);
    }
    return specieRealm;
  }

  private void copyPropertiesToSpecieRealm(SpecieRealm specieRealm, Specie specie) {
    specieRealm.setSpecieId(specie.getSpecieId());

    if (!specie.isDirty()) {
      // TODO:
    }
  }

  private void copyRelationshipsToSpecieRealm(SpecieRealm specieRealm, Specie specie) {
    if (specie.isDirty()) {
      return;
    }

    // TODO:
  }
}

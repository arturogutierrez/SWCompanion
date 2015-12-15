package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.domain.model.People;
import io.realm.Realm;

public class PeopleRealmCreator {

  public PeopleRealm createOrUpdatePeopleRealmFromPeople(Realm realm, People people) {
    PeopleRealm peopleRealm = getOrCreateEmptyPeopleRealm(realm, people.getPeopleId());
    copyPropertiesToPeopleRealm(peopleRealm, people);
    copyRelationshipsToPeopleRealm(peopleRealm, people);
    return peopleRealm;
  }

  private PeopleRealm getOrCreateEmptyPeopleRealm(Realm realm, String peopleId) {
    PeopleRealm peopleRealm =
        realm.where(PeopleRealm.class).equalTo("peopleId", peopleId).findFirst();
    if (peopleRealm == null) {
      peopleRealm = realm.createObject(PeopleRealm.class);
      peopleRealm.setDirty(true);
    }
    return peopleRealm;
  }

  private void copyPropertiesToPeopleRealm(PeopleRealm peopleRealm, People people) {
    peopleRealm.setPeopleId(people.getPeopleId());

    if (!people.isDirty()) {
      // TODO:
    }
  }

  private void copyRelationshipsToPeopleRealm(PeopleRealm peopleRealm, People people) {
    if (people.isDirty()) {
      return;
    }

    // TODO:
  }
}

package com.arturogutierrez.swcompanion.data.storage.realm.mapper;

import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.domain.model.People;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleRealmMapper {

  public List<People> transform(RealmList<PeopleRealm> peopleRealmList,
      boolean transformRelationships) {

    ArrayList<People> peopleList = new ArrayList<>();
    for (PeopleRealm peopleRealm : peopleRealmList) {
      People people = transform(peopleRealm, transformRelationships);
      peopleList.add(people);
    }

    return peopleList;
  }

  private People transform(PeopleRealm peopleRealm, boolean transformRelationships) {
    // TODO: Relationships

    return new People(peopleRealm.getPeopleId(), peopleRealm.getName(), peopleRealm.getGender(),
        peopleRealm.getHeight(), peopleRealm.getMass(), null, Collections.emptyList(),
        Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
        peopleRealm.getMediaURL(), peopleRealm.isDirty(), peopleRealm.getCreatedAt(),
        peopleRealm.getUpdatedAt());
  }
}

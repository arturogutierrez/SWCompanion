package com.arturogutierrez.swcompanion.data.net.api.mapper;

import com.arturogutierrez.swcompanion.domain.model.People;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class CharacterApiMapper extends ApiMapper {

  @Inject
  public CharacterApiMapper() {
    super();
  }

  public List<People> transform(List<String> characterURLs) {
    List<People> peopleList = new ArrayList<>(characterURLs.size());
    for(String URL : characterURLs) {
      String peopleId = extractId(URL);
      People people = new People(peopleId);
      peopleList.add(people);
    }
    return peopleList;
  }
}

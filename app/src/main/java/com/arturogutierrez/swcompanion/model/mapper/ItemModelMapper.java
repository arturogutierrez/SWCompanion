package com.arturogutierrez.swcompanion.model.mapper;

import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.Item;
import com.arturogutierrez.swcompanion.model.ItemModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ItemModelMapper {

  private final FilmModelMapper filmModelMapper;

  @Inject
  public ItemModelMapper(FilmModelMapper filmModelMapper) {
    this.filmModelMapper = filmModelMapper;
  }

  public List<ItemModel> transform(List<? extends Item> recentItems) {
    List<ItemModel> itemModels = new ArrayList<>(recentItems.size());
    for (Item item : recentItems) {
      ItemModel itemModel = transform(item);
      itemModels.add(itemModel);
    }
    return itemModels;
  }

  public ItemModel transform(Item item) {
    ItemModel itemModel = null;
    // TODO: Change to Map in order to avoi if/elseif/elseif....
    if (item instanceof Film) {
      itemModel = filmModelMapper.transform((Film) item);
    }
    return itemModel;
  }
}

package com.arturogutierrez.swcompanion.view;

import com.arturogutierrez.swcompanion.model.ItemModel;
import java.util.List;

public interface RecentItemsView extends LoadDataView {

  void renderRecentItems(List<ItemModel> items);

  void viewNoItems();

  void showDetails(ItemModel transform);
}

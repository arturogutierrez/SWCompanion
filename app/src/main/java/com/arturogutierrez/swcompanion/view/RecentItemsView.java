package com.arturogutierrez.swcompanion.view;

import com.arturogutierrez.swcompanion.model.FilmModel;
import java.util.List;

public interface RecentItemsView extends LoadDataView {

  void renderRecentItems(List<FilmModel> films);

  void viewNoItems();
}

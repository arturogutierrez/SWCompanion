package com.arturogutierrez.swcompanion.view;

import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.List;

public interface RecentItemsView extends LoadDataView {

  void renderRecentItems(List<Film> films);

  void viewNoItems();
}

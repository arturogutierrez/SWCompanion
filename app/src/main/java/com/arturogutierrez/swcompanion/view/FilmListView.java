package com.arturogutierrez.swcompanion.view;

import com.arturogutierrez.swcompanion.model.FilmModel;
import java.util.List;

public interface FilmListView extends LoadDataView {

  void renderFilms(List<FilmModel> films);

  void viewNoItems();

  void showDetails(FilmModel filmModel);
}

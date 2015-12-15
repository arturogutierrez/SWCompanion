package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.domain.model.Film;

public interface SWLocalDataStore extends SWDataStore {

  void saveFilm(Film film);
}

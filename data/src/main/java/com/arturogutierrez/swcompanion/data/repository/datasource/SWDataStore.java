package com.arturogutierrez.swcompanion.data.repository.datasource;

import com.arturogutierrez.swcompanion.domain.model.Film;
import java.util.List;
import rx.Observable;

public interface SWDataStore {

  Observable<List<Film>> getFilms();
}

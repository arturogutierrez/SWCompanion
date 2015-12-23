package com.arturogutierrez.swcompanion.domain.interactor;

import com.arturogutierrez.swcompanion.domain.executor.PostExecutionThread;
import com.arturogutierrez.swcompanion.domain.executor.ThreadExecutor;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.repository.SWRepository;
import java.util.List;
import rx.Observable;

public class FilmListInteractor extends Interactor<List<Film>> {

  private final SWRepository swRepository;

  public FilmListInteractor(SWRepository swRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.swRepository = swRepository;
  }

  @Override
  public Observable<List<Film>> createObservable() {
    return swRepository.getFilms();
  }
}

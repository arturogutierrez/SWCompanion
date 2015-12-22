package com.arturogutierrez.swcompanion.domain.interactor;

import com.arturogutierrez.swcompanion.domain.executor.PostExecutionThread;
import com.arturogutierrez.swcompanion.domain.executor.ThreadExecutor;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.Item;
import com.arturogutierrez.swcompanion.domain.repository.SWRepository;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class RecentItemsInteractor extends Interactor<List<Item>> {

  private final SWRepository swRepository;

  public RecentItemsInteractor(SWRepository swRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.swRepository = swRepository;
  }

  @Override
  public Observable<List<Item>> createObservable() {
    if (hasRecentItems()) {
      // TODO: Ask recent items
    }

    return getDefaultItemsObservable();
  }

  private boolean hasRecentItems() {
    // TODO: Save recent items viewed
    return false;
  }

  public Observable<List<Item>> getDefaultItemsObservable() {

    Observable<Film> lastFilmObservable = swRepository.getFilm("7");
    Observable<Film> firstFilmObservable = swRepository.getFilm("1");

    return Observable.concat(lastFilmObservable, firstFilmObservable).toList().map(ArrayList::new);
  }
}

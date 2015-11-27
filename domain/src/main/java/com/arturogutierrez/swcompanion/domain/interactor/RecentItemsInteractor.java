package com.arturogutierrez.swcompanion.domain.interactor;

import com.arturogutierrez.swcompanion.domain.executor.PostExecutionThread;
import com.arturogutierrez.swcompanion.domain.executor.ThreadExecutor;
import com.arturogutierrez.swcompanion.domain.model.Item;
import java.util.List;
import rx.Observable;

public class RecentItemsInteractor extends Interactor<List<Item>> {

  public RecentItemsInteractor(ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
  }

  @Override
  public Observable<List<Item>> createObservable() {
    return null;
  }
}

package com.arturogutierrez.swcompanion.di.module;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.domain.executor.PostExecutionThread;
import com.arturogutierrez.swcompanion.domain.executor.ThreadExecutor;
import com.arturogutierrez.swcompanion.domain.interactor.RecentItemsInteractor;
import com.arturogutierrez.swcompanion.domain.repository.SWRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RecentItemsModule {

  public RecentItemsModule() {

  }

  @PerActivity
  @Provides
  RecentItemsInteractor provideRecentItemsInteractor(SWRepository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new RecentItemsInteractor(repository, threadExecutor, postExecutionThread);
  }
}

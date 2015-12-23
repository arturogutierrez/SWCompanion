package com.arturogutierrez.swcompanion.di.module;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.domain.executor.PostExecutionThread;
import com.arturogutierrez.swcompanion.domain.executor.ThreadExecutor;
import com.arturogutierrez.swcompanion.domain.interactor.FilmListInteractor;
import com.arturogutierrez.swcompanion.domain.repository.SWRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class FilmsModule {

  public FilmsModule() {

  }

  @PerActivity
  @Provides
  FilmListInteractor provideFilmListInteractor(SWRepository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new FilmListInteractor(repository, threadExecutor, postExecutionThread);
  }
}

package com.arturogutierrez.swcompanion.di.module;

import android.content.Context;
import android.view.LayoutInflater;
import com.arturogutierrez.swcompanion.data.executor.JobExecutor;
import com.arturogutierrez.swcompanion.data.repository.SWRepositoryImpl;
import com.arturogutierrez.swcompanion.domain.executor.PostExecutionThread;
import com.arturogutierrez.swcompanion.domain.executor.ThreadExecutor;
import com.arturogutierrez.swcompanion.domain.repository.SWRepository;
import com.arturogutierrez.swcompanion.executor.MainThread;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

  private final Context context;

  public ApplicationModule(Context context) {
    this.context = context;
  }

  @Provides
  Context provideApplicationContext() {
    return context;
  }

  @Provides
  LayoutInflater provideLayoutInflater() {
    return LayoutInflater.from(context);
  }

  @Singleton
  @Provides
  SWRepository provideSWRepository(SWRepositoryImpl swRepository) {
    return swRepository;
  }

  @Provides
  @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides
  @Singleton
  PostExecutionThread providePostExecutionThread(MainThread mainThread) {
    return mainThread;
  }
}

package com.arturogutierrez.swcompanion.di.module;

import android.content.Context;
import android.view.LayoutInflater;
import dagger.Module;
import dagger.Provides;

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
}

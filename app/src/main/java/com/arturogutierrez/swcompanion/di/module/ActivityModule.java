package com.arturogutierrez.swcompanion.di.module;

import android.app.Activity;
import com.arturogutierrez.swcompanion.di.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  @PerActivity
  Activity activity() {
    return activity;
  }
}

package com.arturogutierrez.swcompanion.application;

import android.app.Application;
import com.arturogutierrez.swcompanion.di.component.ApplicationComponent;
import com.arturogutierrez.swcompanion.di.component.DaggerApplicationComponent;
import com.arturogutierrez.swcompanion.di.module.ApplicationModule;

public class SWApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    initialize();
  }

  private void initialize() {
    initializeDependencyInjector();
  }

  private void initializeDependencyInjector() {
    applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}

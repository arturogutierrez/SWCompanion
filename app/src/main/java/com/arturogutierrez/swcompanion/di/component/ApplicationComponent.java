package com.arturogutierrez.swcompanion.di.component;

import android.content.Context;
import android.view.LayoutInflater;
import com.arturogutierrez.swcompanion.di.module.ApplicationModule;
import com.arturogutierrez.swcompanion.view.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);

  Context context();

  LayoutInflater layoutInflater();
}

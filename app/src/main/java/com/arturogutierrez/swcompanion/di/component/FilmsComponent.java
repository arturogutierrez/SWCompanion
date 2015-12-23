package com.arturogutierrez.swcompanion.di.component;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.di.module.ActivityModule;
import com.arturogutierrez.swcompanion.di.module.FilmsModule;
import com.arturogutierrez.swcompanion.view.activity.MainActivity;
import com.arturogutierrez.swcompanion.view.fragment.FilmListFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, FilmsModule.class
})
public interface FilmsComponent {
  void inject(MainActivity mainActivity);

  void inject(FilmListFragment filmListFragment);
}

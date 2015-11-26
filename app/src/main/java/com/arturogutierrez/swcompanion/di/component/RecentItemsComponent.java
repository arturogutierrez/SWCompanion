package com.arturogutierrez.swcompanion.di.component;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.di.module.ActivityModule;
import com.arturogutierrez.swcompanion.di.module.RecentItemsModule;
import com.arturogutierrez.swcompanion.view.activity.MainActivity;
import com.arturogutierrez.swcompanion.view.fragment.RecentItemsFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, RecentItemsModule.class
})
public interface RecentItemsComponent {
  void inject(MainActivity mainActivity);

  void inject(RecentItemsFragment recentItemsFragment);
}

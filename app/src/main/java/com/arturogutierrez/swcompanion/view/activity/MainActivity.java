package com.arturogutierrez.swcompanion.view.activity;

import android.os.Bundle;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.di.HasComponent;
import com.arturogutierrez.swcompanion.di.component.DaggerRecentItemsComponent;
import com.arturogutierrez.swcompanion.di.component.RecentItemsComponent;
import com.arturogutierrez.swcompanion.di.module.RecentItemsModule;
import com.arturogutierrez.swcompanion.view.fragment.RecentItemsFragment;

public class MainActivity extends BaseActivity implements HasComponent<RecentItemsComponent> {

  private RecentItemsComponent recentItemsComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initializeActivity(savedInstanceState);
  }

  @Override
  protected int getLayoutResource() {
    return R.layout.activity_main;
  }

  @Override
  public RecentItemsComponent getComponent() {
    return recentItemsComponent;
  }

  private void initializeActivity(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      configureInjector();
      configureMainFragment();
    }
  }

  private void configureInjector() {
    recentItemsComponent = DaggerRecentItemsComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .recentItemsModule(new RecentItemsModule())
        .build();
    recentItemsComponent.inject(this);
  }

  private void configureMainFragment() {
    RecentItemsFragment recentItemsFragment = new RecentItemsFragment();
    addFragment(R.id.content_frame, recentItemsFragment);
  }
}

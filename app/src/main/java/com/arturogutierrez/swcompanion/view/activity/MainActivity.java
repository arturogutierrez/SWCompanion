package com.arturogutierrez.swcompanion.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.di.HasComponent;
import com.arturogutierrez.swcompanion.di.component.DaggerRecentItemsComponent;
import com.arturogutierrez.swcompanion.di.component.RecentItemsComponent;
import com.arturogutierrez.swcompanion.di.module.RecentItemsModule;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.view.adapter.MainFragmentPageAdapter;
import com.arturogutierrez.swcompanion.view.fragment.RecentItemsFragment;

public class MainActivity extends BaseActivity implements HasComponent<RecentItemsComponent>,
    RecentItemsFragment.RecentItemsListener {

  private RecentItemsComponent recentItemsComponent;

  @Bind(R.id.tab_layout)
  TabLayout tabLayout;
  @Bind(R.id.view_pager)
  ViewPager viewPager;

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

  @Override
  public void showDetails(ItemModel itemModel) {
    navigator.goToDetails(this, itemModel);
  }

  private void initializeActivity(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      configureInjector();
      configureViewPager();
    }
  }

  private void configureInjector() {
    recentItemsComponent = DaggerRecentItemsComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .recentItemsModule(new RecentItemsModule())
        .build();
    recentItemsComponent.inject(this);
    ButterKnife.bind(this);
  }

  private void configureViewPager() {
    MainFragmentPageAdapter fragmentPageAdapter =
        new MainFragmentPageAdapter(this, getSupportFragmentManager());
    viewPager.setAdapter(fragmentPageAdapter);
    tabLayout.setupWithViewPager(viewPager);
  }
}

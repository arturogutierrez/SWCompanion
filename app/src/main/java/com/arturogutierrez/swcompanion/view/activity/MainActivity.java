package com.arturogutierrez.swcompanion.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.di.HasComponent;
import com.arturogutierrez.swcompanion.di.component.DaggerFilmsComponent;
import com.arturogutierrez.swcompanion.di.component.FilmsComponent;
import com.arturogutierrez.swcompanion.di.module.FilmsModule;
import com.arturogutierrez.swcompanion.model.FilmModel;
import com.arturogutierrez.swcompanion.view.adapter.MainFragmentPageAdapter;
import com.arturogutierrez.swcompanion.view.fragment.FilmListFragment;

public class MainActivity extends BaseActivity
    implements HasComponent<FilmsComponent>, FilmListFragment.FilmListListener {

  private FilmsComponent filmsComponent;

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
  public FilmsComponent getComponent() {
    return filmsComponent;
  }

  @Override
  public void showDetails(FilmModel filmModel) {
    navigator.goToDetails(this, filmModel);
  }

  private void initializeActivity(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      configureInjector();
      configureViewPager();
    }
  }

  private void configureInjector() {
    filmsComponent = DaggerFilmsComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .filmsModule(new FilmsModule())
        .build();
    filmsComponent.inject(this);
    ButterKnife.bind(this);
  }

  private void configureViewPager() {
    MainFragmentPageAdapter fragmentPageAdapter =
        new MainFragmentPageAdapter(this, getSupportFragmentManager());
    viewPager.setAdapter(fragmentPageAdapter);
    tabLayout.setupWithViewPager(viewPager);
  }
}

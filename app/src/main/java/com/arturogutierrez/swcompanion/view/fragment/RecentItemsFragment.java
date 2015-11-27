package com.arturogutierrez.swcompanion.view.fragment;

import android.os.Bundle;
import com.arturogutierrez.swcompanion.di.component.RecentItemsComponent;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.presenter.RecentItemsPresenter;
import com.arturogutierrez.swcompanion.view.RecentItemsView;
import java.util.List;
import javax.inject.Inject;

public class RecentItemsFragment extends BaseFragment implements RecentItemsView {

  @Inject
  RecentItemsPresenter recentItemsPresenter;

  public RecentItemsFragment() {
    super();
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    initialize();
    loadItems();
  }

  @Override
  public void onResume() {
    super.onResume();

    recentItemsPresenter.resume();
  }

  @Override
  public void onPause() {
    super.onPause();

    recentItemsPresenter.pause();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    recentItemsPresenter.destroy();
  }

  private void initialize() {
    initializeInjector();
  }

  private void initializeInjector() {
    getComponent(RecentItemsComponent.class).inject(this);
  }

  private void loadItems() {
    recentItemsPresenter.loadRecentItems();
  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void renderRecentItems(List<Film> films) {

  }

  @Override
  public void viewNoItems() {

  }
}

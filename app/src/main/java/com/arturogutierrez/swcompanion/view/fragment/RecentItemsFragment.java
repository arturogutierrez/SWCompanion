package com.arturogutierrez.swcompanion.view.fragment;

import android.os.Bundle;
import com.arturogutierrez.swcompanion.di.component.RecentItemsComponent;

public class RecentItemsFragment extends BaseFragment {

  public RecentItemsFragment() {
    super();
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    initialize();
    loadItems();
  }

  private void initialize() {
    initializeInjector();
  }

  private void initializeInjector() {
    getComponent(RecentItemsComponent.class).inject(this);
  }

  private void loadItems() {
    //TODO: Call to presenter
  }
}

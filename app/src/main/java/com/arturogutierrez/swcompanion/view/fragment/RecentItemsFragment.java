package com.arturogutierrez.swcompanion.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.di.component.RecentItemsComponent;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.presenter.RecentItemsPresenter;
import com.arturogutierrez.swcompanion.view.RecentItemsView;
import com.arturogutierrez.swcompanion.view.adapter.ItemPreviewsAdapter;
import java.util.List;
import javax.inject.Inject;

public class RecentItemsFragment extends ItemListFragment implements RecentItemsView {

  @Inject
  RecentItemsPresenter recentItemsPresenter;

  private ItemPreviewsAdapter itemsAdapter;

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
    recentItemsPresenter.setView(this);
  }

  private void initializeInjector() {
    getComponent(RecentItemsComponent.class).inject(this);
  }

  private void loadItems() {
    recentItemsPresenter.loadRecentItems();
  }

  @Override
  public void renderRecentItems(List<ItemModel> items) {
    if (itemsAdapter == null) {
      itemsAdapter = new ItemPreviewsAdapter(getContext(), items);
    }

    rvRecentItems.setAdapter(itemsAdapter);
  }

  @Override
  public void viewNoItems() {

  }
}

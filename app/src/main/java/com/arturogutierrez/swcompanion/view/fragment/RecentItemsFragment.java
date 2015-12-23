package com.arturogutierrez.swcompanion.view.fragment;

import android.content.Context;
import android.os.Bundle;
import com.arturogutierrez.swcompanion.di.component.RecentItemsComponent;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.presenter.RecentItemsPresenter;
import com.arturogutierrez.swcompanion.view.RecentItemsView;
import com.arturogutierrez.swcompanion.view.adapter.ItemPreviewsAdapter;
import java.util.List;
import javax.inject.Inject;

public class RecentItemsFragment extends ItemListFragment implements RecentItemsView {

  public interface RecentItemsListener {
    void showDetails(final ItemModel itemModel);
  }

  @Inject
  RecentItemsPresenter recentItemsPresenter;

  private ItemPreviewsAdapter itemsAdapter;
  private RecentItemsListener listener;

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
  public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof RecentItemsListener) {
      this.listener = (RecentItemsListener) context;
    }
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
      itemsAdapter = new ItemPreviewsAdapter(getContext(), items,
          recentItemsPresenter::showDetailsFromItemAtPosition);
    }

    rvRecentItems.setAdapter(itemsAdapter);
  }

  @Override
  public void viewNoItems() {

  }

  @Override
  public void showDetails(ItemModel itemModel) {
    listener.showDetails(itemModel);
  }
}

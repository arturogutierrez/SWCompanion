package com.arturogutierrez.swcompanion.presenter;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.domain.interactor.DefaultSubscriber;
import com.arturogutierrez.swcompanion.domain.interactor.RecentItemsInteractor;
import com.arturogutierrez.swcompanion.domain.model.Item;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.model.mapper.ItemModelMapper;
import com.arturogutierrez.swcompanion.view.RecentItemsView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class RecentItemsPresenter extends DefaultSubscriber<List<Item>> implements Presenter {

  private final RecentItemsInteractor recentItemsInteractor;
  private final ItemModelMapper itemModelMapper;
  private final List<Item> recentItems;

  private RecentItemsView recentItemsView;

  @Inject
  public RecentItemsPresenter(RecentItemsInteractor recentItemsInteractor,
      ItemModelMapper itemModelMapper) {
    this.recentItemsInteractor = recentItemsInteractor;
    this.itemModelMapper = itemModelMapper;
    this.recentItems = new ArrayList<>();
  }

  public void setView(RecentItemsView recentItemsView) {
    this.recentItemsView = recentItemsView;
  }

  @Override
  public void resume() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void destroy() {
    recentItemsInteractor.unsubscribe();
  }

  public void loadRecentItems() {
    showLoading();
    retrieveRecentItems();
  }

  @Override
  public void onCompleted() {
    hideLoading();
  }

  @Override
  public void onError(Throwable e) {
    hideLoading();

    recentItemsView.viewNoItems();
  }

  @Override
  public void onNext(List<Item> recentItemsLoaded) {
    if (recentItemsLoaded == null || recentItemsLoaded.size() == 0) {
      recentItemsView.viewNoItems();
      return;
    }

    recentItems.clear();
    recentItems.addAll(recentItemsLoaded);

    List<ItemModel> itemModelList = itemModelMapper.transform(recentItems);
    recentItemsView.renderRecentItems(itemModelList);
  }

  public void showDetailsFromItemAtPosition(int position) {
    Item item = recentItems.get(position);
    recentItemsView.showDetails(itemModelMapper.transform(item));
  }

  private void showLoading() {
    recentItemsView.showLoading();
  }

  private void hideLoading() {
    recentItemsView.hideLoading();
  }

  private void retrieveRecentItems() {
    recentItemsInteractor.execute(this);
  }
}

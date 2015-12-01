package com.arturogutierrez.swcompanion.presenter;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.domain.interactor.DefaultSubscriber;
import com.arturogutierrez.swcompanion.domain.interactor.RecentItemsInteractor;
import com.arturogutierrez.swcompanion.domain.model.Item;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.model.mapper.ItemModelMapper;
import com.arturogutierrez.swcompanion.view.RecentItemsView;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class RecentItemsPresenter extends DefaultSubscriber<List<Item>> implements Presenter {

  private final RecentItemsInteractor recentItemsInteractor;
  private final ItemModelMapper itemModelMapper;

  private RecentItemsView recentItemsView;

  @Inject
  public RecentItemsPresenter(RecentItemsInteractor recentItemsInteractor,
      ItemModelMapper itemModelMapper) {
    this.recentItemsInteractor = recentItemsInteractor;
    this.itemModelMapper = itemModelMapper;
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

    // TODO: Show an error to the user
  }

  @Override
  public void onNext(List<Item> recentItems) {
    List<ItemModel> itemModelList = itemModelMapper.transform(recentItems);
    recentItemsView.renderRecentItems(itemModelList);
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

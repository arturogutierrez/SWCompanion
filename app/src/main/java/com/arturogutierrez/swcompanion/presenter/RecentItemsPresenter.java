package com.arturogutierrez.swcompanion.presenter;

import com.arturogutierrez.swcompanion.di.PerActivity;
import com.arturogutierrez.swcompanion.domain.interactor.DefaultSubscriber;
import com.arturogutierrez.swcompanion.domain.interactor.RecentItemsInteractor;
import com.arturogutierrez.swcompanion.domain.model.Item;
import com.arturogutierrez.swcompanion.view.RecentItemsView;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class RecentItemsPresenter extends DefaultSubscriber<List<Item>> implements Presenter {

  private final RecentItemsInteractor recentItemsInteractor;

  private RecentItemsView recentItemsView;

  @Inject
  public RecentItemsPresenter(RecentItemsInteractor recentItemsInteractor) {
    this.recentItemsInteractor = recentItemsInteractor;
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
    // TODO: Convert to app model
    //recentItemsView.renderRecentItems(recentItemsModel);
  }

  private void showLoading() {
    recentItemsView.showLoading();
  }

  private void hideLoading() {
    recentItemsView.hideLoading();
  }

  private void retrieveRecentItems() {
    //recentItemsInteractor.execute(this);
  }
}

package com.arturogutierrez.swcompanion.view.fragment;

import android.content.Context;
import android.os.Bundle;
import com.arturogutierrez.swcompanion.di.component.FilmsComponent;
import com.arturogutierrez.swcompanion.model.FilmModel;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.presenter.FilmListPresenter;
import com.arturogutierrez.swcompanion.view.FilmListView;
import com.arturogutierrez.swcompanion.view.adapter.ItemPreviewsAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FilmListFragment extends ItemListFragment implements FilmListView {

  public interface FilmListListener {
    void showDetails(final FilmModel filmModel);
  }

  @Inject
  FilmListPresenter filmListPresenter;

  private ItemPreviewsAdapter itemsAdapter;
  private FilmListListener listener;

  public FilmListFragment() {
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

    if (context instanceof FilmListListener) {
      this.listener = (FilmListListener) context;
    }
  }

  @Override
  public void onResume() {
    super.onResume();

    filmListPresenter.resume();
  }

  @Override
  public void onPause() {
    super.onPause();

    filmListPresenter.pause();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    filmListPresenter.destroy();
  }

  private void initialize() {
    initializeInjector();
    filmListPresenter.setView(this);
  }

  private void initializeInjector() {
    getComponent(FilmsComponent.class).inject(this);
  }

  private void loadItems() {
    filmListPresenter.loadFilms();
  }

  @Override
  public void renderFilms(List<FilmModel> films) {
    if (itemsAdapter == null) {
      List<ItemModel> items = new ArrayList<>(films);
      itemsAdapter = new ItemPreviewsAdapter(getContext(), items,
          filmListPresenter::showDetailsFromItemAtPosition);
    }

    rvRecentItems.setAdapter(itemsAdapter);
  }

  @Override
  public void viewNoItems() {

  }

  @Override
  public void showDetails(FilmModel itemModel) {
    listener.showDetails(itemModel);
  }
}

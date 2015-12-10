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
import com.arturogutierrez.swcompanion.view.LoadDataView;
import com.arturogutierrez.swcompanion.view.widget.InsetDecoration;

public class ItemListFragment extends BaseFragment implements LoadDataView {

  @Bind(R.id.rv_preview_items)
  RecyclerView rvRecentItems;
  @Bind(R.id.pb_loading)
  ProgressBar pbLoading;

  public ItemListFragment() {
    super();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_recent_items, container, false);

    ButterKnife.bind(this, fragmentView);
    configureUI();

    return fragmentView;
  }

  @Override
  public void showLoading() {
    pbLoading.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    pbLoading.setVisibility(View.GONE);
  }

  private void configureUI() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    rvRecentItems.setLayoutManager(linearLayoutManager);
    rvRecentItems.addItemDecoration(new InsetDecoration(getContext()));
  }
}

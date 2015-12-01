package com.arturogutierrez.swcompanion.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;

public abstract class PreviewItemViewHolder extends RecyclerView.ViewHolder {

  public PreviewItemViewHolder(View itemView) {
    super(itemView);

    ButterKnife.bind(this, itemView);
  }
}

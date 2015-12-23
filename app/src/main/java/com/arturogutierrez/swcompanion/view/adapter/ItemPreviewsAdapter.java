package com.arturogutierrez.swcompanion.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.model.FilmModel;
import com.arturogutierrez.swcompanion.model.ItemModel;
import com.arturogutierrez.swcompanion.view.holder.FilmPreviewViewHolder;
import com.arturogutierrez.swcompanion.view.holder.PreviewItemViewHolder;
import java.util.List;

public class ItemPreviewsAdapter extends RecyclerView.Adapter<PreviewItemViewHolder> {

  private final Context context;
  private final LayoutInflater layoutInflater;
  private final List<ItemModel> itemModelList;
  private final RecyclerClickListener recyclerClickListener;

  public ItemPreviewsAdapter(Context context, List<ItemModel> itemModelList,
      RecyclerClickListener recyclerClickListener) {
    this.context = context;
    this.layoutInflater = LayoutInflater.from(context);
    this.itemModelList = itemModelList;
    this.recyclerClickListener = recyclerClickListener;
  }

  @Override
  public PreviewItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // TODO: Add more type of cards
    int cardResource = R.layout.card_preview_film;
    CardView filmCardView = (CardView) layoutInflater.inflate(cardResource, parent, false);
    return new FilmPreviewViewHolder(filmCardView);
  }

  @Override
  public void onBindViewHolder(PreviewItemViewHolder holder, int position) {
    ItemModel itemModel = itemModelList.get(position);
    // TODO: Check type correctly
    FilmPreviewViewHolder filmPreviewViewHolder = (FilmPreviewViewHolder) holder;
    filmPreviewViewHolder.showFilm(context, (FilmModel) itemModel);
    filmPreviewViewHolder.itemView.setOnClickListener(
        v -> recyclerClickListener.onElementClicked(position));
  }

  @Override
  public int getItemCount() {
    return itemModelList.size();
  }
}

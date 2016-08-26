package com.maxwell.androidwarehouse2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.models.Items;
import com.maxwell.androidwarehouse2.viewholders.ItemViewHolder;

import java.util.List;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class RVAdapter extends RecyclerView.Adapter<ItemViewHolder>{
    List<Items> itemsList;
    Context ctx;

    public RVAdapter(List<Items> itemsList, Context ctx){
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v,ctx);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.populate(itemsList.get(position));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}

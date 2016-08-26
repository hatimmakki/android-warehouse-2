package com.maxwell.androidwarehouse2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.models.File;
import com.maxwell.androidwarehouse2.models.Items;
import com.maxwell.androidwarehouse2.viewholders.FileViewHolder;
import com.maxwell.androidwarehouse2.viewholders.ItemViewHolder;

import java.util.List;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class FileAdapter extends RecyclerView.Adapter<FileViewHolder>{
    List<File> itemsList;
    Context ctx;

    public FileAdapter(List<File> itemsList, Context ctx){
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);

        FileViewHolder pvh = new FileViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(FileViewHolder holder, int position) {
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

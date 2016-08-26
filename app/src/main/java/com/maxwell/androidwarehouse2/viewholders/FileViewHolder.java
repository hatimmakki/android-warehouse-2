package com.maxwell.androidwarehouse2.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.models.File;
import com.maxwell.androidwarehouse2.models.Items;

/**
 * Created by Maxwell on 26/08/2016.
 */
public class FileViewHolder extends RecyclerView.ViewHolder {
    public TextView nameItem;

    public FileViewHolder(View v) {
        super(v);

        nameItem = (TextView)v.findViewById(R.id.nameItem);
    }

    public void populate(File file){
        nameItem.setText(file.getNameItem());
    }
}

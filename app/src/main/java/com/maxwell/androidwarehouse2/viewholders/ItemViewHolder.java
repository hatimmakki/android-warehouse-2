package com.maxwell.androidwarehouse2.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.models.Items;

/**
 * Created by Maxwell on 26/08/2016.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView nameItem;
    public RelativeLayout rlItem;
    public CardView cardView;
    public Context ctx;

    public ItemViewHolder(View itemView, Context ctx) {
        super(itemView);
        this.ctx = ctx;

        nameItem = (TextView)itemView.findViewById(R.id.nameItem);
        rlItem = (RelativeLayout)itemView.findViewById(R.id.rlItem);
        cardView = (CardView)itemView.findViewById(R.id.cardView);
    }

    public void populate(Items itemsList){
        final Class className = itemsList.getClassItem();

        nameItem.setText(itemsList.getNameItem());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx,className);
                ctx.startActivity(i);
            }
        });
    }
}

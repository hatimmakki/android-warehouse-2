package com.maxwell.androidwarehouse2.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 15/08/2016.
 */
public class TweetsViewHolder extends RecyclerView.ViewHolder {
    public ImageView userPhoto;
    public TextView tvFullName, tvUserName, tvTweet, tvRetweetCount,
            tvFavoriteCount, tvVerified, tvTimeZone;

    public TweetsViewHolder(View v) {
        super(v);

        userPhoto = (ImageView) v.findViewById(R.id.userPhoto);
        tvFullName = (TextView) v.findViewById(R.id.tvFullName);
        tvUserName = (TextView) v.findViewById(R.id.tvUserName);
        tvTweet = (TextView) v.findViewById(R.id.tvTweet);
        tvRetweetCount = (TextView) v.findViewById(R.id.tvRetweetCount);
        tvFavoriteCount = (TextView) v.findViewById(R.id.tvFavoriteCount);
        tvVerified = (TextView) v.findViewById(R.id.tvVerified);
        tvTimeZone = (TextView) v.findViewById(R.id.tvTimeZone);
    }
}

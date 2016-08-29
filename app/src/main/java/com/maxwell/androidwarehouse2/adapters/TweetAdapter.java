package com.maxwell.androidwarehouse2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.models.twitter.Status;
import com.maxwell.androidwarehouse2.models.twitter.Tweet;
import com.maxwell.androidwarehouse2.viewholders.TweetsViewHolder;

/**
 * Created by Maxwell on 15/08/2016.
 */
public class TweetAdapter extends RecyclerView.Adapter<TweetsViewHolder> {
    Status tweetList;
    Context ctx;

    public TweetAdapter(Status tweetList, Context ctx){
        this.tweetList = tweetList;
        this.ctx = ctx;
    }

    @Override
    public TweetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tweet, parent, false);

        return new TweetsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TweetsViewHolder holder, int position) {
        Tweet tweet = tweetList.getStatuses().get(position);

        Glide.with(ctx).load(tweet.getUser().getProfileImageUrl()).into(holder.userPhoto);

        holder.tvFullName.setText(tweet.getUser().getName());
        holder.tvUserName.setText("@" + tweet.getUser().getScreenName());
        holder.tvTweet.setText(tweet.getText());

        String reTweets = "Retweets: " + tweet.getRetweetCount();
        holder.tvRetweetCount.setText(reTweets);

        String favorites = "Favorites: " + tweet.getFavoriteCount();
        holder.tvFavoriteCount.setText(favorites);

        if(tweet.getUser().isVerified())
            holder.tvVerified.setText("Verified: YES");
        else
            holder.tvVerified.setText("Verified: NO");

        if(tweet.getUser().getTimeZone() != null)
            holder.tvTimeZone.setText("TimeZone: " + tweet.getUser().getTimeZone());
        else
            holder.tvTimeZone.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        if(tweetList.getStatuses() != null)
            return tweetList.getStatuses().size();
        else
            return 0;
    }

    public void clearTweetList(){
        if(tweetList.getStatuses() != null)
            tweetList.getStatuses().clear();
    }

    public void setTweetList(Status tweetList) {
        this.tweetList = tweetList;
    }
}

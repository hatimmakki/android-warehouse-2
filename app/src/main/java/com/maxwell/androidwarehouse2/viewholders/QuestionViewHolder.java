package com.maxwell.androidwarehouse2.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 15/08/2016.
 */
public class QuestionViewHolder extends RecyclerView.ViewHolder {
    public ImageView userPhoto;
    public TextView tvTitleQuestion, tvAuthor, tvVotes, tvAnswer, tvViews;
    public CardView cvItemQuestion;

    public QuestionViewHolder(View v) {
        super(v);

        userPhoto = (ImageView) v.findViewById(R.id.userPhoto);
        tvTitleQuestion = (TextView) v.findViewById(R.id.tvTitleQuestion);
        tvAuthor = (TextView) v.findViewById(R.id.tvAuthor);
        tvVotes = (TextView) v.findViewById(R.id.tvVotes);
        tvAnswer = (TextView) v.findViewById(R.id.tvAnswer);
        tvViews = (TextView) v.findViewById(R.id.tvViews);
        cvItemQuestion = (CardView) v.findViewById(R.id.cvItemQuestion);
    }
}

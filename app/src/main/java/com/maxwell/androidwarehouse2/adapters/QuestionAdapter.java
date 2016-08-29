package com.maxwell.androidwarehouse2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.models.stackoverflow.items;
import com.maxwell.androidwarehouse2.models.stackoverflow.question;
import com.maxwell.androidwarehouse2.viewholders.QuestionViewHolder;

/**
 * Created by Maxwell on 15/08/2016.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {
    items<question> questionList;
    Context ctx;

    public QuestionAdapter(items<question> questionList, Context ctx){
        this.questionList = questionList;
        this.ctx = ctx;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false);

        return new QuestionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        final question question = questionList.getItems().get(position);
        String score = String.valueOf(question.getScore()) + System.getProperty ("line.separator") + "Score";
        String anwser = String.valueOf(question.getAnswer_count()) + System.getProperty ("line.separator") + "Answer";
        String view = String.valueOf(question.getView_count()) + System.getProperty ("line.separator") + "View";

        holder.tvTitleQuestion.setText(Html.fromHtml(question.getTitle()));
        holder.tvAuthor.setText(question.getOwner().getDisplay_name());
        holder.tvVotes.setText(score);
        holder.tvAnswer.setText(anwser);
        holder.tvViews.setText(view);
        Glide.with(ctx).load(question.getOwner().getProfile_image()).into(holder.userPhoto);
    }

    @Override
    public int getItemCount() {
        if(questionList != null && questionList.getItems() != null)
            return questionList.getItems().size();
        else
            return 0;
    }

    public void clearQuestionList(){
        if(questionList != null && questionList.getItems() != null)
            questionList.getItems().clear();
    }

    public void setQuestionList(items<question> questionList) {
        this.questionList = questionList;
    }
}

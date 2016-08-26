package com.maxwell.androidwarehouse2.models;

import java.util.List;

/**
 * Created by Maxwell on 12/08/2016.
 */
public class StackOverflowQuestion {
    List<String> tags;
    StackOverflowOwner owner;
    boolean is_answered;
    int view_count;
    int answer_count;
    int score;
    String last_activity_date;
    String creation_date;
    int question_id;
    String title;
    String link;
    String body;

    public List<String> getTags() {
        return tags;
    }

    public StackOverflowOwner getOwner() {
        return owner;
    }

    public boolean is_answered() {
        return is_answered;
    }

    public int getView_count() {
        return view_count;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public int getScore() {
        return score;
    }

    public String getLast_activity_date() {
        return last_activity_date;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getBody() {
        return body;
    }
}

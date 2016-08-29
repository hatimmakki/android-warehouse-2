package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class Tweet {
    Contributor contributors;
    Coordinates coordinates;
    @SerializedName("created_at")
    String createdAt;
    Entities entities;
    @SerializedName("favorite_count")
    String favoriteCount;
    boolean favorited;
    @SerializedName("filter_level")
    String filterLevel;
    long id;
    @SerializedName("id_str")
    String idStr;
    @SerializedName("in_reply_to_screen_name")
    String inReplyToScreenName;
    @SerializedName("in_reply_to_status_id")
    long inReplyToStatusId;
    @SerializedName("in_reply_to_status_id_str")
    String inReplyToStatusIdStr;
    @SerializedName("in_reply_to_user_id")
    long inReplyToUserId;
    @SerializedName("in_reply_to_user_id_str")
    String inReplyToUserIdStr;
    String lang;
    Places place;
    @SerializedName("retweet_count")
    int retweetCount;
    String source;
    String text;
    boolean truncated;
    User user;

    public Contributor getContributors() {
        return contributors;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Entities getEntities() {
        return entities;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public String getFilterLevel() {
        return filterLevel;
    }

    public long getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public String getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public String getLang() {
        return lang;
    }

    public Places getPlace() {
        return place;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public String getSource() {
        return source;
    }

    public String getText() {
        return text;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public User getUser() {
        return user;
    }
}

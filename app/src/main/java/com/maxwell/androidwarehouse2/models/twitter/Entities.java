package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class Entities {
    HashTag[] hashtags;
    Media[] media;
    Url[] urls;
    @SerializedName("user_mentions")
    UserMention[] userMentions;

    public HashTag[] getHashtags() {
        return hashtags;
    }

    public Media[] getMedia() {
        return media;
    }

    public Url[] getUrls() {
        return urls;
    }

    public UserMention[] getUserMentions() {
        return userMentions;
    }
}

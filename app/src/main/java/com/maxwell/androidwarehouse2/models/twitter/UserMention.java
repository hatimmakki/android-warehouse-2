package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class UserMention {
    long id;
    @SerializedName("id_str")
    String idStr;
    int[] indices;
    String name;
    @SerializedName("screen_name")
    String screenName;

    public long getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public int[] getIndices() {
        return indices;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }
}

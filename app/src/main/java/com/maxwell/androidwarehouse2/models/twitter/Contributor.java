package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class Contributor {
    int id;
    @SerializedName("id_str")
    String idStr;
    @SerializedName("screen_name")
    String screenName;

    public int getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public String getScreenName() {
        return screenName;
    }
}

package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class Url {
    @SerializedName("display_url")
    String displayUrl;
    @SerializedName("expanded_url")
    String expandedUrl;
    int[] indices;
    String url;

    public String getDisplayUrl() {
        return displayUrl;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public int[] getIndices() {
        return indices;
    }

    public String getUrl() {
        return url;
    }
}

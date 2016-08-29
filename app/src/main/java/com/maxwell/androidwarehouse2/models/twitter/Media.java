package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class Media {
    @SerializedName("display_url")
    String displayUrl;
    @SerializedName("expanded_url")
    String expandedUrl;
    long id;
    @SerializedName("id_str")
    String idStr;
    int[] indices;
    @SerializedName("media_url")
    String mediaUrl;
    @SerializedName("media_url_https")
    String mediaUrlHttps;
    Sizes sizes;
    @SerializedName("source_status_id")
    long sourceStatusId;
    @SerializedName("source_status_id_str")
    String sourceStatusIdStr;
    String type;
    String url;

    public String getDisplayUrl() {
        return displayUrl;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public long getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public int[] getIndices() {
        return indices;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public long getSourceStatusId() {
        return sourceStatusId;
    }

    public String getSourceStatusIdStr() {
        return sourceStatusIdStr;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}

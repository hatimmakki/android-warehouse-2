package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class User {
    @SerializedName("created_at")
    String createdAt;
    String description;
    Entities entities;
    @SerializedName("favourites_count")
    int favouritesCount;
    boolean following;
    @SerializedName("followers_count")
    int followersCount;
    @SerializedName("geo_enabled")
    boolean geoEnabled;
    long id;
    String lang;
    @SerializedName("listed_count")
    int listedCount;
    String location;
    String name;
    boolean notifications;
    @SerializedName("profile_background_color")
    String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    String profileBackgroundImageUrl;
    @SerializedName("profile_image_url")
    String profileImageUrl;
    @SerializedName("screen_name")
    String screenName;
    Tweet status;
    @SerializedName("time_zone")
    String timeZone;
    String url;
    boolean verified;


    public String getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public Entities getEntities() {
        return entities;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public boolean isFollowing() {
        return following;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public long getId() {
        return id;
    }

    public String getLang() {
        return lang;
    }

    public int getListedCount() {
        return listedCount;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public Tweet getStatus() {
        return status;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getUrl() {
        return url;
    }

    public boolean isVerified() {
        return verified;
    }
}

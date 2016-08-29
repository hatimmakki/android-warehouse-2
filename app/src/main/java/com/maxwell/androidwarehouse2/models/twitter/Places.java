package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class Places {
    PlaceAttributes attributes;
    String country;
    @SerializedName("country_code")
    String countryCode;
    @SerializedName("full_name")
    String fullName;
    String id;
    String name;
    @SerializedName("place_type")
    String placeType;
    String url;

    public PlaceAttributes getAttributes() {
        return attributes;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlaceType() {
        return placeType;
    }

    public String getUrl() {
        return url;
    }
}

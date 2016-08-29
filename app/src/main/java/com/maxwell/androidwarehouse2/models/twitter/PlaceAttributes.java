package com.maxwell.androidwarehouse2.models.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class PlaceAttributes {
    @SerializedName("street_address")
    String streetAddress;
    String locality;
    String region;
    @SerializedName("postal_code")
    String postalCode;
    String phone;
    String twitter;
    String url;

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getLocality() {
        return locality;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getUrl() {
        return url;
    }
}

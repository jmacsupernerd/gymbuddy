package com.mcwilliams.gymbuddy.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by joshuamcwilliams on 7/27/14.
 */
public class Location implements Serializable {
    @SerializedName("lat")
    private double Latitude;
    @SerializedName("lng")
    private double Longitude;

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}

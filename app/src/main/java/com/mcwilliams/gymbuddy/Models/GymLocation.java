package com.mcwilliams.gymbuddy.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by joshuamcwilliams on 7/27/14.
 */
public class GymLocation implements Serializable{
    @SerializedName("formatted_address")
    private String address;
    @SerializedName("name")
    private String gymName;
    @SerializedName("geometry")
    private Geometry geometry;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
}

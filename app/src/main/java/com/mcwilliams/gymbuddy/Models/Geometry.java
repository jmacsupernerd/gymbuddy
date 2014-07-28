package com.mcwilliams.gymbuddy.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by joshuamcwilliams on 7/27/14.
 */
public class Geometry implements Serializable {
    @SerializedName("location")
    private Location gymCooridinates;

    public Location getGymCooridinates() {
        return gymCooridinates;
    }

    public void setGymCooridinates(Location gymCooridinates) {
        this.gymCooridinates = gymCooridinates;
    }
}

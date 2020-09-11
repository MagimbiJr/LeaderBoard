package com.tana.leaderboard.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LearningLeaders implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("hour")
    private int hour;
    @SerializedName("country")
    private String country;
//    @SerializedName("badgeUrl")
//    private String badgeUrl;

    public LearningLeaders(String name, int hour, String country) {
        this.name = name;
        this.hour = hour;
        this.country = country;
//        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public String getBadgeUrl() {
//        return badgeUrl;
//    }
//
//    public void setBadgeUrl(String badgeUrl) {
//        this.badgeUrl = badgeUrl;
//    }

}

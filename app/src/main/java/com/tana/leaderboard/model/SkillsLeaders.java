package com.tana.leaderboard.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SkillsLeaders implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("score")
    private int score;
    @SerializedName("country")
    private String country;
//    @SerializedName("badgeUrl")
//    private String badgeUrl;

    public SkillsLeaders(String name, int score, String country) {
        this.name = name;
        this.score = score;
        this.country = country;
//        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

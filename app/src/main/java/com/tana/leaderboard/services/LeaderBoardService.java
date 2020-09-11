package com.tana.leaderboard.services;


import com.tana.leaderboard.model.LearningLeaders;
import com.tana.leaderboard.model.SkillsLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardService {
    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearners();

    @GET("/api/skilliq")
    Call<List<SkillsLeaders>> getSkillIq();
}

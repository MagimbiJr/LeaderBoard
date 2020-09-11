package com.tana.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tana.leaderboard.model.SkillsLeaders;
import com.tana.leaderboard.services.LeaderBoardService;
import com.tana.leaderboard.services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillsIQFragment extends Fragment {

    View mView;
    private RecyclerView mSkillsLeadersList;
    private List<SkillsLeaders> mSkillsLeaders;

    public SkillsIQFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_skills_iq, container, false);
        mSkillsLeadersList = (RecyclerView) mView.findViewById(R.id.skills_leader_list);

        LinearLayoutManager skillsLayoutManager = new LinearLayoutManager(getContext());
        mSkillsLeadersList.setLayoutManager(skillsLayoutManager);

        mSkillsLeaders = new ArrayList<>();


        LeaderBoardService skillsService = ServiceBuilder.buildService(LeaderBoardService.class);
        Call<List<SkillsLeaders>> call = skillsService.getSkillIq();
        call.enqueue(new Callback<List<SkillsLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillsLeaders>> call, Response<List<SkillsLeaders>> response) {
                mSkillsLeaders = response.body();
                mSkillsLeadersList.setAdapter(new SkillsRecyclerAdapter(getContext(), mSkillsLeaders));
            }

            @Override
            public void onFailure(Call<List<SkillsLeaders>> call, Throwable t) {

            }
        });
        return mView;
    }
}
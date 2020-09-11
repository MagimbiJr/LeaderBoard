package com.tana.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tana.leaderboard.model.LearningLeaders;
import com.tana.leaderboard.services.LeaderBoardService;
import com.tana.leaderboard.services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningFragment extends Fragment {
    View mView;
    private RecyclerView mLearningLeadersList;
    private List<LearningLeaders> mLeaders;
    private LinearLayoutManager mLearnersLayoutManager;

    public LearningFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_learning, container, false);
        mLearningLeadersList = (RecyclerView) mView.findViewById(R.id.learning_leaders_list);

        mLearnersLayoutManager = new LinearLayoutManager(getContext());
        mLearningLeadersList.setLayoutManager(mLearnersLayoutManager);
        mLeaders = new ArrayList<>();

        LeaderBoardService learningService = ServiceBuilder.buildService(LeaderBoardService.class);
        Call<List<LearningLeaders>> call = learningService.getLearners();
        call.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                mLeaders = response.body();
                mLearningLeadersList.setAdapter(new LearningRecyclerAdapter(getContext(), mLeaders));
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                Toast.makeText(getContext(), "Operation Failed", Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }
}
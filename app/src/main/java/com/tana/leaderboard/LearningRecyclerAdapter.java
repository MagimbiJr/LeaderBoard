package com.tana.leaderboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tana.leaderboard.model.LearningLeaders;

import java.util.List;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<LearningLeaders> mLeadersList;
    private final LayoutInflater mLayoutInflater;

    public LearningRecyclerAdapter(Context context, List<LearningLeaders> leadersList) {
        mContext = context;
        mLeadersList = leadersList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_learning_leaders, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningLeaders learningLeaders = mLeadersList.get(position);
        holder.mLearnerName.setText(learningLeaders.getName());
        holder.mHours.setText(learningLeaders.getHour() + " learning hours, ");
        holder.mCountry.setText(learningLeaders.getCountry());
        holder.mLearnerBadge.setImageResource(R.drawable.top_learner);
    }

    @Override
    public int getItemCount() {
        return mLeadersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLearnerName;
        public final TextView mHours;
        public final TextView mCountry;
        public final ImageView mLearnerBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearnerBadge = (ImageView) itemView.findViewById(R.id.learners_badge);
            mLearnerName = (TextView) itemView.findViewById(R.id.learners_name);
            mHours = (TextView) itemView.findViewById(R.id.hours);
            mCountry = (TextView) itemView.findViewById(R.id.country);
        }
    }
}

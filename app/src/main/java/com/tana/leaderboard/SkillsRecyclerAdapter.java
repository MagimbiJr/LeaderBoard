package com.tana.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tana.leaderboard.model.SkillsLeaders;

import java.util.List;

public class SkillsRecyclerAdapter extends RecyclerView.Adapter<SkillsRecyclerAdapter.ViewHolder> {
    private final Context mContext;
    private final List<SkillsLeaders> mSkillsLeaders;
    private final LayoutInflater mLayoutInflater;

    public SkillsRecyclerAdapter(Context context, List<SkillsLeaders> skillsLeaders) {
        mContext = context;
        mSkillsLeaders = skillsLeaders;

        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_skills_leaders, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillsLeaders skillsLeaders = mSkillsLeaders.get(position);
        holder.mSkillIQName.setText(skillsLeaders.getName());
        holder.mScore.setText(skillsLeaders.getScore() + " skill IQ score, ");
        holder.mCountry.setText(skillsLeaders.getCountry());
        holder.mBadgeUrl.setImageResource(R.drawable.skill_iq_trimmed);
    }

    @Override
    public int getItemCount() {
        return mSkillsLeaders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mSkillIQName;
        public final TextView mScore;
        public final TextView mCountry;
        public final ImageView mBadgeUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSkillIQName = (TextView) itemView.findViewById(R.id.skill_iq_name);
            mScore = (TextView) itemView.findViewById(R.id.score);
            mCountry = (TextView) itemView.findViewById(R.id.country);
            mBadgeUrl = (ImageView) itemView.findViewById(R.id.img_skills);
        }
    }
}

package com.tana.leaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LeaderBoardPagerAdapter extends FragmentPagerAdapter {
    private int mNumOfPages;
    public LeaderBoardPagerAdapter(@NonNull FragmentManager fm, int numOfPages) {
        super(fm);
        this.mNumOfPages = numOfPages;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LearningFragment();
            case 1:
                return new SkillsIQFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfPages;
    }
}

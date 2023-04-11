package com.nkh.livescore.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nkh.livescore.ui.bundesliga.MatchBundesFragment;
import com.nkh.livescore.ui.bundesliga.StandingBundesFragment;
import com.nkh.livescore.ui.bundesliga.TopAssistBundesFragment;
import com.nkh.livescore.ui.bundesliga.TopScoreBundesFragment;
import com.nkh.livescore.ui.seria.MatchSeriaFragment;
import com.nkh.livescore.ui.seria.StandingSeriaFragment;
import com.nkh.livescore.ui.seria.TopAssistSeriaFragment;
import com.nkh.livescore.ui.seria.TopScoreSeriaFragment;

public class ViewPagerSeriaAdapter extends FragmentStatePagerAdapter {

    public ViewPagerSeriaAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MatchSeriaFragment();
            case 1:
                return new StandingSeriaFragment();
            case 2:
                return new TopScoreSeriaFragment();
            case 3:
                return new TopAssistSeriaFragment() ;
            default:
                return new StandingSeriaFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Trận đấu";
                break;
            case 1:
                title = "Bảng xếp hạng";
                break;
            case 2:
                title = "Top ghi bàn";
                break;
            case 3:
                title = "Top kiến tạo";
                break;

        }
        return title;
    }
}

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
import com.nkh.livescore.ui.league1.MatchLeague1Fragment;
import com.nkh.livescore.ui.league1.StandingLeague1Fragment;
import com.nkh.livescore.ui.league1.TopAssistLeague1Fragment;
import com.nkh.livescore.ui.league1.TopScoreLeague1Fragment;

public class ViewPagerLeague1Adapter extends FragmentStatePagerAdapter {

    public ViewPagerLeague1Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MatchLeague1Fragment();
            case 1:
                return new StandingLeague1Fragment();
            case 2:
                return new TopScoreLeague1Fragment();
            case 3:
                return new TopAssistLeague1Fragment() ;
            default:
                return new StandingLeague1Fragment();
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

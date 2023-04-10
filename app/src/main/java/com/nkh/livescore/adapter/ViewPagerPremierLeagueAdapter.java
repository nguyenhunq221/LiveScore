package com.nkh.livescore.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.nkh.livescore.ui.PremierLeague.MatchFragment;
import com.nkh.livescore.ui.PremierLeague.StandingFragment;
import com.nkh.livescore.ui.PremierLeague.TopScoreFragment;
import com.nkh.livescore.ui.PremierLeague.TopAssistFragment;

public class ViewPagerPremierLeagueAdapter extends FragmentStatePagerAdapter {

    public ViewPagerPremierLeagueAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MatchFragment();
            case 1:
                return new StandingFragment();
            case 2:
                return new TopScoreFragment();
            case 3:
                return new TopAssistFragment() ;
            default:
                return new StandingFragment();
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

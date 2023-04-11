package com.nkh.livescore.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nkh.livescore.ui.Laliga.MatchLaligaFragment;
import com.nkh.livescore.ui.Laliga.StandingLaligaFragment;
import com.nkh.livescore.ui.Laliga.TopAssistLaligaFragment;
import com.nkh.livescore.ui.Laliga.TopScoreLaligaFragment;
import com.nkh.livescore.ui.bundesliga.MatchBundesFragment;
import com.nkh.livescore.ui.bundesliga.StandingBundesFragment;
import com.nkh.livescore.ui.bundesliga.TopAssistBundesFragment;
import com.nkh.livescore.ui.bundesliga.TopScoreBundesFragment;

public class ViewPagerBundesligaAdapter extends FragmentStatePagerAdapter {

    public ViewPagerBundesligaAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MatchBundesFragment();
            case 1:
                return new StandingBundesFragment();
            case 2:
                return new TopScoreBundesFragment();
            case 3:
                return new TopAssistBundesFragment() ;
            default:
                return new StandingBundesFragment();
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

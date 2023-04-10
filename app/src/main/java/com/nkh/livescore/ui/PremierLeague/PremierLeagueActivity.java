package com.nkh.livescore.ui.PremierLeague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.nkh.livescore.R;
import com.nkh.livescore.adapter.ViewPagerPremierLeagueAdapter;
import com.nkh.livescore.databinding.ActivityPremierLeagueBinding;
import com.nkh.livescore.model.Standing.StandingDetail;

import java.util.List;

public class PremierLeagueActivity extends AppCompatActivity {

    private ActivityPremierLeagueBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPremierLeagueBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        setUpView();
    }

    private void setUpView() {
        binding.topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ViewPagerPremierLeagueAdapter viewPagerPremierLeagueAdapter = new ViewPagerPremierLeagueAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(viewPagerPremierLeagueAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.setOffscreenPageLimit(2);
    }

}
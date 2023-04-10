package com.nkh.livescore.ui.Laliga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.view.View;

import com.nkh.livescore.R;
import com.nkh.livescore.adapter.ViewPagerLaligaAdapter;
import com.nkh.livescore.adapter.ViewPagerPremierLeagueAdapter;
import com.nkh.livescore.databinding.ActivityLaligaBinding;

public class LaligaActivity extends AppCompatActivity {
    private ActivityLaligaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityLaligaBinding.inflate(getLayoutInflater());
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

        ViewPagerLaligaAdapter viewPagerLaligaAdapter = new ViewPagerLaligaAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(viewPagerLaligaAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.setOffscreenPageLimit(2);
    }
}
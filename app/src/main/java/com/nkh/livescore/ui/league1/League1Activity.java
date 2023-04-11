package com.nkh.livescore.ui.league1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.view.View;

import com.nkh.livescore.R;
import com.nkh.livescore.adapter.ViewPagerBundesligaAdapter;
import com.nkh.livescore.adapter.ViewPagerLeague1Adapter;
import com.nkh.livescore.databinding.ActivityLeague1Binding;

public class League1Activity extends AppCompatActivity {
    private ActivityLeague1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeague1Binding.inflate(getLayoutInflater());
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

        ViewPagerLeague1Adapter viewPagerLeague1Adapter = new ViewPagerLeague1Adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(viewPagerLeague1Adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.setOffscreenPageLimit(2);
    }
}
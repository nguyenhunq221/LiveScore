package com.nkh.livescore.ui.bundesliga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.view.View;

import com.nkh.livescore.R;
import com.nkh.livescore.adapter.ViewPagerBundesligaAdapter;
import com.nkh.livescore.adapter.ViewPagerLaligaAdapter;
import com.nkh.livescore.databinding.ActivityBundesligaBinding;

public class BundesligaActivity extends AppCompatActivity {
    private ActivityBundesligaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBundesligaBinding.inflate(getLayoutInflater());
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

        ViewPagerBundesligaAdapter viewPagerBundesligaAdapter = new ViewPagerBundesligaAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(viewPagerBundesligaAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.setOffscreenPageLimit(2);
    }
}
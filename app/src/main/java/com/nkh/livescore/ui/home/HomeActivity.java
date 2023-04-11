package com.nkh.livescore.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nkh.livescore.R;
import com.nkh.livescore.adapter.BannerAdapter;
import com.nkh.livescore.databinding.ActivityHomeBinding;
import com.nkh.livescore.ui.Laliga.LaligaActivity;
import com.nkh.livescore.ui.PremierLeague.PremierLeagueActivity;
import com.nkh.livescore.ui.bundesliga.BundesligaActivity;
import com.nkh.livescore.ui.league1.League1Activity;
import com.nkh.livescore.ui.seria.SeriaActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    BannerAdapter adapter;
    ArrayList<Integer> imageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        setUpView();
    }

    private void setUpView() {
        binding.PremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PremierLeagueActivity.class));
            }
        });

        binding.laliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LaligaActivity.class));
            }
        });

        binding.bundesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BundesligaActivity.class));
            }
        });

        binding.cardViewLeague1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, League1Activity.class));
            }
        });

        binding.seriaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SeriaActivity.class));
            }
        });



        imageList= new ArrayList<>();
        imageList.add(R.drawable.ic_champion_league);
        imageList.add(R.drawable.europaleague);
        imageList.add(R.drawable.quata);
        imageList.add(R.drawable.euro);

        adapter = new BannerAdapter(this,imageList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false);
        binding.rcvBanner.setLayoutManager(linearLayoutManager);
        binding.rcvBanner.setAdapter(adapter);

    }
}
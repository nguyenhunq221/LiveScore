package com.nkh.livescore.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nkh.livescore.R;
import com.nkh.livescore.adapter.SliderAdapter;
import com.nkh.livescore.databinding.FragmentHomeBinding;
import com.nkh.livescore.ui.Laliga.LaligaActivity;
import com.nkh.livescore.ui.PremierLeague.PremierLeagueActivity;
import com.nkh.livescore.ui.bundesliga.BundesligaActivity;
import com.nkh.livescore.ui.league1.League1Activity;
import com.nkh.livescore.ui.seria.SeriaActivity;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    List<Integer> images = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpView();

        images.add(R.drawable.ic_champion_league);
        images.add(R.drawable.ic_europaleague);
        images.add(R.drawable.euro);
        images.add(R.drawable.quata);

        SliderAdapter adapter = new SliderAdapter(this.getActivity(), images);
        //below method is used to set auto cycle direction in left to right direction you can change according to requirement.
        binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        //below method is used to setadapter to sliderview.
        binding.slider.setSliderAdapter(adapter);
        //below method is use to set scroll time in seconds.
        binding.slider.setScrollTimeInSec(4);
        //to set it scrollable automatically we use below method.
        binding.slider.setAutoCycle(true);
        //to start autocycle below method is used.
        binding.slider.startAutoCycle();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    private void setUpView() {
        binding.PremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PremierLeagueActivity.class));
            }
        });

        binding.laliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LaligaActivity.class));
            }
        });

        binding.bundesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BundesligaActivity.class));
            }
        });

        binding.cardViewLeague1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), League1Activity.class));
            }
        });

        binding.seriaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SeriaActivity.class));
            }
        });

    }
}
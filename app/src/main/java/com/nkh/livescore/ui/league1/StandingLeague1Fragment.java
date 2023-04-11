package com.nkh.livescore.ui.league1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.nkh.livescore.adapter.StandingsAdapter;
import com.nkh.livescore.databinding.FragmentStandingBinding;
import com.nkh.livescore.model.Standing.StandingDetail;
import com.nkh.livescore.model.topScore.ResponseDetail;
import com.nkh.livescore.ui.PremierLeague.PremierLeagueLogic;

import java.util.ArrayList;
import java.util.List;

public class StandingLeague1Fragment extends Fragment implements PremierLeagueLogic.PremierLeagueEvent {

    private FragmentStandingBinding binding;

    PremierLeagueLogic logic = new PremierLeagueLogic(getActivity(), this);

    StandingsAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStandingBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new StandingsAdapter(this.getActivity(),new ArrayList<>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.rcvStanding.setLayoutManager(linearLayoutManager);
        binding.rcvStanding.setAdapter(adapter);

        logic.showStandings(61);
    }


    @Override
    public void onShowStandingSuccess(List<StandingDetail> standingDetailList) {
        adapter.addStandings(standingDetailList);
        Log.e("hung", "onShowStandingSuccess: "+ standingDetailList.size() );
    }

    @Override
    public void onShowStandingFail(String error) {

    }

    @Override
    public void onShowTopScoreSuccess(List<ResponseDetail> topScoreList) {

    }

    @Override
    public void onShowTopScoreFail(String errors) {

    }

    @Override
    public void onShowFixtureSuccess(List<com.nkh.livescore.model.Fixture.ResponseDetail> listFixture) {

    }

    @Override
    public void onShowFixtureFail(String errors) {

    }
}
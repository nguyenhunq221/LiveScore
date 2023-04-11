package com.nkh.livescore.ui.league1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.nkh.livescore.adapter.FixtureAdapter;
import com.nkh.livescore.databinding.FragmentMatchBinding;
import com.nkh.livescore.model.Standing.StandingDetail;
import com.nkh.livescore.model.topScore.ResponseDetail;
import com.nkh.livescore.ui.PremierLeague.PremierLeagueLogic;

import java.util.ArrayList;
import java.util.List;

public class MatchLeague1Fragment extends Fragment implements PremierLeagueLogic.PremierLeagueEvent {

    private FragmentMatchBinding binding;

    PremierLeagueLogic logic = new PremierLeagueLogic(getActivity(), this);

    FixtureAdapter fixtureAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMatchBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fixtureAdapter = new FixtureAdapter(this.getActivity(),new ArrayList<>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.rcvMatch.setLayoutManager(linearLayoutManager);
        binding.rcvMatch.setAdapter(fixtureAdapter);

        logic.showFixture(61);
    }

    @Override
    public void onShowStandingSuccess(List<StandingDetail> standingDetailList) {

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
        fixtureAdapter.addFixture(listFixture);
    }

    @Override
    public void onShowFixtureFail(String errors) {

    }
}
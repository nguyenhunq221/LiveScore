package com.nkh.livescore.ui.PremierLeague;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.nkh.livescore.Config.Constant;
import com.nkh.livescore.api.ApiService;
import com.nkh.livescore.model.Fixture.FixtureModel;
import com.nkh.livescore.model.Standing.StandingDetail;
import com.nkh.livescore.model.Standing.StandingModel;
import com.nkh.livescore.model.topScore.ResponseDetail;
import com.nkh.livescore.model.topScore.TopScoreModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PremierLeagueLogic {

    Context context;

    PremierLeagueEvent PremierLeagueEvent;

    public PremierLeagueLogic(Context context, PremierLeagueLogic.PremierLeagueEvent premierLeagueEvent) {
        this.context = context;
        PremierLeagueEvent = premierLeagueEvent;
    }

    public void showStandings(int id){

        ApiService.service.getStandings(Constant.key,id,2022).enqueue(new Callback<StandingModel>() {
            @Override
            public void onResponse(Call<StandingModel> call, Response<StandingModel> response) {

                Log.e("hung", "onRequest: "+call.request() );

                Log.e("hung", "onResponseCode: " +response.body().getResults() );

                Log.e("hung", "onResponse: "+response.body().getResponse().get(0).getLeague().getStandings().get(0).get(0).getHieuSo() );

                PremierLeagueEvent.onShowStandingSuccess(response.body().getResponse().get(0).getLeague().getStandings().get(0));
            }

            @Override
            public void onFailure(Call<StandingModel> call, Throwable t) {
                String error = " Loading error";
                Log.e("hung", "onFailure: "+t.getMessage() );
                PremierLeagueEvent.onShowStandingFail(error);
            }
        });

    }

    public void showTopScore (int id){
        ApiService.service.getTopScore(Constant.key,id,2022).enqueue(new Callback<TopScoreModel>() {
            @Override
            public void onResponse(Call<TopScoreModel> call, Response<TopScoreModel> response) {

                Log.e("hung1", "onRequest: "+call.request() );

                Log.e("hung1", "onResponseCode: " +response.body().getResponse().size() );

                PremierLeagueEvent.onShowTopScoreSuccess(response.body().getResponse());
            }

            @Override
            public void onFailure(Call<TopScoreModel> call, Throwable t) {
                String error = " Loading error";
                Log.e("hung1", "onFailure: "+t.getMessage() );
                PremierLeagueEvent.onShowTopScoreFail(error);
            }
        });

    }

    public void showTopAssist (int id){
        ApiService.service.getTopAssist(Constant.key,id,2022).enqueue(new Callback<TopScoreModel>() {
            @Override
            public void onResponse(Call<TopScoreModel> call, Response<TopScoreModel> response) {

                Log.e("hung1", "onRequest: "+call.request() );

                Log.e("hung1", "onResponseCode: " +response.body().getResponse().size() );

                PremierLeagueEvent.onShowTopScoreSuccess(response.body().getResponse());
            }

            @Override
            public void onFailure(Call<TopScoreModel> call, Throwable t) {
                String error = " Loading error";
                Log.e("hung1", "onFailure: "+t.getMessage() );
                PremierLeagueEvent.onShowTopScoreFail(error);
            }
        });

    }

    public void showFixture (int id){
        ApiService.service.getFixture(Constant.key,id,2022,Constant.time_zone).enqueue(new Callback<FixtureModel>() {
            @Override
            public void onResponse(Call<FixtureModel> call, Response<FixtureModel> response) {

                Log.e("fixture", "onRequest: "+call.request() );

                Log.e("fixture", "onResponseCode: " +response.body().getResponse().size() );

                PremierLeagueEvent.onShowFixtureSuccess(response.body().getResponse());
            }

            @Override
            public void onFailure(Call<FixtureModel> call, Throwable t) {
                String error = " Loading error";
                Log.e("fixture", "onFailure: "+t.getMessage() );
                PremierLeagueEvent.onShowFixtureFail(error);
            }
        });

    }

    public interface PremierLeagueEvent {
        void onShowStandingSuccess(List<StandingDetail> standingDetailList);

        void onShowStandingFail(String error);

        void onShowTopScoreSuccess(List<ResponseDetail> topScoreList);

        void onShowTopScoreFail(String errors);

        void onShowFixtureSuccess(List<com.nkh.livescore.model.Fixture.ResponseDetail> listFixture);

        void onShowFixtureFail(String errors);
    }

}


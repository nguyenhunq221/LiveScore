package com.nkh.livescore.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nkh.livescore.Config.Constant;
import com.nkh.livescore.model.Fixture.FixtureModel;
import com.nkh.livescore.model.Standing.StandingModel;
import com.nkh.livescore.model.topScore.TopScoreModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .create();
    ApiService service = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET(ApiPath.Standings)
    Call<StandingModel> getStandings(@Header("x-rapidapi-key") String header,
                                     @Query("league") int id,
                                     @Query("season") int season

    );

    @GET(ApiPath.TopScore)
    Call<TopScoreModel> getTopScore(@Header("x-rapidapi-key") String header,
                                    @Query("league") int id,
                                    @Query("season") int season

    );
    @GET(ApiPath.TopAssist)
    Call<TopScoreModel> getTopAssist(@Header("x-rapidapi-key") String header,
                                    @Query("league") int id,
                                    @Query("season") int season

    );

    @GET(ApiPath.Fixture)
    Call<FixtureModel> getFixture(@Header("x-rapidapi-key") String header,
                                   @Query("league") int id,
                                   @Query("season") int season,
                                   @Query("timezone") String timezone

    );

}

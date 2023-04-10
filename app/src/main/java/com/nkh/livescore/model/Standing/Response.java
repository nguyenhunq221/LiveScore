package com.nkh.livescore.model.Standing;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("league")
    private league league;

    public com.nkh.livescore.model.Standing.league getLeague() {
        return league;
    }

    public void setLeague(com.nkh.livescore.model.Standing.league league) {
        this.league = league;
    }
}

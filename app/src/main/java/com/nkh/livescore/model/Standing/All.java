package com.nkh.livescore.model.Standing;

public class All {
    private int played;
    private int win;
    private int draw;
    private int lose;
    private goals goals;

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public com.nkh.livescore.model.Standing.goals getGoals() {
        return goals;
    }

    public void setGoals(com.nkh.livescore.model.Standing.goals goals) {
        this.goals = goals;
    }
}

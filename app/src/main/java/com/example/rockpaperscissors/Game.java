package com.example.rockpaperscissors;

public class Game {
    protected Game(boolean p1_played, boolean p2_played) {
        this.p1_played = p1_played;
        this.p2_played = p2_played;
    }

    protected enum Options{
        ROCK, PAPER, SCISSORS
    }
    protected boolean isP1_played() {
        return p1_played;
    }

    protected boolean isP2_played() {
        return p2_played;
    }

    private boolean p1_played;

    protected void setP1_played(boolean p1_played) {
        this.p1_played = p1_played;
    }

    public void setP2_played(boolean p2_played) {
        this.p2_played = p2_played;
    }

    private boolean p2_played;
    private Options p1_status;

    protected String getP1_status() {
        return p1_status.toString();
    }

    protected synchronized void setP1_status(Options p1_status) {
       this.p1_status = p1_status;
    }

    protected String getP2_status() {
        return p2_status.toString();
    }

    protected void setP2_status(Options p2_status) {
        this.p2_status = p2_status;
    }

    private Options p2_status;
    public int calculate()
    {
            if(p1_status == p2_status){
                return 0;
            } else if((p1_status == Options.ROCK && p2_status == Options.SCISSORS)
                    || (p1_status == Options.SCISSORS && p2_status == Options.PAPER)
                    || (p1_status == Options.PAPER && p2_status == Options.ROCK)){
                return 1;
            } else return 2;
    }
    public void newGame(){
        setP1_played(false);
        setP2_played(false);
    }

}

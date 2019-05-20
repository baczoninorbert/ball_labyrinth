package model;


import java.util.List;

public class Labyrinth {
    private int playerx;
    private int playery;
    private int finishx;
    private int finishy;
    private List<String> structure;
    private String playerName;
    private int score = 0;

    public List<String> getStructure() {
        return structure;
    }

    public int getPlayerx() {
        return playerx;
    }

    public int getPlayery() {
        return playery;
    }

    public int getFinishx() {
        return finishx;
    }

    public int getFinishy() {
        return finishy;
    }


    public void setPlayerx(int playerx) {
        this.playerx = playerx;
    }


    public void setPlayery(int playery) {
        this.playery = playery;
    }
}



package model;


import java.util.List;

/**
 * Class that holds the model of the map
 */
public class Labyrinth {

    /**
     * The players horizontal position.
     */
    private int playerx;
    /**
     * The players vertical position.
     */
    private int playery;
    /**
     *  The finishes horizontal position
     */
    private int finishx;
    /**
     *  The finishes vertical position
     */
    private int finishy;
    /**
     *  List that holds the layout of the map
     */
    private List<String> structure;
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

    public void setFinishx(int finishx) {
        this.finishx = finishx;
    }

    public void setFinishy(int finishy) {
        this.finishy = finishy;
    }

    public void setPlayery(int playery) {
        this.playery = playery;
    }

    public void setStructure(List<String> structure) {
        this.structure = structure;
    }
}



package model;

import java.util.HashMap;

public class HighScores {
    private String playername;
    private Score playerpoints;
    private HashMap<String, Score> playerScore;

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public Score getPlayerpoints(String playerName) {
        return playerpoints;
    }

    public void setPlayerpoints(Score playerpoints) {
        this.playerpoints = playerpoints;
    }

    public HashMap<String, Score> getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(HashMap<String, Score> playerScore) {
        this.playerScore = playerScore;
    }
    public void addScore(String playerName, Score playerpoints) {
        if(playerScore == null)
            playerScore = new HashMap<String, Score>();
        playerScore.put(playerName, playerpoints);
    }
    public void removeScore(String playerName) {
        if(playerScore.containsKey(playerName)) {
            playerScore.remove(playerName);
            //logger.info("Removed a player from the score board: " + playerName);
        }
    }
}

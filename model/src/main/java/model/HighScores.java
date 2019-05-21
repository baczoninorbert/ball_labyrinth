package model;

import java.util.HashMap;

/**
 * Class that holds the score
 */
public class HighScores {
    /**
     * The name of the player
     */
    private String playername;
    /**
     * The {@link Score score} of the player.
     */
    private Score playerpoints;
    /**
     *  Class that holds every players score
     */
    private HashMap<String, Score> playerScore;

    public HashMap<String, Score> getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(HashMap<String, Score> playerScore) {
        this.playerScore = playerScore;
    }

    /**
     * Adds player to scorelist
     * @param playerName the name of the player
     * @param playerpoints the score of the player
     */
    public void addScore(String playerName, Score playerpoints) {
        if(playerScore == null)
            playerScore = new HashMap<String, Score>();
        playerScore.put(playerName, playerpoints);
    }

    /**
     * Removes score of the the player.
     * @param playerName the name of the player.
     */
    public void removeScore(String playerName) {
        if(playerScore.containsKey(playerName)) {
            playerScore.remove(playerName);
            //logger.info("Removed a player from the score board: " + playerName);
        }
    }
}

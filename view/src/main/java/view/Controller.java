package view;


import model.Labyrinth;
import model.Reader;
import model.Score;
import org.pmw.tinylog.Logger;
import java.util.HashMap;

/**
 * Object that handles user data and manipulates the data in the {@link model},
 * implements game logic, and calls for visual updates.
 */
public class Controller {



    /**
     * Integer value that holds the steps of the player after the game has been initialized..
     */
    private int steps = 0;


    /**
     * Object that holds the score of the player based on the players steps.
     */
    private Score playersteps;

    /**
     *  Object that holds the name of the player.
     */
    private String playerName;
    /**
     *  The {@link HashMap<String,Integer> PlayersScore} holds the {@link Score score} of the player
     */
    private HashMap<String, Integer> playerlist;


    /**
     * Object that reads, loads and saves {@link Labyrinth gamemap}, {@link model.HighScores}
     */
    private Reader reader = new Reader() ;

    /**
     * Class that handles the scene update after the player makes a step
     */
    OverallView overallView ;

    public void setOverallView(OverallView overallView) {
        this.overallView = overallView;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    /**
     * Checks how many steps can the player make going up.
     * @param labyrinth current structure of the map
     * @param currx current player position horizontally
     * @param curry current player position vertically.
     * @return The number of steps that the player can make upwards.
     */
    public int checkUp(Labyrinth labyrinth, int currx, int curry) {
        int howmanysteps = 0;
        if(currx < 0 || curry < 0 ||
                currx > labyrinth.getStructure().size() - 1 || curry > labyrinth.getStructure().size() - 1)
            return 0;
        while (currx >= 0) {
            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'b' || currchar == 'e' || currchar == 'h' || currchar == 'i' || currchar == 'k'
                    || currchar == 'l' || currchar == 'm' || currchar == 'o') {
                Logger.info("Player can go up " + howmanysteps + " steps");

                return howmanysteps;
            } else {
                howmanysteps++;
            }
            currx--;
        }
        Logger.info("Player can go up 0 steps");
        return 0;

    }

    /**
     * Checks how many steps can the player make going down
     * @param labyrinth current structure of the map
     * @param currx current player position horizontally
     * @param curry current player position vertically.
     * @return number of steps
     */
    public int checkDown(Labyrinth labyrinth, int currx, int curry) {
        int howmanysteps = 0;
        if(currx < 0 || curry < 0 ||
                currx > labyrinth.getStructure().size() - 1 || curry > labyrinth.getStructure().size() - 1)
            return 0;
        while (currx <= labyrinth.getStructure().size() - 1) {
            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'd' || currchar == 'g' || currchar == 'i' || currchar == 'j' || currchar == 'l'
                    || currchar == 'm' || currchar == 'n' || currchar == 'o') {
                Logger.info("Player can go down " + howmanysteps + " steps");
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            currx++;
        }
        Logger.info("Player can go up 0 steps");
        return 0;

    }
    /**
     * Checks how many steps can the player make going left
     * @param labyrinth current structure of the map
     * @param currx current player position horizontally
     * @param curry current player position vertically.
     * @return The number of steps that the player can make left.
     */
    public int checkLeft(Labyrinth labyrinth, int currx, int curry) {
        if(currx < 0 || curry < 0 ||
                currx > labyrinth.getStructure().size() - 1 || curry > labyrinth.getStructure().size() - 1)
            return 0;
        int howmanysteps = 0;
        while (curry >= 0) {
            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'a' || currchar == 'e' || currchar == 'f' || currchar == 'g' || currchar == 'k'
                    || currchar == 'l' || currchar == 'n' || currchar == 'o') {
                Logger.info("Player can go left " + howmanysteps + " steps");
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            curry--;
        }
        Logger.info("Player can go up 0 steps");
        return 0;
    }
    /**
     * Checks how many steps can the player make going right
     * @param labyrinth current structure of the map
     * @param currx current player position horizontally
     * @param curry current player position vertically.
     * @return The number of steps that the player can make right.
     */

    public int checkRight(Labyrinth labyrinth, int currx, int curry) {
        int howmanysteps = 0;
        if(currx < 0 || curry < 0 ||
                currx > labyrinth.getStructure().size() - 1 || curry > labyrinth.getStructure().size() - 1)
                return 0;
        while (currx <= labyrinth.getStructure().size() - 1) {

            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'c' || currchar == 'f' || currchar == 'h' || currchar == 'j' || currchar == 'k'
                    || currchar == 'm' || currchar == 'n' || currchar == 'o') {
                Logger.info("Player can go right " + howmanysteps + " steps");
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            curry++;

        }
        Logger.info("Player can go up 0 steps");
        return 0;
    }

    /**
     * Changes the players position if the player can move upwards
     * @param labyrinth the model of the map
     */
    public void moveUp(Labyrinth labyrinth) {// int currx, int curry) {
        overallView = new OverallView();
        int playerX = labyrinth.getPlayerx();
        int playerY = labyrinth.getPlayery();
        int newPlayerX = playerX - 1;
        int newPlayerY = playerY;
        setSteps(getSteps() + checkUp(labyrinth, playerX, playerY));
        Logger.info("Player will move upwards" + steps + " steps");
        for (int i = 0; i < checkUp(labyrinth, playerX, playerY); i++) {
            Logger.info("Player current x position " + newPlayerX);
            Logger.info("Player current y position " + newPlayerY);
            labyrinth.setPlayerx(newPlayerX);
            labyrinth.setPlayery(newPlayerY);
            overallView.refreshMap(labyrinth);
            newPlayerX--;
        }
    }
    /**
     * Changes the players position if the player can move downwards
     * @param labyrinth the model of the map
     */
        public void moveDown(Labyrinth labyrinth) {// int currx, int curry) {
            overallView = new OverallView();
            int playerX = labyrinth.getPlayerx();
            int playerY = labyrinth.getPlayery();

            int newPlayerX = playerX + 1 ;
            int newPlayerY = playerY;
            setSteps(getSteps() + checkDown(labyrinth, playerX, playerY));
            Logger.info("Player will move downwards" + steps + " steps");
            for (int i = 0; i < checkDown(labyrinth, playerX, playerY); i++) {
                Logger.info("Player current x position " + newPlayerX);
                Logger.info("Player current y position " + newPlayerY);
                labyrinth.setPlayerx(newPlayerX);
                labyrinth.setPlayery(newPlayerY);
                overallView.refreshMap(labyrinth);
                newPlayerX++;
            }
        }
    /**
     * Changes the players position if the player can move left
     * @param labyrinth the model of the map
     */
    public void  moveLeft (Labyrinth labyrinth) {// int currx, int curry) {
        overallView = new OverallView();
        int playerX = labyrinth.getPlayerx();
        int playerY = labyrinth.getPlayery();
        int newPlayerX = playerX;
        int newPlayerY = playerY - 1;
        setSteps(getSteps() + checkLeft(labyrinth, playerX, playerY));
        Logger.info("Player will move left" + steps + " steps");
        for (int i = 0; i < checkLeft(labyrinth, playerX, playerY); i++) {
            Logger.info("Player current x position " + newPlayerX);
            Logger.info("Player current y position " + newPlayerY);
            labyrinth.setPlayerx(newPlayerX);
            labyrinth.setPlayery(newPlayerY);
            overallView.refreshMap(labyrinth);
            newPlayerY--;
        }
    }
    /**
     * Changes the players position if the player can move left
     * @param labyrinth the model of the map
     */
    public void moveRight(Labyrinth labyrinth) {// int currx, int curry) {
        overallView = new OverallView();
        int playerX = labyrinth.getPlayerx();
        int playerY = labyrinth.getPlayery();
        int newPlayerX = playerX;
        int newPlayerY = playerY + 1;
        setSteps(getSteps() +  checkRight(labyrinth, playerX, playerY));
        Logger.info("Player will move right" + steps + " steps");
        for (int i = 0; i < checkRight(labyrinth, playerX, playerY); i++) {
            Logger.info("Player current x position " + newPlayerX);
            Logger.info("Player current y position " + newPlayerY);
            labyrinth.setPlayerx(newPlayerX);
            labyrinth.setPlayery(newPlayerY);
            overallView.refreshMap(labyrinth);
            newPlayerY++;
        }
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    public Score getPlayersteps() {
        return playersteps;
    }

    public void setPlayersteps(Score playersteps) {
        this.playersteps = playersteps;
    }

    public Reader getReader() {
        return reader;
    }


}

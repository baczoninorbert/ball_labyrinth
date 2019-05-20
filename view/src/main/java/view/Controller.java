package view;


import model.Labyrinth;
import model.Reader;
import model.Score;

/** Package that handles user data and manipulates the data in the {@link model},
 * implements game logic, and calls for visual update
 */
import java.util.HashMap;

public class Controller {

/**
 *
 */

    /**
     * The number of moves made after initializing.
     */
    private int steps = 0;
    /**
     * The of the player.
     */
    private Score playersteps;

    /**
     * The name of the player.
     */

    private String playerName;
    /**
     * Map containing the player and their respective score(s).
     */
    private HashMap<String, Integer> playerlist;


    /**
     * Object that reads, loads and saves {@link Labyrinth}, {@link model.HighScores}
     */
    private Reader reader = new Reader();

    /**
     * Object that displays {@link view}
     */
    OverallView overallView ;

    /**
     * Sets the current view
     * @param overallView
     */
    public void setOverallView(OverallView overallView) {
        this.overallView = overallView;
    }

    /**
     * Returns the name of the player
     * @return {@link String}
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the name of the player
     * @param playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    /**
     * Checks how many steps can the player make going up
     * @param labyrinth
     * @param currx
     * @param curry
     * @return {@value}
     */
    public int checkUp(Labyrinth labyrinth, int currx, int curry) {
        int howmanysteps = 0;
        System.out.println("jelenlegi x " + currx);
        System.out.println("checkup while elott");
        while (currx >= 0) {
            System.out.println("Checkup whileba");
            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'b' || currchar == 'e' || currchar == 'h' || currchar == 'i' || currchar == 'k'
                    || currchar == 'l' || currchar == 'm' || currchar == 'o') {
                System.out.println("van lepes" + howmanysteps);
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            currx--;
        }
        System.out.println("eljutottam a 0-ashoz");
        return 0;

    }

    /**
     * Checks how many steps can the player make going down
     * @param labyrinth
     * @param currx
     * @param curry
     * @return {@value}
     */
    public int checkDown(Labyrinth labyrinth, int currx, int curry) {
        int howmanysteps = 0;
        while (currx <= labyrinth.getStructure().size() - 1) {
            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'd' || currchar == 'g' || currchar == 'i' || currchar == 'j' || currchar == 'l'
                    || currchar == 'm' || currchar == 'n' || currchar == 'o') {
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            currx++;
        }
        return 0;

    }
    /**
     * Checks how many steps can the player make going left
     * @param labyrinth
     * @param currx
     * @param curry
     * @return {@value}
     */
    public int checkLeft(Labyrinth labyrinth, int currx, int curry) {
        System.out.println(curry);
        int howmanysteps = 0;
        while (curry >= 0) {
            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'a' || currchar == 'e' || currchar == 'f' || currchar == 'g' || currchar == 'k'
                    || currchar == 'l' || currchar == 'n' || currchar == 'o') {
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            curry--;
        }
        return 0;
    }

    /**
     * Checks how many steps can the player make going right
     * @param labyrinth
     * @param currx
     * @param curry
     * @return {@value}
     */
    public int checkRight(Labyrinth labyrinth, int currx, int curry) {
        int howmanysteps = 0;
        System.out.println(labyrinth.getStructure().size());
        while (currx <= labyrinth.getStructure().size() - 1) {

            char currchar = labyrinth.getStructure().get(currx).toCharArray()[curry];
            if (currchar == 'c' || currchar == 'f' || currchar == 'h' || currchar == 'j' || currchar == 'k'
                    || currchar == 'm' || currchar == 'n' || currchar == 'o') {
                return howmanysteps;
            } else {
                howmanysteps++;
            }
            curry++;

        }
        return 0;
    }

    /**
     * Changes the players position if the player can move upwards
     * @param labyrinth
     */
    public void moveUp(Labyrinth labyrinth) {// int currx, int curry) {
        overallView = new OverallView();
        int playerX = labyrinth.getPlayerx();
        int playerY = labyrinth.getPlayery();
        int newPlayerX = playerX - 1;
        int newPlayerY = playerY;
        setSteps(getSteps() + checkUp(labyrinth, playerX, playerY));
        System.out.println("Ennyi lepest kene visszaadjon" + steps);
        for (int i = 0; i < checkUp(labyrinth, playerX, playerY); i++) {
            System.out.println(newPlayerX);
            System.out.println(newPlayerY);
            labyrinth.setPlayerx(newPlayerX);
            labyrinth.setPlayery(newPlayerY);
            overallView.refreshMap(labyrinth);
            newPlayerX--;
        }
    }
    /**
     * Changes the players position if the player can move downwards
     * @param labyrinth
     */
        public void moveDown(Labyrinth labyrinth) {// int currx, int curry) {
            overallView = new OverallView();
            System.out.println("A labda most lefele fog menni");
            int playerX = labyrinth.getPlayerx();
            int playerY = labyrinth.getPlayery();

            int newPlayerX = playerX + 1 ;
            int newPlayerY = playerY;
            setSteps(getSteps() + checkDown(labyrinth, playerX, playerY));
            System.out.println("most ennyi a steps" + steps);
            for (int i = 0; i < checkDown(labyrinth, playerX, playerY); i++) {
                labyrinth.setPlayerx(newPlayerX);
                labyrinth.setPlayery(newPlayerY);
                overallView.refreshMap(labyrinth);
                newPlayerX++;
            }
        }
    /**
     * Changes the players position if the player can move left
     * @param labyrinth
     */
    public void  moveLeft (Labyrinth labyrinth) {// int currx, int curry) {
        overallView = new OverallView();
        int playerX = labyrinth.getPlayerx();
        int playerY = labyrinth.getPlayery();
        int newPlayerX = playerX;
        int newPlayerY = playerY - 1;
        setSteps(getSteps() + checkLeft(labyrinth, playerX, playerY));
        System.out.println("most ennyi a steps" + steps);
        for (int i = 0; i < checkLeft(labyrinth, playerX, playerY); i++) {
            labyrinth.setPlayerx(newPlayerX);
            labyrinth.setPlayery(newPlayerY);
            overallView.refreshMap(labyrinth);
            newPlayerY--;
        }
    }
    /**
     * Changes the players position if the player can move right
     * @param labyrinth
     */
    public void moveRight(Labyrinth labyrinth) {// int currx, int curry) {
        overallView = new OverallView();
        int playerX = labyrinth.getPlayerx();
        int playerY = labyrinth.getPlayery();
        int newPlayerX = playerX;
        int newPlayerY = playerY + 1;
//        System.out.println("MoveRightba nigag");
        setSteps(getSteps() +  checkRight(labyrinth, playerX, playerY));
        for (int i = 0; i < checkRight(labyrinth, playerX, playerY); i++) {
            labyrinth.setPlayerx(newPlayerX);
            labyrinth.setPlayery(newPlayerY);
            overallView.refreshMap(labyrinth);
            newPlayerY++;
        }
    }

    /**
     * Sets the players current steps
     * @param steps
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Gets the players current steps
     * @return int
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Gets the players current Score
     * @return {@link Score}
     */
    public Score getPlayersteps() {
        return playersteps;
    }

    /**
     * Sets the players current steps
     * @param playersteps
     */
    public void setPlayersteps(Score playersteps) {
        this.playersteps = playersteps;
    }


    /**
     * Gets the reader
     * @return {@link Reader}
     */
    public Reader getReader() {
        return reader;
    }


}

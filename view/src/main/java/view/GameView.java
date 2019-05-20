package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.GameMap;
import model.Labyrinth;
import model.Reader;
import model.Score;

public class GameView {


    private static int steps = 0;
    Controller controller;

    Labyrinth labyrinth;
    OverallView overallView;

    GameMap gameMap;

    private Label movesLabel;
    private static String playerName;
    private static Score score = new Score();
    private Reader reader = new Reader();
    public Scene setGameScene(Labyrinth labyrinth,GameMap gameMap) {
        try {
            overallView = new OverallView();
            controller = new Controller();
            Scene scene;
            Button up = new Button("UP");

            up.setOnMouseClicked((e) -> {
                System.out.println("raclickeltem");
                steps += controller.checkUp(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveUp(labyrinth);

                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    System.out.println("vege van nyertunk :D");
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();

                }
            });
            Button down = new Button("DOWN");
            down.setOnMouseClicked((e) -> {
                System.out.println("raclickeltem");
                steps += controller.checkDown(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveDown(labyrinth);
                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();
                    System.out.println("vege van nyertunk :D");
                    System.out.println("");
                }
            });
            Button right = new Button("RIGHT");
            right.setOnMouseClicked((e) -> {
                System.out.println("raclickeltem");
                steps += controller.checkRight(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveRight(labyrinth);
                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();
                    System.out.println("vege van nyertunk :D");
                }
            });
            Button left = new Button("LEFT");
            left.setOnMouseClicked((e) -> {
                System.out.println("raclickeltem");
                steps += controller.checkLeft(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveLeft(labyrinth);
                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();
                    System.out.println("vege van nyertunk :D");
                }
            });

            HBox buttons = new HBox();
            buttons.setAlignment(Pos.CENTER);
            buttons.setSpacing(10);
            buttons.setPadding(new Insets(0, 20, 10, 20));
            buttons.getChildren().addAll(up, down, left, right);
            VBox gameAndButtons = new VBox();
            gameAndButtons.setAlignment(Pos.TOP_CENTER);
            gameAndButtons.setPadding(new Insets(0, 20, 10, 20));
            movesLabel = new Label("steps: " + steps);
            System.out.println("gamecontrolleres step visszadaasi ertek" + steps);
            System.out.println("A player neve: " + playerName);
            movesLabel.setMinSize(40, 40);
            gameAndButtons.getChildren().addAll(gameMap.createLabyrinth(labyrinth),buttons,movesLabel);
            scene = new Scene(gameAndButtons);
            return scene;
        } catch (Exception e) {
            System.out.println("Nem megy a menu utani scene");
        }
        return null;
    }

        public void refreshGame() {
        /*
        try {
                int x = controller.getPlayerLocation(labyrinth.getStructure())[0];
                int y = controller.getPlayerLocation(labyrinth.getStructure())[1];
                for (int i = 0; i < controller.checkRight(labyrinth, x, y); i++) {
                    x = controller.getPlayerLocation(labyrinth.getStructure())[0];
                    y = controller.getPlayerLocation(labyrinth.getStructure())[1];
                    labyrinth.setStructure(controller.moveUp(labyrinth, x, y));
                    scene = setGameScene();
                }
            }
            catch (Exception ex) {
                System.out.println("Baj van");
            }
        }

         */
        }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }






}

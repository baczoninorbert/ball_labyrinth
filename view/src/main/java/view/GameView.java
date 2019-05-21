package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.GameImageModel;
import model.Labyrinth;
import model.Reader;
import model.Score;
import org.pmw.tinylog.Logger;


/**
 *  Class that holds the Game User Interface.
 */
public class GameView {

    private static int steps = 0;
    Controller controller;

    Labyrinth labyrinth;
    OverallView overallView = new OverallView();

    GameImageModel gameImageModel;

    private Label movesLabel;
    private static String playerName;
    private static Score score = new Score();
    private Reader reader = new Reader();
    public GameView() {
    }
    public Scene setGameScene(Labyrinth labyrinth, GameImageModel gameImageModel) {
        try {
            controller = new Controller();
            Scene scene;
            Button up = new Button("UP");

            up.setOnMouseClicked((e) -> {
                steps += controller.checkUp(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveUp(labyrinth);

                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();

                }
            });


            HBox hBox = new HBox();
            Button down = new Button("DOWN");
            down.setOnMouseClicked((e) -> {
                steps += controller.checkDown(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveDown(labyrinth);
                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();
                }
            });
            Button right = new Button("RIGHT");
            right.setOnMouseClicked((e) -> {
                steps += controller.checkRight(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveRight(labyrinth);
                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();
                }
            });
            Button left = new Button("LEFT");
            left.setOnMouseClicked((e) -> {
                steps += controller.checkLeft(labyrinth,labyrinth.getPlayerx(),labyrinth.getPlayery());
                controller.moveLeft(labyrinth);
                if(labyrinth.getPlayerx() == labyrinth.getFinishx() && labyrinth.getFinishy() == labyrinth.getPlayery()) {
                    score.setSteps(steps);
                    controller.setPlayerName(playerName);
                    controller.setPlayersteps(score);

                    this.overallView.initializeVictoryScene(playerName,steps);
                    reader.getHighScores().addScore(controller.getPlayerName(),controller.getPlayersteps());
                    reader.saveScoreBoard();
                }
            });
            Button back = new Button("BACK");
            back.setOnMouseClicked((e) -> {
                this.overallView.initializeMenu();
            });

            HBox buttons = new HBox();
            buttons.setAlignment(Pos.CENTER);
            buttons.setSpacing(10);
            buttons.setPadding(new Insets(0, 20, 10, 20));
            buttons.getChildren().addAll( left, down, right);
            VBox gameAndButtons = new VBox();
            gameAndButtons.setSpacing(1);
            gameAndButtons.setAlignment(Pos.TOP_CENTER);
            gameAndButtons.setPadding(new Insets(0, 20, 10, 20));
            movesLabel = new Label("steps: " + steps);
            movesLabel.setMinSize(40, 40);
            gameAndButtons.getChildren().addAll(back,gameImageModel.createLabyrinth(labyrinth),up,buttons,movesLabel);
            scene = new Scene(gameAndButtons);
            return scene;
        } catch (Exception e) {
            Logger.info("Couldn't load gameScene");
        }
        return null;
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

    public GameImageModel getGameImageModel() {
        return gameImageModel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setGameImageModel(GameImageModel gameImageModel) {
        this.gameImageModel = gameImageModel;
    }


}

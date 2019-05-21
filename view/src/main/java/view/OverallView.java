package view;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.GameImageModel;
import model.Labyrinth;
import model.Reader;
import org.pmw.tinylog.Logger;

import java.io.IOException;

public class OverallView extends Application {

    Reader reader = new Reader();
    Menu menu;
    GameImageModel gameImageModel;
    Labyrinth labyrinth;
    public static Stage stage;
    private GameView gameView;
    Victory victory;
    private Controller controller;
    private ScoreView scoreView = null;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)throws IOException {

        stage = primaryStage;
        stage.setTitle("Rollout");
        stage.setResizable(false);
        controller = new Controller();
        controller.setOverallView(this);
        initializeMenu();

    }
    public void initializeMenu() {
        try {
            controller = new Controller();
            controller.setOverallView(this);
            reader.loadScoreBoard();
            VBox verticalbox = new VBox();
            menu = new Menu(this,verticalbox);
            Logger.info("Initializing Menu");
            stage.setScene(menu);
            stage.show();
       }
        catch (Exception e)
       {
           Logger.error("Menu couldn't be initialized");
       }


    }
    public void initializeVictoryScene(String name, int score) {

        try {
            controller = new Controller();
            controller.setOverallView(this);
            VBox verticalbox = new VBox();
            victory = new Victory(this,verticalbox,name,score);//,verticalbox);
            stage.setScene(victory);
            Logger.info("Initializing Victory Screen");
            stage.show();
        }
        catch (Exception e)
        {
            Logger.error("VictoryScreen can't be initialized");
        }
    }


    public Controller getController() {
        return controller;
    }

    public void refreshMap(Labyrinth labyrinth) {
        controller = new Controller();
        controller.setOverallView(this);
        GameView gameView = new GameView();
        gameView.setLabyrinth(labyrinth);
        gameImageModel = new GameImageModel(labyrinth);
        Logger.info("Updating current map");
        stage.setScene(gameView.setGameScene(labyrinth, gameImageModel));
        stage.show();
    }

    public void resumeMap(Labyrinth labyrinth) {
        gameImageModel = new GameImageModel(labyrinth);
        stage.setScene(gameView.setGameScene(labyrinth, gameImageModel));
        stage.show();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public void initializeStartGame() {
        reader = new Reader();
        labyrinth = reader.startLabyrinth();
        GameView gameView = new GameView();
        gameView.setSteps(0);
        gameView.setPlayerName(menu.getPlayerName().getText());
        gameImageModel = new GameImageModel(labyrinth);
        Logger.info("Starting new game, loading the map");
        stage.setScene(gameView.setGameScene(labyrinth, gameImageModel));
        stage.show();
    }
    public void initializeScoreBoard() {
        if(scoreView == null) {
            VBox vBox = new VBox();
            scoreView = new ScoreView(this, vBox);
        }

        scoreView.reloadData();
        Logger.info("Loading scoretable");
        stage.setScene(scoreView);
        stage.show();
    }



}

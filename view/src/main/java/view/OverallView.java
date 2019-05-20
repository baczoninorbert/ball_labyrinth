package view;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.GameMap;
import model.Labyrinth;
import model.Reader;

import java.io.IOException;

public class OverallView extends Application {

    Reader reader = new Reader();
    Menu menu;
    GameMap gameMap;
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

        /*
        window = primaryStage;


        //Button 1
        Label label1 = new Label("New LabyrinthMaker");
        Button button1 = new Button("New LabyrinthMaker");
            button1.setOnAction(e -> {
                try {
                    scene1 = menuHandler.setGameScene();
                    window.setScene(scene1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });




        //Button 2
        Button button2 = new Button("Load LabyrinthMaker");
        button2.setOnAction(e -> window.setScene(scene2));


        //Button 3
        Button button3 = new Button("Highscores");
        button3.setOnAction(e -> window.setScene(scene2));


        //Button 4
        Button button4 = new Button("Exit");
        button4.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children laid out in vertical column

        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(button1,button2,button3,button4);
        scene1 = new Scene(layout1, 200, 200);


        //Button 5
        Button button5 = new Button("Exit");
        button5.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        VBox layout2 = new VBox();

        layout2.getChildren().add(button5);
        scene2 = new Scene(layout2, 600, 300);

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Title Here");
        window.setResizable(false);
        window.show();
        if(window.equals(scene1)) {
            System.out.println("johelyen vagyunk");
        }

         */

    }
    public void initializeMenu() {
        try {
            controller = new Controller();
            controller.setOverallView(this);
            VBox verticalbox = new VBox();
            menu = new Menu(this,verticalbox);
            stage.setScene(menu);
            stage.show();
       }
        catch (Exception e)
       {
            System.out.println("itt is hibaztunk");
       }


    }
    public void initializeVictoryScene(String name, int score) {

        try {
            controller = new Controller();
            controller.setOverallView(this);
            VBox verticalbox = new VBox();
            victory = new Victory(this,verticalbox,name,score);//,verticalbox);
            stage.setScene(victory);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println("itt is hibaztunk");
        }
    }


    public Controller getController() {
        return controller;
    }

    public void refreshMap(Labyrinth labyrinth) {
        controller = new Controller();
        controller.setOverallView(this);
        System.out.println("eljutottunk a refreshmapba");
        GameView gameView = new GameView();
        gameView.setLabyrinth(labyrinth);
        gameMap = new GameMap(labyrinth);
        stage.setScene(gameView.setGameScene(labyrinth, gameMap));
        stage.show();
    }

    public void resumeMap(Labyrinth labyrinth) {
        gameMap = new GameMap(labyrinth);
        stage.setScene(gameView.setGameScene(labyrinth,gameMap));
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
        gameMap = new GameMap(labyrinth);
        stage.setScene(gameView.setGameScene(labyrinth,gameMap));
        stage.show();
    }
    public void initializeScoreBoard() {
        if(scoreView == null) {
            VBox vBox = new VBox();
            scoreView = new ScoreView(this, vBox);
        }

        scoreView.reloadData();
        stage.setScene(scoreView);
        stage.show();
    }



}

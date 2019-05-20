package view;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Reader;

public class Menu extends Scene {

    private Button newGame;
    private Button loadGame;
    private Button highScores;
    private Button exit;
    private OverallView overallView;
    private TextField playerName;
    private HBox hbox;
    private Reader reader = new Reader();

    public Menu (OverallView overallView, VBox vbox) {
        super(vbox);
        this.overallView = overallView;
        hbox = new HBox();
        Label playerLabel = new Label("Player Name:");
        playerName = new TextField();
        playerName.setText("");
        playerName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldName, String newName) {
                if(newName != null && !newName.isEmpty()) {
                    //logger szart ide
                    // meg valami a scorereal

                }
            }
        });
        hbox.getChildren().addAll(playerLabel,playerName);
        vbox.getChildren().addAll(hbox);
        VBox.setMargin(hbox,new Insets(10,20,10,20));

        newGame = new Button("New Game");
        newGame.setDefaultButton(true);
        newGame.setOnMouseClicked((e) -> {
            try {

                if (!playerName.getText().isEmpty()) {
                    this.overallView.getController().setPlayerName(playerName.getText());
                    this.overallView.initializeStartGame();
                    //this.overallView.getController().loadStartMap();
                }
            }
            catch (Exception ex) {
                System.out.println("baj van");
            }
                });

        vbox.getChildren().add(newGame);
        VBox.setMargin(newGame,new Insets(10,20,10,20));
                //scene1 = menuHandler.setGameScene();
                //window.setScene(scene1);

       loadGame = new Button("Load Game");
       loadGame.setDefaultButton(true);
       loadGame.setOnMouseClicked((e) -> {
                   System.out.println("Loadol");
       });
       vbox.getChildren().add(loadGame);
       VBox.setMargin(loadGame,new Insets(10,20,10,20));
     // ide meg lehet resume gamet is csinalni

        


        //Button 3                });
        highScores = new Button("Highscores");
        highScores.setDefaultButton(true);
        highScores.setOnMouseClicked((e) -> {

            overallView.initializeScoreBoard();

        });

        vbox.getChildren().add(highScores);
        VBox.setMargin(highScores,new Insets(10,20,10,20));

        //Button 4
        exit = new Button("Exit");
        exit.setOnMouseClicked((e) ->
        {
            Platform.exit();

        });
        vbox.getChildren().add(exit);
        VBox.setMargin(exit,new Insets(10,20,10,20));
        //Layout 1 - children laid out in vertical column
/*
        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(newGame,loadGame,highScores,exit);
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

    public TextField getPlayerName() {
        return playerName;
    }
}

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
import org.pmw.tinylog.Logger;

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
                Logger.info("Name changed to: " + newName);

            }
        });
        hbox.getChildren().addAll(playerLabel,playerName);
        vbox.getChildren().addAll(hbox);
        VBox.setMargin(hbox,new Insets(10,20,10,20));

        newGame = new Button("New Game");
        newGame.setOnMouseClicked((e) -> {
            try {

                if (!playerName.getText().isEmpty()) {
                    this.overallView.getController().setPlayerName(playerName.getText());
                    this.overallView.initializeStartGame();
                }
            }
            catch (Exception ex) {
                System.out.println("baj van");
            }
                });

        vbox.getChildren().add(newGame);
        VBox.setMargin(newGame,new Insets(10,20,10,20));

       loadGame = new Button("Load Game");
       loadGame.setOnMouseClicked((e) -> {
                   System.out.println("Loadol");
       });
       vbox.getChildren().add(loadGame);
       VBox.setMargin(loadGame,new Insets(10,20,10,20));

        highScores = new Button("Highscores");
        highScores.setOnMouseClicked((e) -> {

            overallView.initializeScoreBoard();

        });

        vbox.getChildren().add(highScores);
        VBox.setMargin(highScores,new Insets(10,20,10,20));
        exit = new Button("Exit");
        exit.setOnMouseClicked((e) ->
        {
            Platform.exit();

        });
        vbox.getChildren().add(exit);
        VBox.setMargin(exit,new Insets(10,20,10,20));
    }

    public TextField getPlayerName() {
        return playerName;
    }
}

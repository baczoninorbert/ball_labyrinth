package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Victory extends Scene {
    Button back = new Button("Back");
    OverallView overallView = new OverallView();
    GameView gameView;
    private String playerName;
    private int score;
    private Label playername;
    private Label scorepoints;

    public Victory(OverallView overall,VBox vBox,String playerName,int score ) {
        super(vBox);
        this.overallView = overall;
        this.playerName = playerName;
        this.score = score;
        playername = new Label(playerName);
        scorepoints = new Label("Points : " + score);
        vBox.getChildren().addAll(playername,scorepoints,back);
        back.setOnMouseClicked(
                e -> {
                   this.overallView.getController();
                   this.overallView.initializeMenu();
                }
        );
    }
}

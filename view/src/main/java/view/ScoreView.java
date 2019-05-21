package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import model.Score;
import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreView extends Scene {

    private TableView<List<StringProperty>> scoreTable = new TableView<List<StringProperty>>();
    //private static Logger logger = LoggerFactory.getLogger(PauseMenu.class);
    private OverallView overallView;


    public ScoreView (OverallView Overallview, VBox verticalBox) {

        super(verticalBox);
        overallView= Overallview;

        Logger.info("ScoreView constructor");
        verticalBox.setFillWidth(true);
        scoreTable.setEditable(false);

        initColumns();
        setKeyPressEvents();
        verticalBox.getChildren().add(scoreTable);
    }

    private void initColumns() {
        TableColumn<List<StringProperty>, String> playerName = new TableColumn<List<StringProperty>, String>("Player name");
        playerName.setCellValueFactory(data -> data.getValue().get(0));

        TableColumn<List<StringProperty>, String> playerSteps = new TableColumn<>("Steps: ");
        playerSteps.setCellValueFactory(data -> data.getValue().get(1));


        scoreTable.getColumns().addAll(playerName,playerSteps);
    }

    public void reloadData() {
        Logger.info("Loading scoreboard data");
        scoreTable.getItems().removeAll();
        ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();
        for (HashMap.Entry<String, Score> entry : overallView.getController().getReader()
                .getHighScores().getPlayerScore().entrySet()) {
            List<StringProperty> row= new ArrayList<>();
            row.add(new SimpleStringProperty(entry.getKey()));
            row.add(new SimpleStringProperty(String.valueOf(entry.getValue().getSteps())));

            data.add(row);
        }
        scoreTable.setItems(data);
    }

    private void setKeyPressEvents() {
        setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ESCAPE:
                    overallView.initializeMenu();
                default:
                    e.consume();

            }
        });
    }
}

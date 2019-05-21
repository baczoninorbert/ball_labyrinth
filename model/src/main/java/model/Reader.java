package model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.pmw.tinylog.Logger;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Class that reads loads and saves output to {@link Labyrinth labyrinth} and {@link HighScores scoreboard}
 */
public class Reader {
    public Reader() {

    }

    /**
     * Class that stores the scores of every player.
     */
    private static HighScores highScores = new HighScores();

    /**
     * Class that returns the map model from input.
     * @return {@link Labyrinth labyrinth} the model of the map
     */
    public Labyrinth startLabyrinth() {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            InputStream is =Reader.class.getClassLoader().getResourceAsStream("labyrinth.json");
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            Labyrinth result = gson.fromJson(inputStreamReader, Labyrinth.class);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function that returns the path to the score.json file
     * @return path
     */
    private String pathToScores() {
        String path = null;
        try {
            Path workingDirectory = FileSystems.getDefault().getPath("").toAbsolutePath();
            path = workingDirectory.toString() + File.separator + "scores" + File.separator;
        } catch (Exception e) {
            Logger.error(e.toString());
        }

        File directory = new File(path);
        if (directory.mkdir()) {
            Logger.info("Directory {} created", path);
        }

        try {
            path = path + "scores.json";
            Path dest = Paths.get(path);
            if (Files.notExists(dest)) {
                Files.createFile(Paths.get(path));
                Logger.info("File {} created", path);
            } else {
                Logger.info("{} already exists", path);
            }
        } catch (IOException e) {
            Logger.error(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    /**
     * Function that loads {@link HighScores highscores}
     */
    public void loadScoreBoard() {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathToScores()));
            highScores= gson.fromJson(br, HighScores.class);
            Logger.info("ScoreBoard loaded");
            Logger.info(String.valueOf(highScores == null));
            if (highScores== null) {
                highScores= new HighScores();
                highScores.setPlayerScore(new HashMap<String,Score>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Function that saves {@link HighScores scores}.
     */
    public void saveScoreBoard() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strJson = gson.toJson(highScores);

        FileWriter writer = null;

        try {
            File jsonFile = new File(pathToScores());
            writer = new FileWriter(jsonFile, false);
            writer.write(strJson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HighScores getHighScores() {
        return highScores;
    }

    public void setHighScores(HighScores highScores) {
        this.highScores = highScores;
    }
}

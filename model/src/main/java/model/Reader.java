package model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Reader {
    public Reader() {
        loadScoreBoard();
    }
    private Gson gson = new Gson();
    private static HighScores highScores = new HighScores();
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
            System.out.println("nem sikerult beolvasni a filet");
        }
        return null;
    }
    private String pathToScores() {
        String path = null;
        try {
            Path workingDirectory = FileSystems.getDefault().getPath("").toAbsolutePath();
            path = workingDirectory.toString() + File.separator + "scores" + File.separator;
        } catch (Exception e) {
            //logger.error(e.toString());
        }

        File directory = new File(path);
        if (directory.mkdir()) {
          //  logger.info("Directory {} created", path);
        }

        try {
            path = path + "scores.json";
            Path dest = Paths.get(path);
            if (Files.notExists(dest)) {
                Files.createFile(Paths.get(path));
            //    logger.info("File {} created", path);
            } else {
              //  logger.info("{} already exists", path);
            }
        } catch (IOException e) {
           // logger.error(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
    public void loadScoreBoard() {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathToScores()));
            highScores= gson.fromJson(br, HighScores.class);
            //logger.info("ScoreBoard loaded");
            //logger.info(String.valueOf(scoreBoard == null));
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

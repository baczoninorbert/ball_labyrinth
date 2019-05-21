package model;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.InputStream;


/**
 * Class that contains the data regarding the visual representation of the map.
 */
public class GameImageModel {
    /**
     * Constructs the object of this class based on the maps model.
     * @param labyrinth model of the map
     */
    public GameImageModel(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    /**
     *  Horizontal size of the pictures.
     */
    public int PicSizeX = 60;
    /**
     * Vertical size of the pictures;
     */
    public int PicSizeY = 60;

    /**
     * The maximum vertical size allocated to the game representation
     */
    public int GameSizeHeight= 800;
    /**
     * The maximum horizontal size allocated to the game representation
     */
    public int GameSizeWidth = 600;
    /**
     * Class that creates  {@link Canvas canvas} according to the given size to hold the map
     */
    private Canvas canvas = new Canvas(GameSizeHeight,GameSizeWidth);
    /**
     * Class that holds the visual representation of the maps elements
     */
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    /**
     * Class that holds the model of the map;
     */
    public Labyrinth labyrinth;


    /**
     * Class that holds the finished representation of the map
     */
    private Pane pane;


    /**
     * Class that holds the location of the maps elements images
     */
    private final InputStream
           A_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("a.png"),
           B_LOC = GameImageModel.class .getClassLoader().getResourceAsStream("b.png"),
           C_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("c.png"),
           D_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("d.png"),
           E_LOC = GameImageModel.class. getClassLoader().getResourceAsStream("e.png"),
           F_LOC = GameImageModel.class. getClassLoader().getResourceAsStream("f.png"),
           G_LOC = GameImageModel.class. getClassLoader().getResourceAsStream("g.png"),
           H_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("h.png"),
           I_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("i.png"),
           J_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("j.png"),
           K_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("k.png"),
           L_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("l.png"),
           M_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("m.png"),
           N_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("n.png"),
           O_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("o.png"),
           P_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("p.png"),
           BIG_A_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("A.png"),
           BIG_B_LOC = GameImageModel.class .getClassLoader().getResourceAsStream("B.png"),
           BIG_C_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("C.png"),
           BIG_D_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("D.png"),
           BIG_E_LOC = GameImageModel.class. getClassLoader().getResourceAsStream("E.png"),
           BIG_F_LOC = GameImageModel.class. getClassLoader().getResourceAsStream("F.png"),
           BIG_G_LOC = GameImageModel.class. getClassLoader().getResourceAsStream("G.png"),
           BIG_H_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("H.png"),
           BIG_I_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("I.png"),
           BIG_J_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("J.png"),
           BIG_K_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("K.png"),
           BIG_L_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("L.png"),
           BIG_M_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("M.png"),
           BIG_N_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("N.png"),
           BIG_O_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("O.png"),
           BIG_P_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("P.png"),
           FINISH_LOC = GameImageModel.class.getClassLoader().getResourceAsStream("finish.png"),
            PLAYER_LOC =  GameImageModel.class.getClassLoader().getResourceAsStream("ballra.gif");
    /**
     * Image of the maps element.
     */
    private final Image A_IMG = new Image(A_LOC);
    /**
     * Image of the maps element.
     */
    private final Image B_IMG= new Image(B_LOC);
    /**
     * Image of the maps element.
     */
    private final Image C_IMG= new Image(C_LOC);
    /**
     * Image of the maps element.
     */
    private final Image D_IMG= new Image(D_LOC);
    /**
     * Image of the maps element.
     */
    private final Image E_IMG=new Image(E_LOC);
    /**
     * Image of the maps element.
     */
    private final Image F_IMG=new Image(F_LOC);
    /**
     * Image of the maps element.
     */
    private final Image G_IMG=new Image(G_LOC);
    /**
     * Image of the maps element.
     */
    private final Image H_IMG=new Image(H_LOC);
    /**
     * Image of the maps element.
     */
    private final Image I_IMG=new Image(I_LOC);
    /**
     * Image of the maps element.
     */
    private final Image J_IMG=new Image(J_LOC);
    /**
     * Image of the maps element.
     */
    private final Image K_IMG=new Image(K_LOC);
    /**
     * Image of the maps element.
     */
    private final Image L_IMG=new Image(L_LOC);
    /**
     * Image of the maps element.
     */
    private final Image M_IMG=new Image(M_LOC);
    /**
     * Image of the maps element.
     */
    private final Image N_IMG=new Image(N_LOC);
    /**
     * Image of the maps element.
     */
    private final Image O_IMG=new Image(O_LOC);
    /**
     * Image of the maps element.
     */
    private final Image P_IMG=new Image(P_LOC);
    /**
     * Image of the maps finish point.
     */
    private final Image FINISH_IMG=new Image(FINISH_LOC);
    /**
     * Image of the maps player.
     */
    private final Image PLAYER_IMG=new Image(PLAYER_LOC);


    /**
     * Class that reads the map and draws the representaion.
     * @param labyrinth model of the map.
     * @throws IllegalGameElement if the map entity isn't known.
     */
    public void drawStructure(Labyrinth labyrinth) throws IllegalGameElement{
        int y = GameSizeWidth/2 - labyrinth.getStructure().size()* PicSizeY/2 ;
        int x;
        int counti = 0;
        for (String lab_row : labyrinth.getStructure()) {
            int countj = 0;
            x = GameSizeHeight/2 - labyrinth.getStructure().size()* PicSizeX/2;
            y += PicSizeY;
            for (char lab_piece :lab_row.toCharArray() ) {
                if (lab_piece == 'a') {
                    graphicsContext.drawImage(A_IMG,x,y,PicSizeX,PicSizeY);
                } else if(lab_piece == 'b') {
                    graphicsContext.drawImage(B_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'c') {
                    graphicsContext.drawImage(C_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'd') {
                    graphicsContext.drawImage(D_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'e') {
                    graphicsContext.drawImage(E_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'f') {
                    graphicsContext.drawImage(F_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'g') {
                    graphicsContext.drawImage(G_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'h') {
                    graphicsContext.drawImage(H_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'i') {
                    graphicsContext.drawImage(I_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'j') {
                    graphicsContext.drawImage(J_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'k') {
                    graphicsContext.drawImage(K_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'l') {
                    graphicsContext.drawImage(L_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'm') {
                    graphicsContext.drawImage(M_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'n') {
                    graphicsContext.drawImage(N_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'o') {
                    graphicsContext.drawImage(O_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'p') {
                    graphicsContext.drawImage(P_IMG,x,y,PicSizeX,PicSizeY);
                }else {
                    throw new IllegalGameElement("Illegal Game Element");
                }
                if(counti == labyrinth.getFinishx() && countj == labyrinth.getFinishy()) {
                    graphicsContext.drawImage(FINISH_IMG,x,y,PicSizeX,PicSizeY);
                }
                if(counti == labyrinth.getPlayerx() && countj == labyrinth.getPlayery()) {
                    graphicsContext.drawImage(PLAYER_IMG,x,y,PicSizeX,PicSizeY);
                }
                x+=PicSizeX;
                countj++;
            }
            counti++;
        }
    }


    /**
     * Creates the {@link Pane pane} that will hold the visual representation of the map
     * @param labyrinth The model of the map.
     * @return {@link Pane pane} that holds the visual representation of the map
     * @throws IllegalGameElement if the map holds an unindentified element.
     */
    public Pane createLabyrinth(Labyrinth labyrinth) throws IllegalGameElement {
        try {

            drawStructure(labyrinth);
            pane = new Pane(canvas);
            return pane;
        }catch (Exception e)
        {
            throw new IllegalGameElement("Labyrint model is bad");
        }

    }

}

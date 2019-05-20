package model;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.InputStream;


public class GameMap {
    public GameMap(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    public int PicSizeX = 60;
    public static final int PicSizeY = 60;

    private int steps = 0;
    public int GameSizeHeight= 1200;
    public int GameSizeWidth = 950;
    private Canvas canvas = new Canvas(GameSizeHeight,GameSizeWidth);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();



    public Labyrinth labyrinth;

    private Pane pane;


    private final InputStream
           A_LOC = GameMap.class.getClassLoader().getResourceAsStream("a.png"),
           B_LOC =GameMap.class .getClassLoader().getResourceAsStream("b.png"),
           C_LOC = GameMap.class.getClassLoader().getResourceAsStream("c.png"),
           D_LOC = GameMap.class.getClassLoader().getResourceAsStream("d.png"),
           E_LOC =GameMap.class. getClassLoader().getResourceAsStream("e.png"),
           F_LOC =GameMap.class. getClassLoader().getResourceAsStream("f.png"),
           G_LOC =GameMap.class. getClassLoader().getResourceAsStream("g.png"),
           H_LOC = GameMap.class.getClassLoader().getResourceAsStream("h.png"),
           I_LOC = GameMap.class.getClassLoader().getResourceAsStream("i.png"),
           J_LOC = GameMap.class.getClassLoader().getResourceAsStream("j.png"),
           K_LOC = GameMap.class.getClassLoader().getResourceAsStream("k.png"),
           L_LOC = GameMap.class.getClassLoader().getResourceAsStream("l.png"),
           M_LOC = GameMap.class.getClassLoader().getResourceAsStream("m.png"),
           N_LOC = GameMap.class.getClassLoader().getResourceAsStream("n.png"),
           O_LOC = GameMap.class.getClassLoader().getResourceAsStream("o.png"),
           P_LOC = GameMap.class.getClassLoader().getResourceAsStream("p.png"),
           BIG_A_LOC = GameMap.class.getClassLoader().getResourceAsStream("A.png"),
           BIG_B_LOC =GameMap.class .getClassLoader().getResourceAsStream("B.png"),
           BIG_C_LOC = GameMap.class.getClassLoader().getResourceAsStream("C.png"),
           BIG_D_LOC = GameMap.class.getClassLoader().getResourceAsStream("D.png"),
           BIG_E_LOC =GameMap.class. getClassLoader().getResourceAsStream("E.png"),
           BIG_F_LOC =GameMap.class. getClassLoader().getResourceAsStream("F.png"),
           BIG_G_LOC =GameMap.class. getClassLoader().getResourceAsStream("G.png"),
           BIG_H_LOC = GameMap.class.getClassLoader().getResourceAsStream("H.png"),
           BIG_I_LOC = GameMap.class.getClassLoader().getResourceAsStream("I.png"),
           BIG_J_LOC = GameMap.class.getClassLoader().getResourceAsStream("J.png"),
           BIG_K_LOC = GameMap.class.getClassLoader().getResourceAsStream("K.png"),
           BIG_L_LOC = GameMap.class.getClassLoader().getResourceAsStream("L.png"),
           BIG_M_LOC = GameMap.class.getClassLoader().getResourceAsStream("M.png"),
           BIG_N_LOC = GameMap.class.getClassLoader().getResourceAsStream("N.png"),
           BIG_O_LOC = GameMap.class.getClassLoader().getResourceAsStream("O.png"),
           BIG_P_LOC = GameMap.class.getClassLoader().getResourceAsStream("P.png"),
           FINISH_LOC = GameMap.class.getClassLoader().getResourceAsStream("finish.png"),
           PLAYER_LOC =  GameMap.class.getClassLoader().getResourceAsStream("ballra.gif");
    private final Image A_IMG = new Image(A_LOC);
    private final Image B_IMG= new Image(B_LOC);
    private final Image C_IMG= new Image(C_LOC);
    private final Image D_IMG= new Image(D_LOC);
    private final Image E_IMG=new Image(E_LOC);
    private final Image F_IMG=new Image(F_LOC);
    private final Image G_IMG=new Image(G_LOC);
    private final Image H_IMG=new Image(H_LOC);
    private final Image I_IMG=new Image(I_LOC);
    private final Image J_IMG=new Image(J_LOC);
    private final Image K_IMG=new Image(K_LOC);
    private final Image L_IMG=new Image(L_LOC);
    private final Image M_IMG=new Image(M_LOC);
    private final Image N_IMG=new Image(N_LOC);
    private final Image O_IMG=new Image(O_LOC);
    private final Image P_IMG=new Image(P_LOC);
    private final Image BIG_A_IMG = new Image(BIG_A_LOC);
    private final Image BIG_B_IMG= new Image(BIG_B_LOC);
    private final Image BIG_C_IMG= new Image(BIG_C_LOC);
    private final Image BIG_D_IMG= new Image(BIG_D_LOC);
    private final Image BIG_E_IMG=new Image(BIG_E_LOC);
    private final Image BIG_F_IMG=new Image(BIG_F_LOC);
    private final Image BIG_G_IMG=new Image(BIG_G_LOC);
    private final Image BIG_H_IMG=new Image(BIG_H_LOC);
    private final Image BIG_I_IMG=new Image(BIG_I_LOC);
    private final Image BIG_J_IMG=new Image(BIG_J_LOC);
    private final Image BIG_K_IMG=new Image(BIG_K_LOC);
    private final Image BIG_L_IMG=new Image(BIG_L_LOC);
    private final Image BIG_M_IMG=new Image(BIG_M_LOC);
    private final Image BIG_N_IMG=new Image(BIG_N_LOC);
    private final Image BIG_O_IMG=new Image(BIG_O_LOC);
    private final Image BIG_P_IMG=new Image(BIG_P_LOC);
    private final Image FINISH_IMG=new Image(FINISH_LOC);
    private final Image PLAYER_IMG=new Image(PLAYER_LOC);


    public void drawStructure(Labyrinth labyrinth) {
        int y = GameSizeWidth/2 - labyrinth.getStructure().size()* PicSizeY/2 ;
        int x;
        int counti = 0;
        for (String lab_row : labyrinth.getStructure()) {
            System.out.println(lab_row);
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
                }else if(lab_piece == 'A') {
                    graphicsContext.drawImage(BIG_A_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'B') {
                    graphicsContext.drawImage(BIG_B_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'C') {
                    graphicsContext.drawImage(BIG_C_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'D') {
                    graphicsContext.drawImage(BIG_D_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'E') {
                    graphicsContext.drawImage(BIG_E_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'F') {
                    graphicsContext.drawImage(BIG_F_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'G') {
                    graphicsContext.drawImage(BIG_G_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'H') {
                    graphicsContext.drawImage(BIG_H_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'I') {
                    graphicsContext.drawImage(BIG_I_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'J') {
                    graphicsContext.drawImage(BIG_J_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'K') {
                    graphicsContext.drawImage(BIG_K_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'L') {
                    graphicsContext.drawImage(BIG_L_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'M') {
                    graphicsContext.drawImage(BIG_M_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'N') {
                    graphicsContext.drawImage(BIG_N_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'O') {
                    graphicsContext.drawImage(BIG_O_IMG,x,y,PicSizeX,PicSizeY);
                }else if(lab_piece == 'P') {
                    graphicsContext.drawImage(BIG_P_IMG,x,y,PicSizeX,PicSizeY);
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


    public Pane createLabyrinth(Labyrinth labyrinth) throws IndexOutOfBoundsException, IOException {
        drawStructure(labyrinth);
        pane = new Pane(canvas);
        return pane;

    }

}

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class AIPieces {
    PApplet p;
    int posX;
    int posY;
    int oriPosX;
    int oriPosY;
    int addX=100;
    int addY=100;
    int ID;
    PImage PIa;
    ArrayList<AIMoves> moves = new ArrayList<AIMoves>();


    AIPieces(PApplet p, int posX, int posY, PImage PIa, int ID){
        this.p = p;
        this.posX=posX;
        this.posY=posY;
        this.PIa=PIa;
        this.ID=ID;
    }

    void drawBoardPiece(){
        p.image(PIa, posX, posY);
    }

}

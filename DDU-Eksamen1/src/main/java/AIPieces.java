import processing.core.PApplet;
import processing.core.PImage;

public class AIPieces {
    PApplet p;
    int posX;
    int posY;
    PImage PIa;

    AIPieces(PApplet p, int posX, int posY, PImage PIa){
        this.p = p;
        this.posX=posX;
        this.posY=posY;
        this.PIa=PIa;
    }

    void drawBoardPiece(){
        p.image(PIa, posX, posY);
    }



}

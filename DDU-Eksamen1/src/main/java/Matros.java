import processing.core.PApplet;
import processing.core.PImage;

public class Matros extends PlayerPieces{

    Matros(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
        this.PIa=PIa;
    }

    void checkIfReleased(){
        if (pieceHeld&&p.mouseX > OriPosX-tileBorder && p.mouseX < OriPosX + lengthX+tileBorder && p.mouseY > OriPosY-100-tileBorder && p.mouseY < OriPosY + lengthY-100+tileBorder) { //én gang fremad
            piecePlacer();
        }
    }
}

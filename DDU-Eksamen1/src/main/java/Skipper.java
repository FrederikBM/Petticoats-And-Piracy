import processing.core.PApplet;
import processing.core.PImage;

public class Skipper extends PlayerPieces {

    Skipper(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
        this.PIa = PIa;
    }

    void checkIfReleased() {
        if (pieceHeld && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder
                && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder // én gang fremad
                || pieceHeld && p.mouseX > OriPosX - 100 - tileBorder && p.mouseX < OriPosX - 100 + lengthX + tileBorder
                && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder // én gang op venstre
                || pieceHeld && p.mouseX > OriPosX + 100 - tileBorder && p.mouseX < OriPosX + 100 + lengthX + tileBorder
                && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder // én gang op højre
                || pieceHeld && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder
                && p.mouseY > OriPosY + 100 - tileBorder && p.mouseY < OriPosY + lengthY + 100 + tileBorder) { // én gang tilbage
            piecePlacer();
        } else if (pieceHeld){
            bounceBack();
            piecePlacer();
        }
    }
}


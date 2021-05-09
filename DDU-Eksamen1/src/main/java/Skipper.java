import processing.core.PApplet;
import processing.core.PImage;

public class Skipper extends PlayerPieces {

    Skipper(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
        this.PIa = PIa;
    }

    void checkIfReleased(boolean held) {
        if (held && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder // én gang fremad
                || pieceHeld && p.mouseX > OriPosX - 100 - tileBorder && p.mouseX < OriPosX - 100 + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder // én gang op venstre
                || pieceHeld && p.mouseX > OriPosX + 100 - tileBorder && p.mouseX < OriPosX + 100 + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder // én gang op højre
                || pieceHeld && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder && p.mouseY > OriPosY + 100 - tileBorder && p.mouseY < OriPosY + lengthY + 100 + tileBorder) { // én gang tilbage
            piecePlacer();
        } else if(held && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder && p.mouseY > OriPosY - tileBorder && p.mouseY < OriPosY + lengthY + tileBorder){
            piecePlacer();
        }
    }
}


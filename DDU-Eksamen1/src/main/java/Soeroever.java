import processing.core.PApplet;
import processing.core.PImage;

public class Soeroever extends PlayerPieces {

    Soeroever(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
        this.PIa = PIa;
    }

    void checkIfReleased() {
        if (pieceHeld && p.mouseX > OriPosX - 100 - tileBorder && p.mouseX < OriPosX - 100 + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder//én gang op venstre
                || pieceHeld && p.mouseX > OriPosX + 100 - tileBorder && p.mouseX < OriPosX + 100 + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder//én gang op højre
                || pieceHeld && p.mouseX > OriPosX - 200 - tileBorder && p.mouseX < OriPosX - 200 + lengthX + tileBorder && p.mouseY > OriPosY - 200 - tileBorder && p.mouseY < OriPosY + lengthY - 200 + tileBorder//to gange op venstre
                || pieceHeld && p.mouseX > OriPosX + 200 - tileBorder && p.mouseX < OriPosX + 200 + lengthX + tileBorder && p.mouseY > OriPosY - 200 - tileBorder && p.mouseY < OriPosY + lengthY - 200 + tileBorder//to gange op højre
                || pieceHeld && p.mouseX > OriPosX - 100 - tileBorder && p.mouseX < OriPosX - 100 + lengthX + tileBorder && p.mouseY > OriPosY + 100 - tileBorder && p.mouseY < OriPosY + lengthY + 100 + tileBorder//én gang ned venstre
                || pieceHeld && p.mouseX > OriPosX + 100 - tileBorder && p.mouseX < OriPosX + 100 + lengthX + tileBorder && p.mouseY > OriPosY + 100 - tileBorder && p.mouseY < OriPosY + lengthY + 100 + tileBorder//én gang ned højre
                || pieceHeld && p.mouseX > OriPosX - 200 - tileBorder && p.mouseX < OriPosX - 200 + lengthX + tileBorder && p.mouseY > OriPosY + 200 - tileBorder && p.mouseY < OriPosY + lengthY + 200 + tileBorder//to gange ned venstre
                || pieceHeld && p.mouseX > OriPosX + 200 - tileBorder && p.mouseX < OriPosX + 200 + lengthX + tileBorder && p.mouseY > OriPosY + 200 - tileBorder && p.mouseY < OriPosY + lengthY + 200 + tileBorder) {//to gange ned højre
            piecePlacer();
        } else if (pieceHeld){
            bounceBack();
            piecePlacer();
        }
    }

}


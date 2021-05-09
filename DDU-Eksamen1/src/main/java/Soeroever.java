import processing.core.PApplet;
import processing.core.PImage;

public class Soeroever extends PlayerPieces {

    Soeroever(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
        this.PIa = PIa;
    }

    void checkIfReleased(boolean held) {
        if (held && p.mouseX > OriPosX - 100 - tileBorder && p.mouseX < OriPosX - 100 + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder//én gang op venstre
                || held && p.mouseX > OriPosX + 100 - tileBorder && p.mouseX < OriPosX + 100 + lengthX + tileBorder && p.mouseY > OriPosY - 100 - tileBorder && p.mouseY < OriPosY + lengthY - 100 + tileBorder//én gang op højre
                || held && p.mouseX > OriPosX - 200 - tileBorder && p.mouseX < OriPosX - 200 + lengthX + tileBorder && p.mouseY > OriPosY - 200 - tileBorder && p.mouseY < OriPosY + lengthY - 200 + tileBorder//to gange op venstre
                || held && p.mouseX > OriPosX + 200 - tileBorder && p.mouseX < OriPosX + 200 + lengthX + tileBorder && p.mouseY > OriPosY - 200 - tileBorder && p.mouseY < OriPosY + lengthY - 200 + tileBorder//to gange op højre
                || held && p.mouseX > OriPosX - 100 - tileBorder && p.mouseX < OriPosX - 100 + lengthX + tileBorder && p.mouseY > OriPosY + 100 - tileBorder && p.mouseY < OriPosY + lengthY + 100 + tileBorder//én gang ned venstre
                || held && p.mouseX > OriPosX + 100 - tileBorder && p.mouseX < OriPosX + 100 + lengthX + tileBorder && p.mouseY > OriPosY + 100 - tileBorder && p.mouseY < OriPosY + lengthY + 100 + tileBorder//én gang ned højre
                || held && p.mouseX > OriPosX - 200 - tileBorder && p.mouseX < OriPosX - 200 + lengthX + tileBorder && p.mouseY > OriPosY + 200 - tileBorder && p.mouseY < OriPosY + lengthY + 200 + tileBorder//to gange ned venstre
                || held && p.mouseX > OriPosX + 200 - tileBorder && p.mouseX < OriPosX + 200 + lengthX + tileBorder && p.mouseY > OriPosY + 200 - tileBorder && p.mouseY < OriPosY + lengthY + 200 + tileBorder) {//to gange ned højre
            piecePlacer();
        } else if (held && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder && p.mouseY > OriPosY - tileBorder && p.mouseY < OriPosY + lengthY + tileBorder){
            piecePlacer();
        }
    }

}


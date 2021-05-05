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
        if (pieceHeld&&) {


            for (int i = 40; i < p.width / 2 + 235; i += 100) {
                for (int t = 50; t < 650; t += 100) {
                    if (posX + lengthX / 2 > i && posX + lengthX / 2 < i + 100) {
                        posX = i;
                    }
                    if (posY + lengthY / 2 > t && posY + lengthY / 2 < t + 100) {
                        posY = t;
                    }
                }
            }
            pieceHeld = false;
        }
    }
}

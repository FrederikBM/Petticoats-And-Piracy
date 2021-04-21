import processing.core.PApplet;
import processing.core.PImage;

public class Soeroever extends PlayerPieces{

    Soeroever(int posX, int posY, PApplet p){
        super(p, posX, posY);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }
}

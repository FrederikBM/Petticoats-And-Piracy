import processing.core.PApplet;
import processing.core.PImage;

public class Matros extends PlayerPieces{

    Matros( PApplet p, int posX, int posY){
        super(p, posX, posY);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }
}

import processing.core.PApplet;
import processing.core.PImage;

public class SoeroeverAI extends AIPieces{
    SoeroeverAI(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }
}

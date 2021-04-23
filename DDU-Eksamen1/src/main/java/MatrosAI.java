import processing.core.PApplet;
import processing.core.PImage;

public class MatrosAI extends AIPieces{
    MatrosAI(int posX, int posY, PApplet p) {
        super(p, posX, posY);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }
}

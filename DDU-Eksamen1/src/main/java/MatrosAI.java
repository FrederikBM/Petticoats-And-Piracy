import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class MatrosAI extends AIPieces {

    MatrosAI(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }

    void instantiateArray() {
        moves.clear();
        moves.add(new AIMoves(posX, posY + (addY), p));
    }

}

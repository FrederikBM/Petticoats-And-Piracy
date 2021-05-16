import processing.core.PApplet;
import processing.core.PImage;

public class CaptainCrunchAI extends AIPieces {

    CaptainCrunchAI(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }


    void instantiateArray() {
        moves.clear();

        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                moves.add(new AIMoves(posX - (addX), posY + (addY - (addY * i)), p));
                moves.add(new AIMoves(posX + (addX), posY + (addY - (addY * i)), p));
            }
        }
    }
}

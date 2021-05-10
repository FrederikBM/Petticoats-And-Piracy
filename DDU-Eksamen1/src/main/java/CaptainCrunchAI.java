import processing.core.PApplet;
import processing.core.PImage;

public class CaptainCrunchAI extends AIPieces {

    CaptainCrunchAI(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }


    void instantiateArray() {

        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                moves.add(new AIMoves(posX - (addX), posY + (addY - (addX * i)), p));
                moves.add(new AIMoves(posX + (addX), posY + (addY - (addX * i)), p));
            }
        }
    }

    void moveSet(){
        oriPosX=posX;
        oriPosY=posY;
        for(int i = 0; i<moves.size();i++){

        }
    }
}

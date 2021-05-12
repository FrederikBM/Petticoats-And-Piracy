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
        int r=(int)p.random(moves.size());
        posX=moves.get(r).xpos;
        posY=moves.get(r).ypos;
    }
}

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class MatrosAI extends AIPieces{

    MatrosAI(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }

    void instantiateArray(){
        moves.add(new AIMoves(posX,posY+(addY),p));
        }

    void setOriPos(){
        oriPosX=posX;
        oriPosY=posY;
    }

    void moveSet(){
        int r=(int)p.random(moves.size());
        posX=moves.get(r).xpos;
        posY=moves.get(r).ypos;
    }
}

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class MatrosAI extends AIPieces{

    MatrosAI(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }

    void instantiateArray(){
        moves.add(new AIMoves(posX,posY-(addY),p));

        }


    void moveSet(){
        oriPosX=posX;
        oriPosY=posY;
        for(int i = 0; i<moves.size();i++){

        }
    }
}

import processing.core.PApplet;
import processing.core.PImage;

public class SkipperAI extends AIPieces{
    SkipperAI(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }

    void instantiateArray(){

        for(int i = 0; i<4; i++){
            if(i<1){
                moves.add(new AIMoves(posX-(addX),posY-(addY),p));
            } else if(i<2){
                moves.add(new AIMoves(posX+(addX),posY-(addY),p));
            } else if(i<3){
                moves.add(new AIMoves(posX,posY-(addY),p));
            } else if(i<4){
                moves.add(new AIMoves(posX,posY+(addY),p));
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

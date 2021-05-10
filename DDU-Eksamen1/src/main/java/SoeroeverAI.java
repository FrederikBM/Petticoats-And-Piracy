import processing.core.PApplet;
import processing.core.PImage;

public class SoeroeverAI extends AIPieces{
    SoeroeverAI(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }

    void instantiateArray(){

        for(int i = 0; i<4; i++){
            if(i<1){
                moves.add(new AIMoves(posX-(addX),posY-(addY),p));
                moves.add(new AIMoves(posX-(addX+100),posY-(addY+100),p));
            } else if(i<2){
                moves.add(new AIMoves(posX+(addX),posY-(addY),p));
                moves.add(new AIMoves(posX+(addX+100),posY-(addY+100),p));
            } else if(i<3){
                moves.add(new AIMoves(posX-(addX),posY+(addY),p));
                moves.add(new AIMoves(posX-(addX+100),posY+(addY+100),p));
            } else if(i<4){
                moves.add(new AIMoves(posX-(addX),posY+(addY),p));
                moves.add(new AIMoves(posX-(addX+100),posY+(addY+100),p));
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

import processing.core.PApplet;
import processing.core.PImage;

public class SoeroeverAI extends AIPieces{
    SoeroeverAI(int posX, int posY, PImage PIa, int ID, PApplet p) {
        super(p, posX, posY, PIa, ID);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
    }

    void instantiateArray(){
        moves.clear();

        for(int i = 0; i<4; i++){
            if(i<1){
                moves.add(new AIMoves(posX-(addX),posY-(addY),p));
                moves.add(new AIMoves(posX-(addX*2),posY-(addY*2),p));
            } else if(i<2){
                moves.add(new AIMoves(posX+(addX),posY-(addY),p));
                moves.add(new AIMoves(posX+(addX*2),posY-(addY*2),p));
            } else if(i<3){
                moves.add(new AIMoves(posX-(addX),posY+(addY),p));
                moves.add(new AIMoves(posX-(addX*2),posY+(addY*2),p));
            } else if(i<4){
                moves.add(new AIMoves(posX+(addX),posY+(addY),p));
                moves.add(new AIMoves(posX+(addX*2),posY+(addY*2),p));
            }



        }
    }
}

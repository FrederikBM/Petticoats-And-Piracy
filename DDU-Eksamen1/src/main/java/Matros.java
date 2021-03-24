import processing.core.PApplet;
import processing.core.PImage;

public class Matros extends PApplet{
PApplet p;

int posX;
int posY;

boolean pieceHeld=false;

    Matros(int posX, int posY, PApplet p){
        this.posX = posX;
        this.posY = posY;
        this.p=p;
    }

    void drawBoardPiece(PImage matros){
        p.image(matros, posX, posY);
    }

    void checkIfClicked(){
        if(p.mousePressed&&p.mouseX> posX &&p.mouseX< posX +80&&p.mouseY> posY &&p.mouseY< posY +80){
            pieceHeld=true;
            System.out.println("clicked");
        } else if(!mousePressed){
            pieceHeld=false;
            System.out.println("not clicked");
        }
        //p.rect(posX,posX+80,posY,posY+80);

        if(pieceHeld=true){
            posX =mouseX-40;
            posY =mouseY-40;
        }
    }
}

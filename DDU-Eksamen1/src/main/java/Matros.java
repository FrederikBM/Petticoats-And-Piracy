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
            posX =p.mouseX-40;
            posY =p.mouseY-40;
            System.out.println("clicked");
        } else if(!mousePressed){
            pieceHeld=false;
            System.out.println("not clicked");
        }
        //p.rect(posX,posY,80,80);




    }
}

import processing.core.PApplet;
import processing.core.PImage;

public class Soeroever {
    PApplet p;
    int posX;
    int posY;
    boolean pieceHeld=false;

    Soeroever(int posX, int posY, PApplet p){
        this.posX = posX;
        this.posY = posY;
        this.p=p;
    }

    void drawBoardPiece(PImage boardPiece){
        p.image(boardPiece, posX, posY);
    }

    void checkIfClicked(){
        if(p.mousePressed&&p.mouseX> posX &&p.mouseX< posX +80&&p.mouseY> posY &&p.mouseY< posY +80){
            pieceHeld=true;
            posX =p.mouseX-40;
            posY =p.mouseY-40;
            System.out.println("clicked");
        } else if(!p.mousePressed){
            for(int i = 40;i<p.width/2+235;i+=100){
                for(int t = 50;t<650;t+=100){
                    if(posX+40>i&&posX+40<i+100){
                        posX=i;
                    }
                    if(posY+40>t&&posY+40<t+100){
                        posY=t;
                    }
                }
            }
            pieceHeld=false;
            System.out.println(posX);
            System.out.println("not clicked");
        }
        //p.rect(posX,posY,80,80);




    }
}

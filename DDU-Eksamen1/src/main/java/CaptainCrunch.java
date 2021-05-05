import processing.core.PApplet;
import processing.core.PImage;

public class CaptainCrunch extends PlayerPieces {

    CaptainCrunch(int posX, int posY, PImage PIa, PApplet p) {
        super(p, posX, posY, PIa);
        this.posX = posX;
        this.posY = posY;
        this.p = p;
        this.PIa=PIa;
    }

    void checkIfReleased(){
        if (pieceHeld&&p.mouseX > OriPosX-100-tileBorder && p.mouseX < OriPosX-100+lengthX+tileBorder && p.mouseY > OriPosY-100-tileBorder && p.mouseY < OriPosY + lengthY-100+tileBorder // én gang op venstre
                ||pieceHeld&&p.mouseX > OriPosX-100-tileBorder && p.mouseX < OriPosX-100+lengthX+tileBorder && p.mouseY > OriPosY-tileBorder && p.mouseY < OriPosY + lengthY+tileBorder // én gang til venstre
                ||pieceHeld&&p.mouseX > OriPosX-100-tileBorder && p.mouseX < OriPosX-100+lengthX+tileBorder && p.mouseY > OriPosY+100-tileBorder && p.mouseY < OriPosY + lengthY+100+tileBorder // én gang ned venstre
                ||pieceHeld&&p.mouseX > OriPosX+100-tileBorder && p.mouseX < OriPosX+100+lengthX+tileBorder && p.mouseY > OriPosY-100-tileBorder && p.mouseY < OriPosY + lengthY-100+tileBorder // én gang op højre
                ||pieceHeld&&p.mouseX > OriPosX+100-tileBorder && p.mouseX < OriPosX+100+lengthX+tileBorder && p.mouseY > OriPosY-tileBorder && p.mouseY < OriPosY + lengthY+tileBorder // én gang til højre
                ||pieceHeld&&p.mouseX > OriPosX+100-tileBorder && p.mouseX < OriPosX+100+lengthX+tileBorder && p.mouseY > OriPosY+100-tileBorder && p.mouseY < OriPosY + lengthY+100+tileBorder){ //en gang ned højre
            piecePlacer();
        }
    }
}
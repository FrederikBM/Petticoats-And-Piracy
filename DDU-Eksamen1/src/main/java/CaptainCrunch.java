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

    void checkIfReleased(boolean held){
        if (held&&p.mouseX > OriPosX-100-tileBorder && p.mouseX < OriPosX-100+lengthX+tileBorder && p.mouseY > OriPosY-100-tileBorder && p.mouseY < OriPosY + lengthY-100+tileBorder // én gang op venstre
                ||held&&p.mouseX > OriPosX-100-tileBorder && p.mouseX < OriPosX-100+lengthX+tileBorder && p.mouseY > OriPosY-tileBorder && p.mouseY < OriPosY + lengthY+tileBorder // én gang til venstre
                ||held&&p.mouseX > OriPosX-100-tileBorder && p.mouseX < OriPosX-100+lengthX+tileBorder && p.mouseY > OriPosY+100-tileBorder && p.mouseY < OriPosY + lengthY+100+tileBorder // én gang ned venstre
                ||held&&p.mouseX > OriPosX+100-tileBorder && p.mouseX < OriPosX+100+lengthX+tileBorder && p.mouseY > OriPosY-100-tileBorder && p.mouseY < OriPosY + lengthY-100+tileBorder // én gang op højre
                ||held&&p.mouseX > OriPosX+100-tileBorder && p.mouseX < OriPosX+100+lengthX+tileBorder && p.mouseY > OriPosY-tileBorder && p.mouseY < OriPosY + lengthY+tileBorder // én gang til højre
                ||held&&p.mouseX > OriPosX+100-tileBorder && p.mouseX < OriPosX+100+lengthX+tileBorder && p.mouseY > OriPosY+100-tileBorder && p.mouseY < OriPosY + lengthY+100+tileBorder){ //en gang ned højre
            piecePlacer();
        } else if (held && p.mouseX > OriPosX - tileBorder && p.mouseX < OriPosX + lengthX + tileBorder && p.mouseY > OriPosY - tileBorder && p.mouseY < OriPosY + lengthY + tileBorder){
            piecePlacer();
        }
    }
}
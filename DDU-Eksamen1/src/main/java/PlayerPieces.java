import processing.core.PApplet;
import processing.core.PImage;

public class PlayerPieces {
    PApplet p;
    int posX;
    int posY;
    PImage PIa;
    int lengthX = 80;
    int lengthY = 80;
    boolean pieceHeld = false;
    int OriPosX;
    int OriPosY;

    PlayerPieces(PApplet p, int posX, int posY, PImage PIa) {
        this.p = p;
        this.posX = posX;
        this.posY = posY;
        this.PIa = PIa;
    }

    void drawBoardPiece() {
        p.image(PIa, posX, posY);
    }

    void checkIfClicked() {
        if (!pieceHeld&&p.mouseX > posX && p.mouseX < posX + lengthX && p.mouseY > posY && p.mouseY < posY + lengthY) {
            pieceHeld = true;
            OriPosX=posX;
            OriPosY=posY;
        } /*else if (pieceHeld) {
            for (int i = 40; i < p.width / 2 + 235; i += 100) {
                for (int t = 50; t < 650; t += 100) {
                    if (posX + lengthX / 2 > i && posX + lengthX / 2 < i + 100) {
                        posX = i;
                    }
                    if (posY + lengthY / 2 > t && posY + lengthY / 2 < t + 100) {
                        posY = t;
                    }
                }
            }
            pieceHeld = false;
        }*/
    }

    void pieceMover() {
        if (pieceHeld) {
            posX = p.mouseX - lengthX / 2;
            posY = p.mouseY - lengthY / 2;
        }
    }
}

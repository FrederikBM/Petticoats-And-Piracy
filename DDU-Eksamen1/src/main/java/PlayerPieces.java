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
    int tileBorder=20;
    int ID;

    PlayerPieces(PApplet p, int posX, int posY, PImage PIa, int ID) {
        this.p = p;
        this.posX = posX;
        this.posY = posY;
        this.PIa = PIa;
        this.ID=ID;
    }

    void drawBoardPiece() {
        p.image(PIa, posX, posY);
    }

    void checkIfClicked() {
        if (!pieceHeld&&p.mouseX > posX && p.mouseX < posX + lengthX && p.mouseY > posY && p.mouseY < posY + lengthY) {
            pieceHeld = true;
            OriPosX=posX;
            OriPosY=posY;
        }
    }

    void pieceMover() {
        if (pieceHeld) {
            posX = p.mouseX - lengthX / 2;
            posY = p.mouseY - lengthY / 2;
        }
    }

    void piecePlacer(){
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
    }

    void bounceBack(){
        posX=OriPosX;
        posY=OriPosY;
    }
}

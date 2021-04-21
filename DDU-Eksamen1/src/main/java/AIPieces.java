import processing.core.PApplet;
import processing.core.PImage;

public class AIPieces {
    PApplet p;
    int posX;
    int posY;
    boolean pieceHeld = false;

    AIPieces(PApplet p, int posX, int posY){
        this.p = p;
    }

    void drawBoardPiece(PImage boardPiece){
        p.image(boardPiece, posX, posY);
    }
}

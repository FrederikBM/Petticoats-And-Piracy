public class Toggle {
    boolean pieceSelected = false;

    void tooglePick(){
        if(pieceSelected==false)
            pieceSelected = true;
        else
            pieceSelected=false;
    }
}

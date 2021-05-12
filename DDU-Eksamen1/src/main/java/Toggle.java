public class Toggle {
    boolean pieceSelected = false;

    void toggleClicked() {

        if (pieceSelected == false)
            pieceSelected = true;
        else
            pieceSelected = false;

    }
}

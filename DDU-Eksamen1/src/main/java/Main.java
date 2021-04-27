import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet{
    PImage board;
    PImage redCaptain;
    PImage redSkipper;
    PImage redSoeroever;
    PImage redMatros;
    PImage blueCaptain;
    PImage blueSkipper;
    PImage blueSoeroever;
    PImage blueMatros;
    int selectedPieceID=-1;
    ArrayList<Matros> matrosserne = new ArrayList<Matros>();
    ArrayList<Soeroever> soeroeverne = new ArrayList<Soeroever>();
    ArrayList<Skipper> skipperne = new ArrayList<Skipper>();
    CaptainCrunch captain;

    ArrayList<PlayerPieces> allPieces = new ArrayList<PlayerPieces>();

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(570, 670);
    }

    @Override
    public void setup(){

        board=loadImage("ddu-brt2.jpg");
        redCaptain=loadImage("ddu-kaptajn-rd.jpg");
        redSkipper=loadImage("ddu-skipper-rd.jpg");
        redSoeroever=loadImage("ddu-srver-rd.jpg");
        redMatros=loadImage("ddu-matros-rd.jpg");

        blueCaptain=loadImage("ddu-kaptajn-bla.jpg");
        blueSkipper=loadImage("ddu-skipper-bla.jpg");
        blueSoeroever=loadImage("ddu-srver-bla.jpg");
        blueMatros=loadImage("ddu-matros-bla.jpg");

        instances();
    }

    @Override
    public void draw(){
        drawStart();
        bricks();
        /*matrosserne();
        soeroeverne();
        skipperne();
        captain();*/
    }

    @Override
    public void mousePressed(){

    }

    @Override
    public void mouseReleased(){

    }

    @Override
    public void mouseDragged(){

    }

    void instances(){
        //matrosserne
        for(int i = 0; i<4;i++){
            int a = width/2+(-245+(i*100));
            if(a<width/2+(-245+(2*100))){
                a = width/2+(-245+(i*100));
            } else {
                a+=100;
            }
            int t = 550;
            if(a==width/2-245||a==width/2+155){
                t=550;
            } else {
                t=450;
            }
            matrosserne.add(new Matros(a,t,blueMatros,this));
        }

        //sørøverne
        for(int i = 0; i<3;i++){
            soeroeverne.add(new Soeroever(width/2-245+(i*200),450,blueSoeroever ,this));
        }

        //skipperne
        for(int i = 0; i<2;i++){
            skipperne.add(new Skipper(width/2-145+(i*200),550,blueSkipper,this));
        }

        captain = new CaptainCrunch(width/2-45,550, blueCaptain,this);

        allPieces.addAll(matrosserne);
        allPieces.addAll(soeroeverne);
        allPieces.addAll(skipperne);
        allPieces.add(captain);

        System.out.println(allPieces);
    }

    void drawStart(){
        clear();
        image(board,0,0);
    }

    void bricks(){

        for(int i=0;i<allPieces.size();i++){
            PlayerPieces ap = allPieces.get(i);
            ap.pieceID=i;
            ap.drawBoardPiece();
            if(selectedPieceID>-1&&selectedPieceID==ap.pieceID){

                ap.checkIfClicked();
            }
            else {
                ap.checkIfClicked();
                selectedPieceID=ap.pieceID;
            }
        }

       /*for(int i = 0; i< matrosserne.size(); i++){
            Matros m = matrosserne.get(i);
            Soeroever so;
            Skipper sk;

            m.drawBoardPiece();
            m.checkIfClicked();

            if(i<3) {
                so = soeroeverne.get(i);
                so.drawBoardPiece();
                so.checkIfClicked();
            }
            if(i<2) {
                sk = skipperne.get(i);
                sk.drawBoardPiece();
                sk.checkIfClicked();
            }
            //captain.
            captain.drawBoardPiece();
            captain.checkIfClicked();

        }*/
    }

    /*void matrosserne(){
        for(int i = 0; i<Matrosserne.size();i++){
            Matros m = Matrosserne.get(i);
            m.drawBoardPiece(blueMatros);
            m.checkIfClicked();
        }
    }

    void soeroeverne(){
        for(int i=0;i<Soeroeverne.size();i++){
            Soeroever so = Soeroeverne.get(i);
            so.drawBoardPiece(blueSoeroever);
            so.checkIfClicked();
        }
    }

    void skipperne(){
        for(int i=0;i<Skipperne.size();i++){
            Skipper sk = Skipperne.get(i);
            sk.drawBoardPiece(blueSkipper);
            sk.checkIfClicked();
        }
    }

    void captain(){
            captain.drawBoardPiece(blueCaptain);
            captain.checkIfClicked();
        }*/


}

import processing.core.PApplet;
import processing.core.PImage;

import java.sql.DriverManager;
import java.sql.SQLException;
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

    ArrayList<Matros> Matrosserne = new ArrayList<Matros>();
    ArrayList<Soeroever> Soeroeverne = new ArrayList<Soeroever>();
    ArrayList<Skipper> Skipperne = new ArrayList<Skipper>();

    boolean boardPieceClicked = false;
    CaptainCrunch captain;


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(570, 670);
    }

    @Override
    public void setup(){
        captain = new CaptainCrunch(width/2-45,550,this);
        instances();

        board=loadImage("ddu-brt2.jpg");
        redCaptain=loadImage("ddu-kaptajn-rd.jpg");
        redSkipper=loadImage("ddu-skipper-rd.jpg");
        redSoeroever=loadImage("ddu-srver-rd.jpg");
        redMatros=loadImage("ddu-matros-rd.jpg");

        blueCaptain=loadImage("ddu-kaptajn-bla.jpg");
        blueSkipper=loadImage("ddu-skipper-bla.jpg");
        blueSoeroever=loadImage("ddu-srver-bla.jpg");
        blueMatros=loadImage("ddu-matros-bla.jpg");


        image(redCaptain,width/2-45,50);
        image(redSkipper,width/2-145,50);
        image(redSkipper,width/2+55,50);
        image(redSoeroever,width/2-45,150);
        image(redSoeroever,width/2-245,150);
        image(redSoeroever,width/2+155,150);
        image(redMatros,width/2-245,50);
        image(redMatros,width/2+155,50);
        image(redMatros,width/2-145,150);
        image(redMatros,width/2+55,150);

        image(blueCaptain,width/2-45,550);
        image(blueSkipper,width/2-145,550);
        image(blueSkipper,width/2+55,550);
        /*image(blueMatros,width/2-245,550);
        image(blueMatros,width/2+155,550);
        image(blueMatros,width/2-145,450);
        image(blueMatros,width/2+55,450);*/

        //System.out.println(width/2-245);

    }

    @Override
    public void draw(){
        drawStart();
        matrosserne();
        soeroeverne();
        skipperne();
        captain();
    }

    @Override
    public void mousePressed(){

    }

    @Override
    public void mouseReleased(){

    }

    @Override
    public void mouseDragged(){
        for(int i = 0; i<Matrosserne.size(); i++){
            Matros m = Matrosserne.get(i);
            if(i<3) {
                Soeroever so = Soeroeverne.get(i);
            }
            if(i<2) {
                Skipper sk = Skipperne.get(i);
            }
            //captain.

            if(m.pieceHeld==true){

            }
        }
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
            Matrosserne.add(new Matros(this,a,t));
        }

        //sørøverne
        for(int i = 0; i<3;i++){
            Soeroeverne.add(new Soeroever(width/2-245+(i*200),450,this));
        }

        //skipperne
        for(int i = 0; i<2;i++){
            Skipperne.add(new Skipper(width/2-145+(i*200),550,this));
        }

    }

    void drawStart(){
        clear();
        image(board,0,0);
    }

    void matrosserne(){
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
        }
}

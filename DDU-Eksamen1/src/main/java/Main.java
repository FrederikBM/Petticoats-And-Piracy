import processing.core.PApplet;
import processing.core.PImage;

import java.sql.DriverManager;
import java.sql.SQLException;

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

    Matros matros1;
    Matros matros2;
    Matros matros3;
    Matros matros4;


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(570, 670);
    }

    @Override
    public void setup(){
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
        image(blueSoeroever,width/2-45,450);
        image(blueSoeroever,width/2-245,450);
        image(blueSoeroever,width/2+155,450);
        /*image(blueMatros,width/2-245,550);
        image(blueMatros,width/2+155,550);
        image(blueMatros,width/2-145,450);
        image(blueMatros,width/2+55,450);*/

        //System.out.println(width/2-245);

    }

    @Override
    public void draw(){
        clear();
        image(board,0,0);
        matrosserne();

    }

    void instances(){
        matros1 = new Matros(width/2-245,550,this);
        matros2 = new Matros(width/2-145,450,this);
        matros3 = new Matros(width/2+55,450,this);
        matros4 = new Matros(width/2+155,550,this);
    }

    void matrosserne(){
        matros1.drawBoardPiece(blueMatros);
        matros1.checkIfClicked();

        matros2.drawBoardPiece(blueMatros);
        matros2.checkIfClicked();

        matros3.drawBoardPiece(blueMatros);
        matros3.checkIfClicked();

        matros4.drawBoardPiece(blueMatros);
        matros4.checkIfClicked();

    }
}

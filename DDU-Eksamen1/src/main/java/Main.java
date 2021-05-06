import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {
    PImage board;
    PImage redCaptain;
    PImage redSkipper;
    PImage redSoeroever;
    PImage redMatros;
    PImage blueCaptain;
    PImage blueSkipper;
    PImage blueSoeroever;
    PImage blueMatros;

    Toogle tgl = new Toogle();

    ArrayList<Matros> matrosserne = new ArrayList<Matros>();
    ArrayList<Soeroever> soeroeverne = new ArrayList<Soeroever>();
    ArrayList<Skipper> skipperne = new ArrayList<Skipper>();
    ArrayList<CaptainCrunch> captain = new ArrayList<CaptainCrunch>();

    ArrayList<MatrosAI> AImatrosserne = new ArrayList<MatrosAI>();
    ArrayList<SoeroeverAI> AIsoeroeverne = new ArrayList<SoeroeverAI>();
    ArrayList<SkipperAI> AIskipperne = new ArrayList<SkipperAI>();
    ArrayList<CaptainCrunchAI> AIcaptain = new ArrayList<CaptainCrunchAI>();

    ArrayList<PlayerPieces> allPlayerPieces = new ArrayList<PlayerPieces>();
    ArrayList<AIPieces> allAIPieces = new ArrayList<AIPieces>();



    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(570, 670);
    }

    @Override
    public void setup() {

        board = loadImage("ddu-brt2.jpg");
        redCaptain = loadImage("ddu-kaptajn-rd.jpg");
        redSkipper = loadImage("ddu-skipper-rd.jpg");
        redSoeroever = loadImage("ddu-srver-rd.jpg");
        redMatros = loadImage("ddu-matros-rd.jpg");

        blueCaptain = loadImage("ddu-kaptajn-bla.jpg");
        blueSkipper = loadImage("ddu-skipper-bla.jpg");
        blueSoeroever = loadImage("ddu-srver-bla.jpg");
        blueMatros = loadImage("ddu-matros-bla.jpg");

        playerInstances();
        AIInstances();
    }

    @Override
    public void draw() {
        drawStart();
        drawPieces();
        /*matrosserne();
        soeroeverne();
        skipperne();
        captain();*/
    }

    @Override
    public void mousePressed() {
    }

    @Override
    public void mouseReleased() {
        clickPieces();
        tgl.tooglePick();
    }

    @Override
    public void mouseDragged() {

    }

    void playerInstances() {
        //matrosserne
        for (int i = 0; i < 4; i++) {
            int a = width / 2 + (-245 + (i * 100));
            if (a < width / 2 + (-245 + (2 * 100))) {
                a = width / 2 + (-245 + (i * 100));
            } else {
                a += 100;
            }
            int t = 550;
            if (a == width / 2 - 245 || a == width / 2 + 155) {
                t = 550;
            } else {
                t = 450;
            }
            matrosserne.add(new Matros(a, t, blueMatros, this));
        }

        //sørøverne
        for (int i = 0; i < 3; i++) {
            soeroeverne.add(new Soeroever(width / 2 - 245 + (i * 200), 450, blueSoeroever, this));
        }

        //skipperne
        for (int i = 0; i < 2; i++) {
            skipperne.add(new Skipper(width / 2 - 145 + (i * 200), 550, blueSkipper, this));
        }

        //captain
        captain.add(new CaptainCrunch(width / 2 - 45, 550, blueCaptain, this));

        allPlayerPieces.addAll(matrosserne);
        allPlayerPieces.addAll(soeroeverne);
        allPlayerPieces.addAll(skipperne);
        allPlayerPieces.addAll(captain);

        System.out.println(allPlayerPieces);
    }

    void AIInstances (){
        for (int i = 0; i < 4; i++) {
            int a = width / 2 + (-245 + (i * 100));
            if (a < width / 2 + (-245 + (2 * 100))) {
                a = width / 2 + (-245 + (i * 100));
            } else {
                a += 100;
            }
            int t = 50;
            if (a == width / 2 - 245 || a == width / 2 + 155) {
                t = 50;
            } else {
                t = 150;
            }
            AImatrosserne.add(new MatrosAI(a, t, redMatros, this));
        }

        //sørøverne
        for (int i = 0; i < 3; i++) {
            AIsoeroeverne.add(new SoeroeverAI(width / 2 - 245 + (i * 200), 150, redSoeroever, this));
        }

        //skipperne
        for (int i = 0; i < 2; i++) {
            AIskipperne.add(new SkipperAI(width / 2 - 145 + (i * 200), 50, redSkipper, this));
        }

        //captain
        AIcaptain.add(new CaptainCrunchAI(width / 2 - 45, 50, redCaptain, this));

        allAIPieces.addAll(AImatrosserne);
        allAIPieces.addAll(AIsoeroeverne);
        allAIPieces.addAll(AIskipperne);
        allAIPieces.addAll(AIcaptain);

        System.out.println(allAIPieces);
    }

    void drawStart() {
        clear();
        image(board, 0, 0);
    }

    void drawPieces() {

        for (int i = 0; i < allPlayerPieces.size(); i++) {
            PlayerPieces pp = allPlayerPieces.get(i);
            pp.drawBoardPiece();
            pp.pieceMover();
        }

        for(int i = 0; i<allAIPieces.size();i++){
            AIPieces aip = allAIPieces.get(i);
            aip.drawBoardPiece();
        }
    }

    void clickPieces() {
        for(int i = 0; i< matrosserne.size(); i++){
            Matros m = matrosserne.get(i);
            Soeroever so;
            Skipper sk;
            CaptainCrunch cc;

            //matrosserne
            m.checkIfClicked(tgl.toogled);
            m.checkIfReleased(tgl.toogled);

            //sørøverne
            if(i<3) {
                so = soeroeverne.get(i);
                so.checkIfReleased(tgl.toogled);
                so.checkIfClicked(tgl.toogled);
            }

            //skipperne
            if(i<2) {
                sk = skipperne.get(i);
                sk.checkIfReleased(tgl.toogled);
                sk.checkIfClicked(tgl.toogled);
            }

            //captain
            if(i<1) {
                cc = captain.get(i);
                cc.checkIfReleased(tgl.toogled);
                cc.checkIfClicked(tgl.toogled);
            }

        }
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



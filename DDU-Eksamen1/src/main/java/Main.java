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

    Toggle tggl = new Toggle();

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
        AIMovesInstances();
    }

    @Override
    public void draw() {
        drawStart();
        drawPieces();
    }

    @Override
    public void mousePressed() {
    }

    @Override
    public void mouseReleased() {
        tggl.tooglePick();
        if(tggl.pieceSelected)
        selectPieces();
        else
        deselectPieces();
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

    void AIMovesInstances(){
        for(int i = 0; i< AImatrosserne.size(); i++){
            MatrosAI AIm = AImatrosserne.get(i);
            SoeroeverAI AIso;
            SkipperAI AIsk;
            CaptainCrunchAI AIcc;

            //matrosserne
            AIm.instantiateArray();

            //sørøverne
            if(i<AIsoeroeverne.size()) {
                AIso = AIsoeroeverne.get(i);
                AIso.instantiateArray();
            }

            //skipperne
            if(i<AIskipperne.size()) {
                AIsk = AIskipperne.get(i);
                AIsk.instantiateArray();
            }

            //captain
            if(i<AIcaptain.size()) {
                AIcc = AIcaptain.get(i);
                AIcc.instantiateArray();

            }
        }
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

    void selectPieces() {
        for(int i = 0; i< matrosserne.size(); i++){
            Matros m = matrosserne.get(i);
            Soeroever so;
            Skipper sk;
            CaptainCrunch cc;

            //matrosserne
            m.checkIfClicked();

            //sørøverne
            if(i<soeroeverne.size()) {
                so = soeroeverne.get(i);
                so.checkIfClicked();
            }

            //skipperne
            if(i<skipperne.size()) {
                sk = skipperne.get(i);
                sk.checkIfClicked();
            }

            //captain
            if(i<captain.size()) {
                cc = captain.get(i);
                cc.checkIfClicked();

            }
        }
    }

    void deselectPieces() {
        for(int i = 0; i< matrosserne.size(); i++){
            Matros m = matrosserne.get(i);
            Soeroever so;
            Skipper sk;
            CaptainCrunch cc;

            //matrosserne
            m.checkIfReleased();

            //sørøverne
            if(i<soeroeverne.size()) {
                so = soeroeverne.get(i);
                so.checkIfReleased();
            }

            //skipperne
            if(i<skipperne.size()) {
                sk = skipperne.get(i);
                sk.checkIfReleased();
            }

            //captain
            if(i<captain.size()) {
                cc = captain.get(i);
                cc.checkIfReleased();

            }
        }
    }

    void AIMover(){
        int r = (int)random(allAIPieces.size());

        if(r<4){
            int rm = (int)random(AImatrosserne.size());
            AImatrosserne.get(rm).moveSet();

        } else if(r<7){
            int rso = (int)random(AIsoeroeverne.size());
            AIsoeroeverne.get(rso).moveSet();

        } else if(r<9){
            int rsk = (int)random(AIskipperne.size());
            AIskipperne.get(rsk).moveSet();

        } else if(r<10){
            AIcaptain.get(0).moveSet();

        }
    }
}
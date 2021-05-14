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
        tggl.toggleClicked();
        if (tggl.pieceSelected) {
            selectPieces();
        } else {
            deselectPieces();
            AIMover();
        }
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

    void AIInstances() {
        int grantID = 0;

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
            AImatrosserne.add(new MatrosAI(a, t, redMatros, grantID, this));
            grantID++;
        }

        //sørøverne
        for (int i = 0; i < 3; i++) {
            AIsoeroeverne.add(new SoeroeverAI(width / 2 - 245 + (i * 200), 150, redSoeroever, grantID, this));
            grantID++;
        }

        //skipperne
        for (int i = 0; i < 2; i++) {
            AIskipperne.add(new SkipperAI(width / 2 - 145 + (i * 200), 50, redSkipper, grantID, this));
            grantID++;
        }

        //captain
        AIcaptain.add(new CaptainCrunchAI(width / 2 - 45, 50, redCaptain, grantID, this));

        allAIPieces.addAll(AImatrosserne);
        allAIPieces.addAll(AIsoeroeverne);
        allAIPieces.addAll(AIskipperne);
        allAIPieces.addAll(AIcaptain);

        System.out.println(allAIPieces);
    }

    void AIMovesInstances() {
        for (int i = 0; i < AImatrosserne.size(); i++) {
            MatrosAI AIm = AImatrosserne.get(i);
            SoeroeverAI AIso;
            SkipperAI AIsk;
            CaptainCrunchAI AIcc;

            //matrosserne
            AIm.instantiateArray();

            //sørøverne
            if (i < AIsoeroeverne.size()) {
                AIso = AIsoeroeverne.get(i);
                AIso.instantiateArray();
            }

            //skipperne
            if (i < AIskipperne.size()) {
                AIsk = AIskipperne.get(i);
                AIsk.instantiateArray();
            }

            //captain
            if (i < AIcaptain.size()) {
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

        for (int i = 0; i < allAIPieces.size(); i++) {
            AIPieces aip = allAIPieces.get(i);
            aip.drawBoardPiece();
        }
    }

    void selectPieces() {
        for (int i = 0; i < matrosserne.size(); i++) {
            Matros m = matrosserne.get(i);
            Soeroever so;
            Skipper sk;
            CaptainCrunch cc;

            //matrosserne
            m.checkIfClicked();

            //sørøverne
            if (i < soeroeverne.size()) {
                so = soeroeverne.get(i);
                so.checkIfClicked();
            }

            //skipperne
            if (i < skipperne.size()) {
                sk = skipperne.get(i);
                sk.checkIfClicked();
            }

            //captain
            if (i < captain.size()) {
                cc = captain.get(i);
                cc.checkIfClicked();

            }
        }
    }

    void deselectPieces() {
        for (int i = 0; i < matrosserne.size(); i++) {
            Matros m = matrosserne.get(i);
            Soeroever so;
            Skipper sk;
            CaptainCrunch cc;

            //matrosserne
            m.checkIfReleased();

            //sørøverne
            if (i < soeroeverne.size()) {
                so = soeroeverne.get(i);
                so.checkIfReleased();
            }

            //skipperne
            if (i < skipperne.size()) {
                sk = skipperne.get(i);
                sk.checkIfReleased();
            }

            //captain
            if (i < captain.size()) {
                cc = captain.get(i);
                cc.checkIfReleased();

            }
        }
    }

    void AIMover() {
        int r = (int) random(allAIPieces.size());

        if (r < 4) {
            int rm = (int) random(AImatrosserne.size());
            AImatrosserne.get(rm).moveSet();

            System.out.println("matros");
            for (int i = 0; i < allAIPieces.size(); i++) {
                if (allAIPieces.get(i).ID != AImatrosserne.get(rm).ID) {
                 if (AImatrosserne.get(rm).posX == allAIPieces.get(i).posX && AImatrosserne.get(rm).posY == allAIPieces.get(i).posY) {
                        AImatrosserne.get(rm).posX = AImatrosserne.get(rm).oriPosX;
                        AImatrosserne.get(rm).posY = AImatrosserne.get(rm).oriPosY;
                        AIMover();
                    } else if (AImatrosserne.get(rm).posX < 0 || AImatrosserne.get(rm).posX > width-40 || AImatrosserne.get(rm).posY < 10 || AImatrosserne.get(rm).posY > 550) {
                        AImatrosserne.get(rm).posX = AImatrosserne.get(rm).oriPosX;
                        AImatrosserne.get(rm).posY = AImatrosserne.get(rm).oriPosY;
                        AIMover();
                    }
                }
            }
            AImatrosserne.get(rm).instantiateArray();

        } else if (r < 7) {
            int rso = (int) random(AIsoeroeverne.size());
            System.out.println("soeroever");
            AIsoeroeverne.get(rso).moveSet();
            for (int i = 0; i < allAIPieces.size(); i++) {
                if (allAIPieces.get(i).ID != AIsoeroeverne.get(rso).ID) {
                    if (AIsoeroeverne.get(rso).posX == allAIPieces.get(i).posX && AIsoeroeverne.get(rso).posY == allAIPieces.get(i).posY) {
                        AIsoeroeverne.get(rso).posX = AIsoeroeverne.get(rso).oriPosX;
                        AIsoeroeverne.get(rso).posY = AIsoeroeverne.get(rso).oriPosY;
                        AIMover();
                    } else if (AIsoeroeverne.get(rso).posX < 0 || AIsoeroeverne.get(rso).posX > width-40 || AIsoeroeverne.get(rso).posY < 10 || AIsoeroeverne.get(rso).posY > 550) {
                        AIsoeroeverne.get(rso).posX = AIsoeroeverne.get(rso).oriPosX;
                        AIsoeroeverne.get(rso).posY = AIsoeroeverne.get(rso).oriPosY;
                        AIMover();
                    }
                }
            }
            AIsoeroeverne.get(rso).instantiateArray();

        } else if (r < 9) {
            int rsk = (int) random(AIskipperne.size());
            System.out.println("skipper");
            AIskipperne.get(rsk).moveSet();
            for (int i = 0; i < allAIPieces.size(); i++) {
                if (allAIPieces.get(i).ID != AIskipperne.get(rsk).ID) {
                    if (AIskipperne.get(rsk).posX == allAIPieces.get(i).posX && AIskipperne.get(rsk).posY == allAIPieces.get(i).posY) {
                        AIskipperne.get(rsk).posX = AIskipperne.get(rsk).oriPosX;
                        AIskipperne.get(rsk).posY = AIskipperne.get(rsk).oriPosY;
                        AIMover();
                    } else if (AIskipperne.get(rsk).posX < 0 || AIskipperne.get(rsk).posX > width-40 || AIskipperne.get(rsk).posY < 10 || AIskipperne.get(rsk).posY > 550) {
                        AIskipperne.get(rsk).posX = AIskipperne.get(rsk).oriPosX;
                        AIskipperne.get(rsk).posY = AIskipperne.get(rsk).oriPosY;
                        AIMover();
                    }
                }
            }
            AIskipperne.get(rsk).instantiateArray();

        } else if (r < 10) {
            System.out.println("captain");
            AIcaptain.get(0).moveSet();
            for (int i = 0; i < allAIPieces.size(); i++) {
                if (allAIPieces.get(i).ID != AIcaptain.get(0).ID) {
                    if (AIcaptain.get(0).posX == allAIPieces.get(i).posX && AIcaptain.get(0).posY == allAIPieces.get(i).posY) {
                        AIcaptain.get(0).posX = AIcaptain.get(0).oriPosX;
                        AIcaptain.get(0).posY = AIcaptain.get(0).oriPosY;
                        AIMover();
                    } else if (AIcaptain.get(0).posX < 0 || AIcaptain.get(0).posX > width-40 || AIcaptain.get(0).posY < 10 || AIcaptain.get(0).posY > 550) {
                        AIcaptain.get(0).posX = AIcaptain.get(0).oriPosX;
                        AIcaptain.get(0).posY = AIcaptain.get(0).oriPosY;
                        AIMover();
                    }
                }
            }
            AIcaptain.get(0).instantiateArray();
        }
    }

    void checkForEnemyKilled(){

    }

    void checkForAllyKilled(){

    }
}
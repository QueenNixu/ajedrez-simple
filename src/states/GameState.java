package states;

import java.awt.Graphics;

import gameObject.BlackBishopRight;
import gameObject.BlackBishopLeft;
import gameObject.BlackHorseRight;
import gameObject.BlackHorseLeft;
import gameObject.BlackKing;
import gameObject.BlackPawn;
import gameObject.BlackQueen;
import gameObject.BlackTowerLeft;
import gameObject.BlackTowerRight;
import gameObject.WhiteBishopLeft;
import gameObject.WhiteBishopRight;
import gameObject.WhiteHorseLeft;
import gameObject.WhiteHorseRight;
import gameObject.WhiteKing;
import gameObject.WhiteQueen;
import gameObject.WhiteTowerLeft;
import gameObject.WhiteTowerRight;
import gameObject.WhitePawn;
import graphics.Assets;
import math.Vector2D;

public class GameState {

    // Definición de las posiciones iniciales para cada pieza
    private Vector2D wkPos = new Vector2D(60 * 4, 60 * 7);
    private Vector2D wqPos = new Vector2D(60 * 3, 60 * 7);
    private Vector2D wblPos = new Vector2D(60 * 2, 60 * 7);
    private Vector2D whlPos = new Vector2D(60 * 1, 60 * 7);
    private Vector2D wtlPos = new Vector2D(60 * 0, 60 * 7);
    private Vector2D wbrPos = new Vector2D(60 * 5, 60 * 7);
    private Vector2D whrPos = new Vector2D(60 * 6, 60 * 7);
    private Vector2D wtrPos = new Vector2D(60 * 7, 60 * 7);
    private Vector2D[] wpPos = {
        new Vector2D(60 * 4, 60 * 6), new Vector2D(60 * 3, 60 * 6),
        new Vector2D(60 * 2, 60 * 6), new Vector2D(60 * 1, 60 * 6),
        new Vector2D(60 * 0, 60 * 6), new Vector2D(60 * 5, 60 * 6),
        new Vector2D(60 * 6, 60 * 6), new Vector2D(60 * 7, 60 * 6)
    };

    private Vector2D bkPos = new Vector2D(60 * 4, 60 * 0);
    private Vector2D bqPos = new Vector2D(60 * 3, 60 * 0);
    private Vector2D bblPos = new Vector2D(60 * 2, 60 * 0);
    private Vector2D bhlPos = new Vector2D(60 * 1, 60 * 0);
    private Vector2D btlPos = new Vector2D(60 * 0, 60 * 0);
    private Vector2D bbrPos = new Vector2D(60 * 5, 60 * 0);
    private Vector2D bhrPos = new Vector2D(60 * 6, 60 * 0);
    private Vector2D btrPos = new Vector2D(60 * 7, 60 * 0);
    private Vector2D[] bpPos = {
        new Vector2D(60 * 4, 60 * 1), new Vector2D(60 * 3, 60 * 1),
        new Vector2D(60 * 2, 60 * 1), new Vector2D(60 * 1, 60 * 1),
        new Vector2D(60 * 0, 60 * 1), new Vector2D(60 * 5, 60 * 1),
        new Vector2D(60 * 6, 60 * 1), new Vector2D(60 * 7, 60 * 1)
    };

    // Definición de las piezas
    private WhiteKing whiteKing;
    private WhiteQueen whiteQueen;
    private WhiteBishopLeft whiteBishopLeft;
    private WhiteHorseLeft whiteHorseLeft;
    private WhiteTowerLeft whiteTowerLeft;
    private WhiteBishopRight whiteBishopRight;
    private WhiteHorseRight whiteHorseRight;
    private WhiteTowerRight whiteTowerRight;
    private WhitePawn[] whitePawns = new WhitePawn[8];

    private BlackKing blackKing;
    private BlackQueen blackQueen;
    private BlackBishopLeft blackBishopLeft;
    private BlackHorseLeft blackHorseLeft;
    private BlackTowerLeft blackTowerLeft;
    private BlackBishopRight blackBishopRight;
    private BlackHorseRight blackHorseRight;
    private BlackTowerRight blackTowerRight;
    private BlackPawn[] blackPawns = new BlackPawn[8];

    public GameState() {
        // Inicialización de las piezas blancas
        whiteKing = new WhiteKing(wkPos, Assets.whiteKing);
        whiteQueen = new WhiteQueen(wqPos, Assets.whiteQueen);
        whiteBishopLeft = new WhiteBishopLeft(wblPos, Assets.whiteBishop);
        whiteHorseLeft = new WhiteHorseLeft(whlPos, Assets.whiteHorse);
        whiteTowerLeft = new WhiteTowerLeft(wtlPos, Assets.whiteTower);
        whiteBishopRight = new WhiteBishopRight(wbrPos, Assets.whiteBishop);
        whiteHorseRight = new WhiteHorseRight(whrPos, Assets.whiteHorse);
        whiteTowerRight = new WhiteTowerRight(wtrPos, Assets.whiteTower);
        for (int i = 0; i < 8; i++) {
            whitePawns[i] = new WhitePawn(wpPos[i], Assets.whitePawn);
        }

        // Inicialización de las piezas negras
        blackKing = new BlackKing(bkPos, Assets.blackKing);
        blackQueen = new BlackQueen(bqPos, Assets.blackQueen);
        blackBishopLeft = new BlackBishopLeft(bblPos, Assets.blackBishop);
        blackHorseLeft = new BlackHorseLeft(bhlPos, Assets.blackHorse);
        blackTowerLeft = new BlackTowerLeft(btlPos, Assets.blackTower);
        blackBishopRight = new BlackBishopRight(bbrPos, Assets.blackBishop);
        blackHorseRight = new BlackHorseRight(bhrPos, Assets.blackHorse);
        blackTowerRight = new BlackTowerRight(btrPos, Assets.blackTower);
        for (int i = 0; i < 8; i++) {
            blackPawns[i] = new BlackPawn(bpPos[i], Assets.blackPawn);
        }
    }

    // Métodos de actualización y dibujo
    public void update() {
        // Actualizar cada pieza
        whiteKing.update();
        whiteQueen.update();
        whiteBishopLeft.update();
        whiteHorseLeft.update();
        whiteTowerLeft.update();
        whiteBishopRight.update();
        whiteHorseRight.update();
        whiteTowerRight.update();
        for (WhitePawn pawn : whitePawns) {
            pawn.update();
        }

        blackKing.update();
        blackQueen.update();
        blackBishopLeft.update();
        blackHorseLeft.update();
        blackTowerLeft.update();
        blackBishopRight.update();
        blackHorseRight.update();
        blackTowerRight.update();
        for (BlackPawn pawn : blackPawns) {
            pawn.update();
        }
    }


    public void draw(Graphics g) {
        // Dibujar todas las piezas
        whiteKing.draw(g);
        whiteQueen.draw(g);
        whiteBishopLeft.draw(g);
        whiteHorseLeft.draw(g);
        whiteTowerLeft.draw(g);
        whiteBishopRight.draw(g);
        whiteHorseRight.draw(g);
        whiteTowerRight.draw(g);
        for (WhitePawn pawn : whitePawns) {
            pawn.draw(g);
        }

        blackKing.draw(g);
        blackQueen.draw(g);
        blackBishopLeft.draw(g);
        blackHorseLeft.draw(g);
        blackTowerLeft.draw(g);
        blackBishopRight.draw(g);
        blackHorseRight.draw(g);
        blackTowerRight.draw(g);
        for (BlackPawn pawn : blackPawns) {
            pawn.draw(g);
        }
    }
}


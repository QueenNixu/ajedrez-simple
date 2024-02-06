package states;

import java.awt.Graphics;

import gameObject.BlackBishop;
import gameObject.BlackHorse;
import gameObject.BlackKing;
import gameObject.BlackPawn;
import gameObject.BlackQueen;
import gameObject.BlackTower;
import gameObject.WhiteBishop;
import gameObject.WhiteHorse;
import gameObject.WhiteKing;
import gameObject.WhiteQueen;
import gameObject.WhiteTower;
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
    private WhiteBishop whiteBishopLeft;
    private WhiteHorse whiteHorseLeft;
    private WhiteTower whiteTowerLeft;
    private WhiteBishop whiteBishopRight;
    private WhiteHorse whiteHorseRight;
    private WhiteTower whiteTowerRight;
    private WhitePawn[] whitePawns = new WhitePawn[8];

    private BlackKing blackKing;
    private BlackQueen blackQueen;
    private BlackBishop blackBishopLeft;
    private BlackHorse blackHorseLeft;
    private BlackTower blackTowerLeft;
    private BlackBishop blackBishopRight;
    private BlackHorse blackHorseRight;
    private BlackTower blackTowerRight;
    private BlackPawn[] blackPawns = new BlackPawn[8];

    public GameState() {
        // Inicialización de las piezas blancas
        whiteKing = new WhiteKing(wkPos, Assets.whiteKing);
        whiteQueen = new WhiteQueen(wqPos, Assets.whiteQueen);
        whiteBishopLeft = new WhiteBishop(wblPos, Assets.whiteBishop);
        whiteHorseLeft = new WhiteHorse(whlPos, Assets.whiteHorse);
        whiteTowerLeft = new WhiteTower(wtlPos, Assets.whiteTower);
        whiteBishopRight = new WhiteBishop(wbrPos, Assets.whiteBishop);
        whiteHorseRight = new WhiteHorse(whrPos, Assets.whiteHorse);
        whiteTowerRight = new WhiteTower(wtrPos, Assets.whiteTower);
        for (int i = 0; i < 8; i++) {
            whitePawns[i] = new WhitePawn(wpPos[i], Assets.whitePawn);
        }

        // Inicialización de las piezas negras
        blackKing = new BlackKing(bkPos, Assets.blackKing);
        blackQueen = new BlackQueen(bqPos, Assets.blackQueen);
        blackBishopLeft = new BlackBishop(bblPos, Assets.blackBishop);
        blackHorseLeft = new BlackHorse(bhlPos, Assets.blackHorse);
        blackTowerLeft = new BlackTower(btlPos, Assets.blackTower);
        blackBishopRight = new BlackBishop(bbrPos, Assets.blackBishop);
        blackHorseRight = new BlackHorse(bhrPos, Assets.blackHorse);
        blackTowerRight = new BlackTower(btrPos, Assets.blackTower);
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


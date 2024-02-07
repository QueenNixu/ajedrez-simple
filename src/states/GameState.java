package states;

import java.awt.Graphics;

import gameObject.BlackBishopRight;
import gameObject.AllowedCells;
import gameObject.BlackBishopLeft;
import gameObject.BlackHorseRight;
import gameObject.BlackHorseLeft;
import gameObject.BlackKing;
import gameObject.BlackPawn0;
import gameObject.BlackPawn1;
import gameObject.BlackPawn2;
import gameObject.BlackPawn3;
import gameObject.BlackPawn4;
import gameObject.BlackPawn5;
import gameObject.BlackPawn6;
import gameObject.BlackPawn7;
import gameObject.BlackQueen;
import gameObject.BlackTowerLeft;
import gameObject.BlackTowerRight;
import gameObject.ObjectPosition;
import gameObject.WhiteBishopLeft;
import gameObject.WhiteBishopRight;
import gameObject.WhiteHorseLeft;
import gameObject.WhiteHorseRight;
import gameObject.WhiteKing;
import gameObject.WhiteQueen;
import gameObject.WhiteTowerLeft;
import gameObject.WhiteTowerRight;
import gameObject.WhitePawn;
import gameObject.WhitePawn0;
import gameObject.WhitePawn1;
import gameObject.WhitePawn2;
import gameObject.WhitePawn3;
import gameObject.WhitePawn4;
import gameObject.WhitePawn5;
import gameObject.WhitePawn6;
import gameObject.WhitePawn7;
import graphics.Assets;
import input.Mouse;
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
    
    private Vector2D wp0Pos = new Vector2D(60 * 0, 60 * 6);
    private Vector2D wp1Pos = new Vector2D(60 * 1, 60 * 6);
    private Vector2D wp2Pos = new Vector2D(60 * 2, 60 * 6);
    private Vector2D wp3Pos = new Vector2D(60 * 3, 60 * 6);
    private Vector2D wp4Pos = new Vector2D(60 * 4, 60 * 6);
    private Vector2D wp5Pos = new Vector2D(60 * 5, 60 * 6);
    private Vector2D wp6Pos = new Vector2D(60 * 6, 60 * 6);
    private Vector2D wp7Pos = new Vector2D(60 * 7, 60 * 6);
    
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
//
    private Vector2D bp0Pos = new Vector2D(60 * 0, 60 * 1);
    private Vector2D bp1Pos = new Vector2D(60 * 1, 60 * 1);
    private Vector2D bp2Pos = new Vector2D(60 * 2, 60 * 1);
    private Vector2D bp3Pos = new Vector2D(60 * 3, 60 * 1);
    private Vector2D bp4Pos = new Vector2D(60 * 4, 60 * 1);
    private Vector2D bp5Pos = new Vector2D(60 * 5, 60 * 1);
    private Vector2D bp6Pos = new Vector2D(60 * 6, 60 * 1);
    private Vector2D bp7Pos = new Vector2D(60 * 7, 60 * 1);
    /*
    private Vector2D[] bpPos = {
        new Vector2D(60 * 4, 60 * 1), new Vector2D(60 * 3, 60 * 1),
        new Vector2D(60 * 2, 60 * 1), new Vector2D(60 * 1, 60 * 1),
        new Vector2D(60 * 0, 60 * 1), new Vector2D(60 * 5, 60 * 1),
        new Vector2D(60 * 6, 60 * 1), new Vector2D(60 * 7, 60 * 1)
    };
    */
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
    
    private WhitePawn0 whitePawn0;
	private WhitePawn1 whitePawn1;
	private WhitePawn2 whitePawn2;
	private WhitePawn3 whitePawn3;
	private WhitePawn4 whitePawn4;
	private WhitePawn5 whitePawn5;
	private WhitePawn6 whitePawn6;
	private WhitePawn7 whitePawn7;

    private BlackKing blackKing;
    private BlackQueen blackQueen;
    private BlackBishopLeft blackBishopLeft;
    private BlackHorseLeft blackHorseLeft;
    private BlackTowerLeft blackTowerLeft;
    private BlackBishopRight blackBishopRight;
    private BlackHorseRight blackHorseRight;
    private BlackTowerRight blackTowerRight;
    private BlackPawn0[] blackPawns = new BlackPawn0[8];
    
    private AllowedCells[][] allowedCells = new AllowedCells[8][8];
	private BlackPawn0 blackPawn0;
	private BlackPawn1 blackPawn1;
	private BlackPawn2 blackPawn2;
	private BlackPawn3 blackPawn3;
	private BlackPawn4 blackPawn4;
	private BlackPawn5 blackPawn5;
	private BlackPawn6 blackPawn6;
	private BlackPawn7 blackPawn7;

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
        
        whitePawn0 = new WhitePawn0(wp0Pos, Assets.whitePawn);
        whitePawn1 = new WhitePawn1(wp1Pos, Assets.whitePawn);
        whitePawn2 = new WhitePawn2(wp2Pos, Assets.whitePawn);
        whitePawn3 = new WhitePawn3(wp3Pos, Assets.whitePawn);
        whitePawn4 = new WhitePawn4(wp4Pos, Assets.whitePawn);
        whitePawn5 = new WhitePawn5(wp5Pos, Assets.whitePawn);
        whitePawn6 = new WhitePawn6(wp6Pos, Assets.whitePawn);
        whitePawn7 = new WhitePawn7(wp7Pos, Assets.whitePawn);
        /*
        for (int i = 0; i < 8; i++) {
            whitePawns[i] = new WhitePawn(wpPos[i], Assets.whitePawn);
        }
        */

        // Inicialización de las piezas negras
        blackKing = new BlackKing(bkPos, Assets.blackKing);
        blackQueen = new BlackQueen(bqPos, Assets.blackQueen);
        blackBishopLeft = new BlackBishopLeft(bblPos, Assets.blackBishop);
        blackHorseLeft = new BlackHorseLeft(bhlPos, Assets.blackHorse);
        blackTowerLeft = new BlackTowerLeft(btlPos, Assets.blackTower);
        blackBishopRight = new BlackBishopRight(bbrPos, Assets.blackBishop);
        blackHorseRight = new BlackHorseRight(bhrPos, Assets.blackHorse);
        blackTowerRight = new BlackTowerRight(btrPos, Assets.blackTower);
        
        blackPawn0 = new BlackPawn0(bp0Pos, Assets.blackPawn);
        blackPawn1 = new BlackPawn1(bp1Pos, Assets.blackPawn);
        blackPawn2 = new BlackPawn2(bp2Pos, Assets.blackPawn);
        blackPawn3 = new BlackPawn3(bp3Pos, Assets.blackPawn);
        blackPawn4 = new BlackPawn4(bp4Pos, Assets.blackPawn);
        blackPawn5 = new BlackPawn5(bp5Pos, Assets.blackPawn);
        blackPawn6 = new BlackPawn6(bp6Pos, Assets.blackPawn);
        blackPawn7 = new BlackPawn7(bp7Pos, Assets.blackPawn);
        /*
        for (int i = 0; i < 8; i++) {
            blackPawns[i] = new BlackPawn0(bpPos[i], Assets.blackPawn);
        }
        */
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		allowedCells[i][j] = new AllowedCells(new Vector2D(60*i,60*j), Assets.allowedCell);
        	}
        }
        
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		ObjectPosition.allowedCellsBool[i][j] = false;
        	}
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
        
        whitePawn0.update();
        whitePawn1.update();
        whitePawn2.update();
        whitePawn3.update();
        whitePawn4.update();
        whitePawn5.update();
        whitePawn6.update();
        whitePawn7.update();
        /*
        for (WhitePawn pawn : whitePawns) {
            pawn.update();
        }
        */

        blackKing.update();
        blackQueen.update();
        blackBishopLeft.update();
        blackHorseLeft.update();
        blackTowerLeft.update();
        blackBishopRight.update();
        blackHorseRight.update();
        blackTowerRight.update();
        
        blackPawn0.update();
        blackPawn1.update();
        blackPawn2.update();
        blackPawn3.update();
        blackPawn4.update();
        blackPawn5.update();
        blackPawn6.update();
        blackPawn7.update();
        
        /*
        for (BlackPawn0 pawn : blackPawns) {
            pawn.update();
        }
        */
        
        if(Mouse.mousePressed) {
        	for (int i = 0; i < 8; i++) {
            	for (int j = 0; j < 8; j++) {
            		if(ObjectPosition.allowedCellsBool[i][j]) {
            			allowedCells[i][j].update();;
            		}
            	}
            }
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
        
        whitePawn0.draw(g);
        whitePawn1.draw(g);
        whitePawn2.draw(g);
        whitePawn3.draw(g);
        whitePawn4.draw(g);
        whitePawn5.draw(g);
        whitePawn6.draw(g);
        whitePawn7.draw(g);
        /*
        for (WhitePawn pawn : whitePawns) {
            pawn.draw(g);
        }
        */

        blackKing.draw(g);
        blackQueen.draw(g);
        blackBishopLeft.draw(g);
        blackHorseLeft.draw(g);
        blackTowerLeft.draw(g);
        blackBishopRight.draw(g);
        blackHorseRight.draw(g);
        blackTowerRight.draw(g);
        
        blackPawn0.draw(g);
        blackPawn1.draw(g);
        blackPawn2.draw(g);
        blackPawn3.draw(g);
        blackPawn4.draw(g);
        blackPawn5.draw(g);
        blackPawn6.draw(g);
        blackPawn7.draw(g);
        
        /*
        for (BlackPawn0 pawn : blackPawns) {
            pawn.draw(g);
        }
        */
        
        if(Mouse.mousePressed) {

        	for (int i = 0; i < 8; i++) {
            	for (int j = 0; j < 8; j++) {
            		if(ObjectPosition.allowedCellsBool[i][j]) {
            			allowedCells[i][j].draw(g);
            		}
            	}
            }
            
        }
        
        
    }
}


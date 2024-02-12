package states;

import java.awt.Graphics;
import java.util.ArrayList;

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
import gameObject.Constants;
import gameObject.MovingObject;
import gameObject.ObjectPosition;
import gameObject.WhiteBishopLeft;
import gameObject.WhiteBishopRight;
import gameObject.WhiteHorseLeft;
import gameObject.WhiteHorseRight;
import gameObject.WhiteKing;
import gameObject.WhiteQueen;
import gameObject.WhiteTowerLeft;
import gameObject.WhiteTowerRight;
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
	
	//pasar de object posicion aca

    // PASAR A CONSTANTS
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
    
    private AllowedCells[][] allowedCells = new AllowedCells[8][8];
	
	private ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();

    public GameState() {
    	
        // Inicialización de las piezas blancas
    	movingObjects.add(new WhiteKing(wkPos, Assets.whiteKing, this));
    	movingObjects.add(new WhiteQueen(wqPos, Assets.whiteQueen, this));
    	movingObjects.add(new WhiteBishopLeft(wblPos, Assets.whiteBishop, this));
    	movingObjects.add(new WhiteHorseLeft(whlPos, Assets.whiteHorse, this));
    	movingObjects.add(new WhiteTowerLeft(wtlPos, Assets.whiteTower, this));
    	movingObjects.add(new WhiteBishopRight(wbrPos, Assets.whiteBishop, this));
    	movingObjects.add(new WhiteHorseRight(whrPos, Assets.whiteHorse, this));
    	movingObjects.add(new WhiteTowerRight(wtrPos, Assets.whiteTower, this));
    	
    	movingObjects.add(new WhitePawn0(wp0Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn1(wp1Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn2(wp2Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn3(wp3Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn4(wp4Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn5(wp5Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn6(wp6Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn7(wp7Pos, Assets.whitePawn, this));

        // Inicialización de las piezas negras
    	movingObjects.add(new BlackKing(bkPos, Assets.blackKing, this));
    	movingObjects.add(new BlackQueen(bqPos, Assets.blackQueen, this));
    	movingObjects.add(new BlackBishopLeft(bblPos, Assets.blackBishop, this));
    	movingObjects.add(new BlackHorseLeft(bhlPos, Assets.blackHorse, this));
    	movingObjects.add(new BlackTowerLeft(btlPos, Assets.blackTower, this));
    	movingObjects.add(new BlackBishopRight(bbrPos, Assets.blackBishop, this));
    	movingObjects.add(new BlackHorseRight(bhrPos, Assets.blackHorse, this));
    	movingObjects.add(new BlackTowerRight(btrPos, Assets.blackTower, this));
    	
    	movingObjects.add(new BlackPawn0(bp0Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn1(bp1Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn2(bp2Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn3(bp3Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn4(bp4Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn5(bp5Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn6(bp6Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn7(bp7Pos, Assets.blackPawn, this));

        for (int i = 0; i <= 7; i++) {
        	for (int j = 0; j <= 7; j++) {
        		allowedCells[i][j] = new AllowedCells(new Vector2D(Constants.CELLSIZE*i,Constants.CELLSIZE*j), Assets.allowedCell);
        		ObjectPosition.allowedCellsBool[i][j] = false;
        	}
        }
        
    }

    // Métodos de actualización y dibujo
    public void update() {
    	
    	for(int i = 0; i < movingObjects.size(); i++) {
			
			MovingObject mo = movingObjects.get(i);
			
			mo.update();
			if(mo.isDead()) {
				movingObjects.remove(i);
				i--;
			}
			
		}
        
        if(Mouse.mousePressed) {
        	for (int i = 0; i <= 7; i++) {
            	for (int j = 0; j <= 7; j++) {
            		if(ObjectPosition.allowedCellsBool[i][j]) {
            			allowedCells[i][j].update();;
            		}
            	}
            }
        }
        
        
    }


    public void draw(Graphics g) {

        for(int i = 0; i < movingObjects.size(); i++)
			movingObjects.get(i).draw(g);
        
        if(Mouse.mousePressed) {

        	for (int i = 0; i <= 7; i++) {
            	for (int j = 0; j <= 7; j++) {
            		if(ObjectPosition.allowedCellsBool[i][j]) {
            			allowedCells[i][j].draw(g);
            		}
            	}
            }
            
        }
        
        
    }

	public ArrayList<MovingObject> getMovingObjects() {
		return movingObjects;
	}
	
	public MovingObject getMovingObject(int id) {
		for(int i = 0; i < movingObjects.size(); i++) {
			if(movingObjects.get(i).getId() == id) {
				return movingObjects.get(i);
			}
		}
		return null;
	}
}


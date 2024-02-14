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
    
    public static AllowedCells[][] allowedCells = new AllowedCells[8][8];
	
	public static ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
	
	//-1 = vacio
	//0-15 blancas
	//16-31 negras
	public int[][] posicionesDelTablero = new int[8][8];
	    
	//la posicion de cada pieza
	public Vector2D[] piecePosition = new Vector2D[32];
	
	public Boolean[][] allowedCellsBool = new Boolean[8][8];

    public GameState() {
    	
        // Inicialización de las piezas blancas
    	movingObjects.add(new WhiteKing(Constants.wkPos, Assets.whiteKing, this));
    	movingObjects.add(new WhiteQueen(Constants.wqPos, Assets.whiteQueen, this));
    	movingObjects.add(new WhiteBishopLeft(Constants.wblPos, Assets.whiteBishop, this));
    	movingObjects.add(new WhiteHorseLeft(Constants.whlPos, Assets.whiteHorse, this));
    	movingObjects.add(new WhiteTowerLeft(Constants.wtlPos, Assets.whiteTower, this));
    	movingObjects.add(new WhiteBishopRight(Constants.wbrPos, Assets.whiteBishop, this));
    	movingObjects.add(new WhiteHorseRight(Constants.whrPos, Assets.whiteHorse, this));
    	movingObjects.add(new WhiteTowerRight(Constants.wtrPos, Assets.whiteTower, this));
    	
    	movingObjects.add(new WhitePawn0(Constants.wp0Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn1(Constants.wp1Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn2(Constants.wp2Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn3(Constants.wp3Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn4(Constants.wp4Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn5(Constants.wp5Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn6(Constants.wp6Pos, Assets.whitePawn, this));
    	movingObjects.add(new WhitePawn7(Constants.wp7Pos, Assets.whitePawn, this));

        // Inicialización de las piezas negras
    	movingObjects.add(new BlackKing(Constants.bkPos, Assets.blackKing, this));
    	movingObjects.add(new BlackQueen(Constants.bqPos, Assets.blackQueen, this));
    	movingObjects.add(new BlackBishopLeft(Constants.bblPos, Assets.blackBishop, this));
    	movingObjects.add(new BlackHorseLeft(Constants.bhlPos, Assets.blackHorse, this));
    	movingObjects.add(new BlackTowerLeft(Constants.btlPos, Assets.blackTower, this));
    	movingObjects.add(new BlackBishopRight(Constants.bbrPos, Assets.blackBishop, this));
    	movingObjects.add(new BlackHorseRight(Constants.bhrPos, Assets.blackHorse, this));
    	movingObjects.add(new BlackTowerRight(Constants.btrPos, Assets.blackTower, this));
    	
    	movingObjects.add(new BlackPawn0(Constants.bp0Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn1(Constants.bp1Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn2(Constants.bp2Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn3(Constants.bp3Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn4(Constants.bp4Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn5(Constants.bp5Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn6(Constants.bp6Pos, Assets.blackPawn, this));
    	movingObjects.add(new BlackPawn7(Constants.bp7Pos, Assets.blackPawn, this));

        for (int i = 0; i <= 7; i++) {
        	for (int j = 0; j <= 7; j++) {
        		allowedCells[i][j] = new AllowedCells(new Vector2D(Constants.CELLSIZE*i,Constants.CELLSIZE*j), Assets.allowedCell);
        		allowedCellsBool[i][j] = false;
        	}
        }
        
        Vector2D[] allPositions = {
                new Vector2D(60 * 4, 60 * 7),  // wkPos
                new Vector2D(60 * 3, 60 * 7),  // wqPos
                new Vector2D(60 * 2, 60 * 7),  // wblPos
                new Vector2D(60 * 1, 60 * 7),  // whlPos
                new Vector2D(60 * 0, 60 * 7),  // wtlPos
                new Vector2D(60 * 5, 60 * 7),  // wbrPos
                new Vector2D(60 * 6, 60 * 7),  // whrPos
                new Vector2D(60 * 7, 60 * 7),  // wtrPos
                new Vector2D(60 * 0, 60 * 6),  // wpPos[0]
                new Vector2D(60 * 1, 60 * 6),  // wpPos[1]
                new Vector2D(60 * 2, 60 * 6),  // wpPos[2]
                new Vector2D(60 * 3, 60 * 6),  // wpPos[3]
                new Vector2D(60 * 4, 60 * 6),  // wpPos[4]
                new Vector2D(60 * 5, 60 * 6),  // wpPos[5]
                new Vector2D(60 * 6, 60 * 6),  // wpPos[6]
                new Vector2D(60 * 7, 60 * 6),  // wpPos[7]
                new Vector2D(60 * 4, 60 * 0),  // bkPos
                new Vector2D(60 * 3, 60 * 0),  // bqPos
                new Vector2D(60 * 2, 60 * 0),  // bblPos
                new Vector2D(60 * 1, 60 * 0),  // bhlPos
                new Vector2D(60 * 0, 60 * 0),  // btlPos
                new Vector2D(60 * 5, 60 * 0),  // bbrPos
                new Vector2D(60 * 6, 60 * 0),  // bhrPos
                new Vector2D(60 * 7, 60 * 0),  // btrPos
                new Vector2D(60 * 0, 60 * 1),  // bpPos[0]
                new Vector2D(60 * 1, 60 * 1),  // bpPos[1]
                new Vector2D(60 * 2, 60 * 1),  // bpPos[2]
                new Vector2D(60 * 3, 60 * 1),  // bpPos[3]
                new Vector2D(60 * 4, 60 * 1),  // bpPos[4]
                new Vector2D(60 * 5, 60 * 1),  // bpPos[5]
                new Vector2D(60 * 6, 60 * 1),  // bpPos[6]
                new Vector2D(60 * 7, 60 * 1)   // bpPos[7]
            };

            int[][] posicionesDelTableroAux = {
                    {20, 24, -1, -1, -1, -1, 8, 4}, // Primera fila
                    {19, 25, -1, -1, -1, -1, 9, 3}, // Segunda fila
                    {18, 26, -1, -1, -1, -1, 10, 2}, // Tercera fila
                    {17, 27, -1, -1, -1, -1, 11, 1}, // Cuarta fila
                    {16, 28, -1, -1, -1, -1, 12, 0}, // Quinta fila
                    {21, 29, -1, -1, -1, -1, 13, 5}, // Sexta fila
                    {22, 30, -1, -1, -1, -1, 14, 6}, // Séptima fila
                    {23, 31, -1, -1, -1, -1, 15, 7}  // Octava fila
            };

            System.arraycopy(allPositions, 0, piecePosition, 0, allPositions.length);

            for (int i = 0; i < 8; i++) {
                System.arraycopy(posicionesDelTableroAux[i], 0, posicionesDelTablero[i], 0, 8);
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
            		if(allowedCellsBool[i][j]) {
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
            		if(allowedCellsBool[i][j]) {
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
	
	public int piece(int x, int y) {
    	
        for (int i = 0; i < piecePosition.length; i++) {
        	
            Vector2D vec = piecePosition[i];
            /*
            System.out.println("i: "+i);
            System.out.println("vecX: "+vec.getX()+"x: "+x);
            System.out.println("vecY: "+vec.getY()+"y: "+y);
            */
            if ( vec != null && x > vec.getX() && x < vec.getX() + 60 && y > vec.getY() && y < vec.getY() + 60) {
                //System.out.println("pieceNumbers["+i+"]: "+pieceNumbers[i]);
            	return i;
            }
        }
        
        return -1; // Devuelve -1 si no se encuentra ninguna pieza en las coordenadas especificadas
    }

	public Vector2D getCell(int pieceId) {
		if(pieceId != -1) {
			return piecePosition[pieceId];
		}
		return null;
	}
	
}


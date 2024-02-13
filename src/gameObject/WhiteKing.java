package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhiteKing extends MovingObject {
	
	private static final int id = Constants.wkId;
	private boolean firstMove = true;
	private boolean lastMoveWasFirstMove = false;

	public WhiteKing(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState);
	}

	@Override
	public void update() {
		
		//posicion.setX(Constants.wkId);
		//posicion.setY(Constants.wkId);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.wk && Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(Mouse.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = Mouse.originalPos;
			Cell.calcAllowedCells(originalPos, Constants.wkId, firstMove, gameState);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.lastPiece == Constants.wkId && Mouse.mouseRealesed) {
				boolean valida;
				int newX = Cell.getZ(Mouse.mouseXOnApp);
				int newY = Cell.getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, Constants.wkId, Constants.WHITESTART) && ObjectPosition.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					valida = true;
					ObjectPosition.posicionesDelTablero[Cell.getZ((int)Mouse.oriPosX)][Cell.getZ((int)Mouse.oriPosY)] = -1;
					int pieceOnCellId = ObjectPosition.posicionesDelTablero[newX][newY];
					if(pieceOnCellId >= 16 && pieceOnCellId <= 31) {
						System.out.println("COLISION CON PIEZA NEGRA: "+pieceOnCellId);
						gameState.getMovingObject(pieceOnCellId).destroy();
					}
					ObjectPosition.posicionesDelTablero[newX][newY] = Constants.wkId;
					posicion.setX(Cell.getFromCell(Mouse.mouseXOnApp));
					posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
					if(firstMove && Cell.getZ((int)posicion.getX()) == 6) {
						((WhiteTowerRight)gameState.getMovingObject(7)).enroque();
					} else {
						if(firstMove && Cell.getZ((int)posicion.getX()) == 2) {
							((WhiteTowerLeft)gameState.getMovingObject(4)).enroque();
						}
					}
					ObjectPosition.piecePosition[Constants.wkId] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);
					
				} else {
					valida = false;
					if(Mouse.originalPos != null) {
						posicion.setX(Mouse.originalPos.getX());
						posicion.setY(Mouse.originalPos.getY());
					}
				}
				Mouse.mouseRealesed = false;
				Vector2D originalPos = Mouse.originalPos;
				Cell.deAllowCells(originalPos, Constants.wkId, firstMove, gameState);
				if(valida && firstMove) {
					lastMoveWasFirstMove = true;
					firstMove = false;
				} else {
					lastMoveWasFirstMove = false;
				}
			}
		}
	    
	}



	@Override
	public void draw(Graphics g) {
		g.drawImage(textura, (int)posicion.getX(), (int)posicion.getY(), null);
	}

	@Override
	public void destroy() {
			super.destroy();
			ObjectPosition.piecePosition[id] = null;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public boolean isFirstMove() {
		return lastMoveWasFirstMove;
	}
	
	

}

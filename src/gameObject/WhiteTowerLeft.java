package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhiteTowerLeft extends MovingObject {
	
	private static final int id = Constants.wtlId;
	private boolean firstMove = true;
	private boolean lastMoveWasFirstMove = false;

	public WhiteTowerLeft(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState);
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.wtl && Mouse.mousePressed && gameState.whiteTurn) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(Mouse.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = Mouse.originalPos;
			Cell.calcAllowedCells(originalPos, Constants.wtlId, firstMove, gameState);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.lastPiece == Constants.wtlId && Mouse.mouseRealesed && gameState.whiteTurn) {
				boolean valida;
				int newX = Cell.getZ(Mouse.mouseXOnApp);
				int newY = Cell.getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, Constants.wtlId, Constants.WHITESTART, gameState) && gameState.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					valida = true;
					gameState.posicionesDelTablero[Cell.getZ((int)Mouse.oriPosX)][Cell.getZ((int)Mouse.oriPosY)] = -1;
					int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
					System.out.println("x e y: "+pieceOnCellId);
					if(pieceOnCellId >= 16 && pieceOnCellId <= 31) {
						System.out.println("COLISION CON PIEZA NEGRA: "+pieceOnCellId);
						gameState.getMovingObject(pieceOnCellId).destroy();
					}
					gameState.posicionesDelTablero[newX][newY] = Constants.wtlId;
					posicion.setX(Cell.getFromCell(Mouse.mouseXOnApp));
					posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
					gameState.piecePosition[Constants.wtlId] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);
					
				} else {
					valida = false;
					if(Mouse.originalPos != null) {
						posicion.setX(Mouse.originalPos.getX());
						posicion.setY(Mouse.originalPos.getY());
					}
				}
				Mouse.mouseRealesed = false;
				Vector2D originalPos = Mouse.originalPos;
				Cell.deAllowCells(originalPos, Constants.wtlId, firstMove, gameState);
				if(valida) {
					gameState.nextTurn();
					if(firstMove) {
						lastMoveWasFirstMove = true;
						firstMove = false;
					} else {
						lastMoveWasFirstMove = false;
					}
				}
				//System.out.println("lastMoveWasFirstMove = "+lastMoveWasFirstMove);
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
			gameState.piecePosition[id] = null;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public boolean isFirstMove() {
		return lastMoveWasFirstMove;
	}

	public void enroque() {
		
		gameState.posicionesDelTablero[Cell.getZ((int)posicion.getX())][Cell.getZ((int)posicion.getY())] = -1;
		gameState.posicionesDelTablero[3][7] = Constants.wtlId;
		posicion.setX(Cell.getFromCell(210));
		//posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
		gameState.piecePosition[Constants.wtlId] = new Vector2D(3*Constants.CELLSIZE, 7*Constants.CELLSIZE);
		firstMove = false;
		lastMoveWasFirstMove = true;
	}

	public boolean getFirstMove() {
		return firstMove;
	}
	
	

}

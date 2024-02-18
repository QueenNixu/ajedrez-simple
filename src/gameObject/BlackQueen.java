package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackQueen extends MovingObject {
	
	private static final int id = Constants.bqId;

	public BlackQueen(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState);
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(MouseForWindow.bq && MouseForWindow.mousePressed && gameState.blackTurn) {
			//System.out.println("UWU");
			posicion.setX(MouseForWindow.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(MouseForWindow.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = MouseForWindow.originalPos;
			Cell.calcAllowedCells(originalPos, Constants.bqId, false, gameState, -1);
			//System.out.println("uwu -1");
			
		} else {
			if(MouseForWindow.lastPiece == Constants.bqId && MouseForWindow.mouseRealesed && gameState.blackTurn) {
				int newX = Cell.getZ(MouseForWindow.mouseXOnApp);
				int newY = Cell.getZ(MouseForWindow.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, Constants.bqId, Constants.BLACKSTART, gameState) && gameState.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					gameState.posicionesDelTablero[Cell.getZ((int)MouseForWindow.oriPosX)][Cell.getZ((int)MouseForWindow.oriPosY)] = -1;
					int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
					if(pieceOnCellId >= 0 && pieceOnCellId <= 15) {
						System.out.println("COLISION CON PIEZA BLANCA: "+pieceOnCellId);
						gameState.getMovingObject(pieceOnCellId).destroy();
					}
					gameState.posicionesDelTablero[newX][newY] = Constants.bqId;
					posicion.setX(Cell.getFromCell(MouseForWindow.mouseXOnApp));
					posicion.setY(Cell.getFromCell(MouseForWindow.mouseYOnApp));
					gameState.piecePosition[Constants.bqId] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);

					gameState.nextTurn();
						
				} else {
					if(MouseForWindow.originalPos != null) {
						posicion.setX(MouseForWindow.originalPos.getX());
						posicion.setY(MouseForWindow.originalPos.getY());
					}
				}
				
				MouseForWindow.mouseRealesed = false;
				Vector2D originalPos = MouseForWindow.originalPos;
				Cell.deAllowCells(originalPos, Constants.bqId, false, gameState, -1);
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
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import input.Mouse;
import math.Cell;
import math.Vector2D;
import states.GameState;

public class Horse extends MovingObject {
	
	private int id;
	
	public Horse(Vector2D position, BufferedImage texture, GameState gameState, int id) {
		super(position, texture, gameState);
		this.id = id;
	}

	public void update() {
		if(Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(Mouse.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = Mouse.originalPos;
			Cell.calcAllowedCells(originalPos, id, false, gameState);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.mouseRealesed) {
				int newX = Cell.getZ(Mouse.mouseXOnApp);
				int newY = Cell.getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, id, ((id < 16) ? Constants.WHITESTART : Constants.BLACKSTART), gameState) && gameState.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					gameState.posicionesDelTablero[Cell.getZ((int)Mouse.oriPosX)][Cell.getZ((int)Mouse.oriPosY)] = -1;
					// llamar a object collision modificado para destruir enemigo
					int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
					
					if ((id < 16 && pieceOnCellId >= 16 && pieceOnCellId <= 31) || (id >= 16 && pieceOnCellId >= 0 && pieceOnCellId <= 15)) {
	                    String mensaje = (id < 16) ? "COLISION CON PIEZA NEGRA: " : "COLISION CON PIEZA BLANCA: ";
	                    System.out.println(mensaje + pieceOnCellId);
	                    gameState.getMovingObject(pieceOnCellId).destroy();
	                }
					gameState.posicionesDelTablero[newX][newY] = id;
					posicion.setX(Cell.getFromCell(Mouse.mouseXOnApp));
					posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
					gameState.piecePosition[id] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);
					gameState.nextTurn();
				} else {
					if(Mouse.originalPos != null) {
						posicion.setX(Mouse.originalPos.getX());
						posicion.setY(Mouse.originalPos.getY());
					}
				}
				Mouse.mouseRealesed = false;
				Vector2D originalPos = Mouse.originalPos;
				Cell.deAllowCells(originalPos, id, false, gameState);
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

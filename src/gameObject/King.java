package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import input.Mouse;
import math.Cell;
import math.Vector2D;
import states.GameState;

public class King extends MovingObject {
	
	private int id;
	private boolean firstMove = true;
	private boolean lastMoveWasFirstMove = false;
	
	public King(Vector2D position, BufferedImage texture, GameState gameState, int id) {
		super(position, texture, gameState);
		this.id = id;
	}

	@Override
	public void update() {
		
		//posicion.setX(id);
		//posicion.setY(id);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(Mouse.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = Mouse.originalPos;
			Cell.calcAllowedCells(originalPos, id, firstMove, gameState);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.mouseRealesed) {
				boolean valida;
				int newX = Cell.getZ(Mouse.mouseXOnApp);
				int newY = Cell.getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, id, ((id < 16) ? Constants.WHITESTART : Constants.BLACKSTART), gameState) && gameState.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					valida = true;
					gameState.posicionesDelTablero[Cell.getZ((int)Mouse.oriPosX)][Cell.getZ((int)Mouse.oriPosY)] = -1;
					int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
					if ((id < 16 && pieceOnCellId >= 16 && pieceOnCellId <= 31) || (id >= 16 && pieceOnCellId >= 0 && pieceOnCellId <= 15)) {
	                    String mensaje = (id < 16) ? "COLISION CON PIEZA NEGRA: " : "COLISION CON PIEZA BLANCA: ";
	                    System.out.println(mensaje + pieceOnCellId);
	                    gameState.getMovingObject(pieceOnCellId).destroy();
	                }
					gameState.posicionesDelTablero[newX][newY] = id;
					posicion.setX(Cell.getFromCell(Mouse.mouseXOnApp));
					posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
					if(firstMove && Cell.getZ((int)posicion.getX()) == 6) {
						((Tower)gameState.getMovingObject(((id < 16) ? 7 : 23))).enroque(id);
					} else {
						if(firstMove && Cell.getZ((int)posicion.getX()) == 2) {
							((Tower)gameState.getMovingObject(((id < 16) ? 4 : 20))).enroque(id);
						}
					}
					gameState.piecePosition[id] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);
					
				} else {
					valida = false;
					if(Mouse.originalPos != null) {
						posicion.setX(Mouse.originalPos.getX());
						posicion.setY(Mouse.originalPos.getY());
					}
				}
				Mouse.mouseRealesed = false;
				Vector2D originalPos = Mouse.originalPos;
				Cell.deAllowCells(originalPos, id, firstMove, gameState);
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
		gameState.posicionesDelTablero[5][7] = Constants.wtrId;
		posicion.setX(Cell.getFromCell(330));
		//posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
		gameState.piecePosition[Constants.wtrId] = new Vector2D(5*Constants.CELLSIZE, 7*Constants.CELLSIZE);
		firstMove = false;
		lastMoveWasFirstMove = true;
	}
	
	public boolean getFirstMove() {
		return firstMove;
	}

}

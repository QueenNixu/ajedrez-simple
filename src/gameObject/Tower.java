package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import input.MouseForWindow;
import math.Cell;
import math.Vector2D;
import states.GameState;

public class Tower extends MovingObject {
	
	private int id;
	private boolean firstMove = true;
	private boolean lastMoveWasFirstMove = false;
	
	public Tower(Vector2D position, BufferedImage texture, GameState gameState, int id) {
		super(position, texture, gameState);
		this.id = id;
	}

	public void update() {
		if(MouseForWindow.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(MouseForWindow.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(MouseForWindow.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = MouseForWindow.originalPos;
			Cell.calcAllowedCells(originalPos, id, firstMove, gameState, -1);
			//System.out.println("uwu -1");
			
		} else {
			if(MouseForWindow.mouseRealesed) {
				boolean valida;
				int newX = Cell.getZ(MouseForWindow.mouseXOnApp);
				int newY = Cell.getZ(MouseForWindow.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, id, ((id < 16) ? Constants.WHITESTART : Constants.BLACKSTART), gameState) && gameState.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					valida = true;
					gameState.posicionesDelTablero[Cell.getZ((int)MouseForWindow.oriPosX)][Cell.getZ((int)MouseForWindow.oriPosY)] = -1;
					int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
					if ((id < 16 && pieceOnCellId >= 16 && pieceOnCellId <= 31) || (id >= 16 && pieceOnCellId >= 0 && pieceOnCellId <= 15)) {
	                    String mensaje = (id < 16) ? "COLISION CON PIEZA NEGRA: " : "COLISION CON PIEZA BLANCA: ";
	                    System.out.println(mensaje + pieceOnCellId);
	                    gameState.getMovingObject(pieceOnCellId).destroy();
	                }
					gameState.posicionesDelTablero[newX][newY] = id;
					posicion.setX(Cell.getFromCell(MouseForWindow.mouseXOnApp));
					posicion.setY(Cell.getFromCell(MouseForWindow.mouseYOnApp));
					gameState.piecePosition[id] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);
					
				} else {
					valida = false;
					if(MouseForWindow.originalPos != null) {
						posicion.setX(MouseForWindow.originalPos.getX());
						posicion.setY(MouseForWindow.originalPos.getY());
					}
				}
				MouseForWindow.mouseRealesed = false;
				Vector2D originalPos = MouseForWindow.originalPos;
				Cell.deAllowCells(originalPos, id, firstMove, gameState, -1);
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
	
	public void enroque(int id) {
		
		gameState.posicionesDelTablero[Cell.getZ((int)posicion.getX())][Cell.getZ((int)posicion.getY())] = -1;
		if(id == 0) {
			System.out.println("REy BLanco");
			if(this.id == 7) {
				gameState.posicionesDelTablero[5][7] = this.id;
				posicion.setX(Cell.getFromCell(300));
				gameState.piecePosition[this.id] = new Vector2D(5*Constants.CELLSIZE, 7*Constants.CELLSIZE);
			} else {
				gameState.posicionesDelTablero[3][7] = this.id;
				posicion.setX(Cell.getFromCell(180));
				gameState.piecePosition[this.id] = new Vector2D(3*Constants.CELLSIZE, 7*Constants.CELLSIZE);
			}
		} else {
			System.out.println("REy Negro");
			if(this.id == 23) {
				gameState.posicionesDelTablero[5][1] = this.id;
				posicion.setX(Cell.getFromCell(300));
				gameState.piecePosition[this.id] = new Vector2D(5*Constants.CELLSIZE, 1*Constants.CELLSIZE);
			} else {
				gameState.posicionesDelTablero[3][1] = this.id;
				posicion.setX(Cell.getFromCell(180));
				gameState.piecePosition[this.id] = new Vector2D(3*Constants.CELLSIZE, 1*Constants.CELLSIZE);
			}
		}
		firstMove = false;
		lastMoveWasFirstMove = true;
	}
	
	public boolean getFirstMove() {
		return firstMove;
	}
	
	@Override
	public void iniciarPos() {
		posicion.setX(gameState.getDefaultPos(id).getX());
		posicion.setY(gameState.getDefaultPos(id).getY());
	}
	
}

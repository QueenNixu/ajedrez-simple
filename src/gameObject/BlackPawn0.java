package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackPawn0 extends MovingObject {
	
	private static final int id = Constants.bp0Id;

	public BlackPawn0(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState);
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.bp0 && Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - Constants.CELLSIZE/2);
			posicion.setY(Mouse.mouseYOnApp - Constants.CELLSIZE/2);
			Vector2D originalPos = Mouse.originalPos;
			Cell.calcAllowedCells(originalPos, Constants.bp0Id);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.lastPiece == Constants.bp0Id && Mouse.mouseRealesed) {
				int newX = Cell.getZ(Mouse.mouseXOnApp);
				int newY = Cell.getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, Constants.bp0Id, Constants.BLACKSTART) && ObjectPosition.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					ObjectPosition.posicionesDelTablero[Cell.getZ((int)Mouse.oriPosX)][Cell.getZ((int)Mouse.oriPosY)] = -1;
					int pieceOnCellId = ObjectPosition.posicionesDelTablero[newX][newY];
					if(pieceOnCellId >= 0 && pieceOnCellId <= 15) {
						System.out.println("COLISION CON PIEZA BLANCA: "+pieceOnCellId);
						gameState.getMovingObject(pieceOnCellId).destroy();
					}
					ObjectPosition.posicionesDelTablero[newX][newY] = Constants.bp0Id;
					posicion.setX(Cell.getFromCell(Mouse.mouseXOnApp));
					posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
					ObjectPosition.piecePosition[Constants.bp0Id] = new Vector2D(newX*Constants.CELLSIZE, newY*Constants.CELLSIZE);
					
				} else {
					if(Mouse.originalPos != null) {
						posicion.setX(Mouse.originalPos.getX());
						posicion.setY(Mouse.originalPos.getY());
					}
				}
				Mouse.mouseRealesed = false;
				Vector2D originalPos = Mouse.originalPos;
				Cell.deAllowCells(originalPos, Constants.bp0Id);
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
	
	

}

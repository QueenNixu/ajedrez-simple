package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import input.MouseForWindow;
import main.VentanaCoronar;
import math.Cell;
import math.Vector2D;
import states.GameState;

public class Pawn extends MovingObject {
	
	private int id;
	private int idCoronado = -1;
	private boolean firstMove = true;
	private boolean lastMoveWasFirstMove = false;
	
	private int firstMoveTurn = -1;
	private boolean coronado = false;
	
	private boolean ventanaCoronarAbierta = false;

	public Pawn(Vector2D position, BufferedImage texture, GameState gameState, int id) {
		super(position, texture, gameState);
		this.id = id;
	}

	public void update() {
	    if(MouseForWindow.mousePressed) {
	        posicion.setX(MouseForWindow.mouseXOnApp - Constants.CELLSIZE/2);
	        posicion.setY(MouseForWindow.mouseYOnApp - Constants.CELLSIZE/2);
	        Vector2D originalPos = MouseForWindow.originalPos;
	        
	        Cell.calcAllowedCells(originalPos, id, firstMove, gameState, idCoronado);
	        
	        //((idCoronado != -1) ? idCoronado : id
	    } else {
	        if(MouseForWindow.mouseRealesed) {
	            boolean valida;
	            int newX = Cell.getZ(MouseForWindow.mouseXOnApp);
	            int newY = Cell.getZ(MouseForWindow.mouseYOnApp);
	            if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, id, ((id < 16) ? Constants.WHITESTART : Constants.BLACKSTART), gameState) && gameState.allowedCellsBool[newX][newY] ) {
	                //System.out.println("Valida");
	                valida = true;
	                gameState.posicionesDelTablero[Cell.getZ((int)MouseForWindow.oriPosX)][Cell.getZ((int)MouseForWindow.oriPosY)] = -1;
	                int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
	                if ((id < 16 && pieceOnCellId >= 16 && pieceOnCellId <= 31) || (id >= 16 && pieceOnCellId >= 0 && pieceOnCellId <= 15)) {
	                    //String mensaje = (id < 16) ? "COLISION CON PIEZA NEGRA: " : "COLISION CON PIEZA BLANCA: ";
	                    //System.out.println(mensaje + pieceOnCellId);
	                    gameState.getMovingObject(pieceOnCellId).destroy();
	                }

	                gameState.posicionesDelTablero[newX][newY] = id;
	                posicion.setX(Cell.getFromCell(MouseForWindow.mouseXOnApp));
	                posicion.setY(Cell.getFromCell(MouseForWindow.mouseYOnApp));
	                
	                if(Cell.getZ( (int) posicion.getY()) == ((id < 16) ? 0 : 7) && !coronado ) {
	                	System.out.println("CORONAR!");
	                	coronado = true;
	                	//VentanaCoronar ventanaCoronar = new VentanaCoronar(gameState.window);
	                }
	                
	                if(idCoronado == -1) {
	                	pieceOnCellId = gameState.posicionesDelTablero[Cell.getZ((int)posicion.getX())][Cell.getZ((int)posicion.getY()) + ((id < 16) ? 1 : -1)];
		                int lowPawnPiece = (id < 16) ? 24 : 8;
		                int highPawnPiece = (id < 16) ? 31 : 15;
		                if(pieceOnCellId >= lowPawnPiece && pieceOnCellId <= highPawnPiece) {
		                   // System.out.println("pieceOnCellId: " + pieceOnCellId);
		                    MovingObject piece = gameState.getMovingObject(pieceOnCellId);
		                    if(piece.isFirstMove()) {
		                        //System.out.println("fue su primer movimiento? " + piece.isFirstMove());
		                        gameState.posicionesDelTablero[Cell.getZ((int)posicion.getX())][Cell.getZ((int)posicion.getY()) + ((id < 16) ? 1 : -1)] = -1;
		                        piece.destroy();
		                    }
		                }
	                }
	                
	                gameState.piecePosition[id] = new Vector2D(newX * Constants.CELLSIZE, newY * Constants.CELLSIZE);
	            } else {
	                valida = false;
	                if(MouseForWindow.originalPos != null) {
	                    posicion.setX(MouseForWindow.originalPos.getX());
	                    posicion.setY(MouseForWindow.originalPos.getY());
	                }
	            }
	            MouseForWindow.mouseRealesed = false;
	            Vector2D originalPos = MouseForWindow.originalPos;
	            
	            Cell.cellsDeallowed = false;
	            Cell.deAllowCells(originalPos, id, firstMove, gameState, idCoronado);
	            
	            while(!Cell.cellsDeallowed && !coronado) {
            		try {
            	        Thread.sleep(100);
            	        System.out.println("LIMPIANDO");
            	    } catch (InterruptedException e) {
            	        e.printStackTrace();
            	    }
            	}
	            
	            if (coronado && idCoronado == -1) {
	            	VentanaCoronar ventanaCoronar = new VentanaCoronar(gameState.window, this);
	            	gameState.window.pause();
	            }
	            
	            if(valida) {
	            	//System.out.println("PASANDO AL SIGUIENTE TURNO");
	                gameState.nextTurn();
	                if(firstMove) {
	                    firstMove = false;
	                    int reach = (id < 16) ? 4 : 3;
	                    if(Cell.getZ((int) posicion.getY()) == reach) {
	                        //System.out.println("Se movio dos casilas");
	                        firstMoveTurn = gameState.turn;
	                        lastMoveWasFirstMove = true;
	                    }
	                } else {
	                    lastMoveWasFirstMove = false;
	                }
	            }
	            //System.out.println("lastMoveWasFirstMove = "+lastMoveWasFirstMove);
	        }
	    }
	    
	}
	
	public void updateTurn() {
		if (gameState.turn > firstMoveTurn+1) {
	        lastMoveWasFirstMove = false;
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
	
	public int getIdCoronado() {
		return idCoronado;
	}

	public void setIdCoronado(int idCoronado) {
		this.idCoronado = idCoronado;
	}
	
	public boolean isVentanaCoronarAbierta() {
		return ventanaCoronarAbierta;
	}

	public void setVentanaCoronarAbierta(boolean ventanaCoronarAbierta) {
		this.ventanaCoronarAbierta = ventanaCoronarAbierta;
	}

}

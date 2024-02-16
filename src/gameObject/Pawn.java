package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import input.Mouse;
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
	
	public Pawn(Vector2D position, BufferedImage texture, GameState gameState, int id) {
		super(position, texture, gameState);
		this.id = id;
	}

	public void update() {
	    if(Mouse.mousePressed) {
	        posicion.setX(Mouse.mouseXOnApp - Constants.CELLSIZE/2);
	        posicion.setY(Mouse.mouseYOnApp - Constants.CELLSIZE/2);
	        Vector2D originalPos = Mouse.originalPos;
	        
	        Cell.calcAllowedCells(originalPos, id, firstMove, gameState, idCoronado);
	        
	        //((idCoronado != -1) ? idCoronado : id
	    } else {
	        if(Mouse.mouseRealesed) {
	            boolean valida;
	            int newX = Cell.getZ(Mouse.mouseXOnApp);
	            int newY = Cell.getZ(Mouse.mouseYOnApp);
	            if(newX >= 0 && newY >= 0 && !Cell.allyCell(newX, newY, id, ((id < 16) ? Constants.WHITESTART : Constants.BLACKSTART), gameState) && gameState.allowedCellsBool[newX][newY] ) {
	                //System.out.println("Valida");
	                valida = true;
	                gameState.posicionesDelTablero[Cell.getZ((int)Mouse.oriPosX)][Cell.getZ((int)Mouse.oriPosY)] = -1;
	                int pieceOnCellId = gameState.posicionesDelTablero[newX][newY];
	                if ((id < 16 && pieceOnCellId >= 16 && pieceOnCellId <= 31) || (id >= 16 && pieceOnCellId >= 0 && pieceOnCellId <= 15)) {
	                    //String mensaje = (id < 16) ? "COLISION CON PIEZA NEGRA: " : "COLISION CON PIEZA BLANCA: ";
	                    //System.out.println(mensaje + pieceOnCellId);
	                    gameState.getMovingObject(pieceOnCellId).destroy();
	                }

	                gameState.posicionesDelTablero[newX][newY] = id;
	                posicion.setX(Cell.getFromCell(Mouse.mouseXOnApp));
	                posicion.setY(Cell.getFromCell(Mouse.mouseYOnApp));
	                
	                if(Cell.getZ( (int) posicion.getY()) == ((id < 16) ? 0 : 7) && !coronado ) {
	                	System.out.println("CORONAR!");
	                	coronado = true;
	                	//VentanaCoronar ventanaCoronar = new VentanaCoronar(gameState.window);
	                }
	                
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
	                gameState.piecePosition[id] = new Vector2D(newX * Constants.CELLSIZE, newY * Constants.CELLSIZE);
	            } else {
	                valida = false;
	                if(Mouse.originalPos != null) {
	                    posicion.setX(Mouse.originalPos.getX());
	                    posicion.setY(Mouse.originalPos.getY());
	                }
	            }
	            Mouse.mouseRealesed = false;
	            Vector2D originalPos = Mouse.originalPos;
	            
	            Cell.deAllowCells(originalPos, id, firstMove, gameState, idCoronado);
	            
	            if(valida) {
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
	            if (coronado && idCoronado == -1) {
	            	Scanner scanner = new Scanner(System.in); // Crear el Scanner fuera del condicional

	                if (id < 16) {
	                    int numeroElegido;

	                    do {
	                        System.out.print("Por favor, ingresa qué pieza quieres (1, 2, 3 o 4): ");
	                        numeroElegido = scanner.nextInt();
	                        if (numeroElegido < 1 || numeroElegido > 4) {
	                            System.out.println("Por favor, ingresa un número válido (1, 2, 3 o 4).");
	                        }
	                    } while (numeroElegido < 1 || numeroElegido > 4);

	                    idCoronado = numeroElegido;
	                } else {
	                    int numeroElegido;

	                    do {
	                        System.out.print("Por favor, ingresa qué pieza quieres (17, 18, 19 o 20): ");
	                        numeroElegido = scanner.nextInt();
	                        if (numeroElegido < 17 || numeroElegido > 20) {
	                            System.out.println("Por favor, ingresa un número válido (17, 18, 19 o 20).");
	                        }
	                    } while (numeroElegido < 17 || numeroElegido > 20);

	                    idCoronado = numeroElegido;
	                }

	                // Cerrar el objeto Scanner después de haber terminado de usarlo
	                //scanner.close();
	            	
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

}

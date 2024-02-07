package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Vector2D;

public class WhiteHorseRight extends GameObject {
	
	private Vector2D oriPos;

	public WhiteHorseRight(Vector2D posicion, BufferedImage textura) {
		super(posicion, textura);
		oriPos = posicion;
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.whr && Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - 60/2);
			posicion.setY(Mouse.mouseYOnApp - 60/2);
			Vector2D originalPos = Mouse.originalPos;
			calcAllowedCells(originalPos);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.lastPiece == 6 && Mouse.mouseRealesed) {
				int newX = getZ(Mouse.mouseXOnApp);
				int newY = getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !allyCell(newX, newY) && ObjectPosition.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					
					ObjectPosition.posicionesDelTablero[getZ((int)Mouse.oriPosX)][getZ((int)Mouse.oriPosY)] = -1;
					ObjectPosition.posicionesDelTablero[newX][newY] = 6;
					
					//ObjectPosition.posicionesDelTablero[getZ((int)posicion.getX())][getZ((int)posicion.getY())] = -1;
					/*
					System.out.println("posicion.getX(): "+oriPos.getX());
					System.out.println("posicion.getY(): "+oriPos.getY());
					System.out.println("getZ((int)posicion.getX()): "+getZ((int)oriPos.getX()));
					System.out.println("getZ((int)posicion.getY()): "+getZ((int)oriPos.getY()));
					*/
					
					posicion.setX(getFromCell(Mouse.mouseXOnApp));
					posicion.setY(getFromCell(Mouse.mouseYOnApp));
					ObjectPosition.piecePosition[6] = new Vector2D(newX*60, newY*60);
					
				} else {
					if(Mouse.originalPos != null) {
						posicion.setX(Mouse.originalPos.getX());
						posicion.setY(Mouse.originalPos.getY());
					}
				}
				Mouse.mouseRealesed = false;
				Vector2D originalPos = Mouse.originalPos;
				deallowCells(originalPos);
			}
		}
	    
	}

	private int getFromCell(int originalPos) {
		if(originalPos >= 0 && originalPos < 60) {
			return 0;
		}
		if(originalPos >= 60 && originalPos < 120) {
			return 60;
		}
		if(originalPos >= 120 && originalPos < 180) {
			return 120;
		}
		if(originalPos >= 180 && originalPos < 240) {
			return 180;
		}
		if(originalPos >= 240 && originalPos < 300) {
			return 240;
		}
		if(originalPos >= 300 && originalPos < 360) {
			return 300;
		}
		if(originalPos >= 360 && originalPos < 420) {
			return 360;
		}
		if(originalPos >= 420 && originalPos < 480) {
			return 420;
		}
		return -1;
	}

	private void deallowCells(Vector2D originalPos) {
		
		int i = getI(originalPos);
		int j = getJ(originalPos);
		
		//System.out.println(i);
		//System.out.println(j);
		
		if (i - 1 >= 0 && j - 2 >= 0) {
			ObjectPosition.allowedCellsBool[i - 1][j - 2] = false;
		}

		if (i + 1 <= 7 && j - 2 >= 0) {
		    ObjectPosition.allowedCellsBool[i + 1][j - 2] = false;
		}

		if (i - 2 >= 0 && j - 1 >= 0) {
		    ObjectPosition.allowedCellsBool[i - 2][j - 1] = false;
		}

		if (i - 2 >= 0 && j + 1 <= 7) {
		    ObjectPosition.allowedCellsBool[i - 2][j + 1] = false;
		}

		if (i - 1 >= 0 && j + 2 <= 7) {
		    ObjectPosition.allowedCellsBool[i - 1][j + 2] = false;
		}

		if (i + 1 <= 7 && j + 2 <= 7) {
		    ObjectPosition.allowedCellsBool[i + 1][j + 2] = false;
		}

		if (i + 2 <= 7 && j - 1 >= 0) {
		    ObjectPosition.allowedCellsBool[i + 2][j - 1] = false;
		}

		if (i + 2 <= 7 && j + 1 <= 7) {
		    ObjectPosition.allowedCellsBool[i + 2][j + 1] = false;
		}
		
	}

	private void calcAllowedCells(Vector2D originalPos) {
		
		int i = getI(originalPos);
		int j = getJ(originalPos);
		
		//System.out.println(i);
		//System.out.println(j);
		
		if (i - 1 >= 0 && j - 2 >= 0 && !allyCell(i-1,j-2)) {
			ObjectPosition.allowedCellsBool[i - 1][j - 2] = true;
		}

		if (i + 1 <= 7 && j - 2 >= 0 && !allyCell(i+1,j-2)) {
		    ObjectPosition.allowedCellsBool[i + 1][j - 2] = true;
		}

		if (i - 2 >= 0 && j - 1 >= 0 && !allyCell(i-2,j-1)) {
		    ObjectPosition.allowedCellsBool[i - 2][j - 1] = true;
		}

		if (i - 2 >= 0 && j + 1 <= 7 && !allyCell(i-2,j+1)) {
		    ObjectPosition.allowedCellsBool[i - 2][j + 1] = true;
		}

		if (i - 1 >= 0 && j + 2 <= 7 && !allyCell(i-1,j+2)) {
		    ObjectPosition.allowedCellsBool[i - 1][j + 2] = true;
		}

		if (i + 1 <= 7 && j + 2 <= 7 && !allyCell(i+1,j+2)) {
		    ObjectPosition.allowedCellsBool[i + 1][j + 2] = true;
		}

		if (i + 2 <= 7 && j - 1 >= 0 && !allyCell(i+2,j-1)) {
		    ObjectPosition.allowedCellsBool[i + 2][j - 1] = true;
		}

		if (i + 2 <= 7 && j + 1 <= 7 && !allyCell(i+2,j+1)) {
		    ObjectPosition.allowedCellsBool[i + 2][j + 1] = true;
		}

		
	}

	private boolean allyCell(int i, int j) {
		
		//System.out.println("ObjectPosition.posicionesDelTablero["+i+"]["+j+"]: "+ObjectPosition.posicionesDelTablero[i][j]);
		
		if(ObjectPosition.posicionesDelTablero[i][j] == 0) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 1) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 2) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 3) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 4) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 5) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 6) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 7) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 8) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 9) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 10) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 11) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 12) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 13) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 14) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 15) return true;
		
		return false;
	}

	private int getJ(Vector2D originalPos) {
		
		if(originalPos.getY() >= 0 && originalPos.getY() < 60) {
			return 0;
		}
		if(originalPos.getY() >= 60 && originalPos.getY() < 120) {
			return 1;
		}
		if(originalPos.getY() >= 120 && originalPos.getY() < 180) {
			return 2;
		}
		if(originalPos.getY() >= 180 && originalPos.getY() < 240) {
			return 3;
		}
		if(originalPos.getY() >= 240 && originalPos.getY() < 300) {
			return 4;
		}
		if(originalPos.getY() >= 300 && originalPos.getY() < 360) {
			return 5;
		}
		if(originalPos.getY() >= 360 && originalPos.getY() < 420) {
			return 6;
		}
		if(originalPos.getY() >= 420 && originalPos.getY() < 480) {
			return 7;
		}
		return -1;
		
	}
	
	private int getZ(int originalPos) {
		
		if(originalPos >= 0 && originalPos < 60) {
			System.out.println("UWU");
			return 0;
		}
		if(originalPos >= 60 && originalPos < 120) {
			return 1;
		}
		if(originalPos >= 120 && originalPos < 180) {
			return 2;
		}
		if(originalPos >= 180 && originalPos < 240) {
			return 3;
		}
		if(originalPos >= 240 && originalPos < 300) {
			return 4;
		}
		if(originalPos >= 300 && originalPos < 360) {
			return 5;
		}
		if(originalPos >= 360 && originalPos < 420) {
			return 6;
		}
		if(originalPos >= 420 && originalPos < 480) {
			return 7;
		}
		return -1;
		
	}

	private int getI(Vector2D originalPos) {
		
		//System.out.println("originalPos.getX(): "+originalPos.getX());
		
		if(originalPos.getX() >= 0 && originalPos.getX() < 60) {
			return 0;
		}
		if(originalPos.getX() >= 60 && originalPos.getX() < 120) {
			return 1;
		}
		if(originalPos.getX() >= 120 && originalPos.getX() < 180) {
			return 2;
		}
		if(originalPos.getX() >= 180 && originalPos.getX() < 240) {
			return 3;
		}
		if(originalPos.getX() >= 240 && originalPos.getX() < 300) {
			return 4;
		}
		if(originalPos.getX() >= 300 && originalPos.getX() < 360) {
			return 5;
		}
		if(originalPos.getX() >= 360 && originalPos.getX() < 420) {
			return 6;
		}
		if(originalPos.getX() >= 420 && originalPos.getX() < 480) {
			return 7;
		}
		return -1;
	        	
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(textura, (int)posicion.getX(), (int)posicion.getY(), null);
	}
	
	

}

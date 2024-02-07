package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Vector2D;

public class WhitePawn6 extends GameObject {

	public WhitePawn6(Vector2D posicion, BufferedImage textura) {
		super(posicion, textura);
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.wp6 && Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - 60/2);
			posicion.setY(Mouse.mouseYOnApp - 60/2);
			Vector2D originalPos = Mouse.originalPos;
			calcAllowedCells(originalPos);
			//System.out.println("uwu -1");
			
		} else {
			if(Mouse.lastPiece == 14 && Mouse.mouseRealesed) {
				int newX = getZ(Mouse.mouseXOnApp);
				int newY = getZ(Mouse.mouseYOnApp);
				if(newX >= 0 && newY >= 0 && !allyCell(newX, newY) && ObjectPosition.allowedCellsBool[newX][newY] ) {
					System.out.println("Valida");
					ObjectPosition.posicionesDelTablero[getZ((int)Mouse.oriPosX)][getZ((int)Mouse.oriPosY)] = -1;
					posicion.setX(getFromCell(Mouse.mouseXOnApp));
					posicion.setY(getFromCell(Mouse.mouseYOnApp));
					ObjectPosition.piecePosition[14] = new Vector2D(newX*60, newY*60);
					
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
		
		if (j + 1 <= 7) {
			ObjectPosition.allowedCellsBool[i][j - 1] = false;
		}
		
	}

	private void calcAllowedCells(Vector2D originalPos) {
		
		int i = getI(originalPos);
		int j = getJ(originalPos);
		
		//System.out.println(i);
		//System.out.println(j);
		
		if (j+1 <= 7 && !allyCell(i,j+1)) {
			ObjectPosition.allowedCellsBool[i][j - 1] = true;
		}

		
	}

	private boolean allyCell(int i, int j) {
		
		//System.out.println("ObjectPosition.posicionesDelTablero["+i+"]["+j+"]: "+ObjectPosition.posicionesDelTablero[i][j]);
		
		if(ObjectPosition.posicionesDelTablero[i][j] == 16) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 17) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 18) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 19) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 20) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 21) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 22) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 23) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 24) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 25) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 26) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 27) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 28) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 29) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 30) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == 31) return true;
		
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

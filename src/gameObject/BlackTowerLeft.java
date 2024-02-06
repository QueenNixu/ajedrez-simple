package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Vector2D;

public class BlackTowerLeft extends GameObject {

	public BlackTowerLeft(Vector2D posicion, BufferedImage textura) {
		super(posicion, textura);
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
		if(Mouse.btl && Mouse.mousePressed) {
			//System.out.println("UWU");
			posicion.setX(Mouse.mouseXOnApp - 60/2);
			posicion.setY(Mouse.mouseYOnApp - 60/2);
		} else {
			if(Mouse.lastPiece == 20 && Mouse.mouseRealesed && Mouse.originalPos != null) {
				posicion.setX(Mouse.originalPos.getX());
				posicion.setY(Mouse.originalPos.getY());
				Mouse.mouseRealesed = false;
			}
		}
	    
	}



	@Override
	public void draw(Graphics g) {
		g.drawImage(textura, (int)posicion.getX(), (int)posicion.getY(), null);
	}
	
	

}

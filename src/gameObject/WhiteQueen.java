package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Vector2D;

public class WhiteQueen extends GameObject {

	public WhiteQueen(Vector2D posicion, BufferedImage textura) {
		super(posicion, textura);
	}

	@Override
	public void update() {
		
		//posicion.setX(0);
		//posicion.setY(0);
		
	    // Según la pieza agarrada, permitir y prohibir posiciones
	    
	}



	@Override
	public void draw(Graphics g) {
		g.drawImage(textura, (int)posicion.getX(), (int)posicion.getY(), null);
	}
	
	

}

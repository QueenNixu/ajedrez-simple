package gameObject;

import java.awt.image.BufferedImage;

import java.awt.Graphics;

import math.Vector2D;
import states.GameState;

public class Piece extends MovingObject {
	
	private int id;

	public Piece(Vector2D posicion, BufferedImage textura, GameState gameState, int id) {
		super(posicion, textura, gameState);
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

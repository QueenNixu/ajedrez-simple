package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import math.Vector2D;
import states.GameState;

public class WhiteBishopLeft extends Bishop {
	
	private static final int id = Constants.wblId;

	public WhiteBishopLeft(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}

	@Override
	public void update() {
		if( (MouseForWindow.wbl || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.whiteTurn)) super.update();
	}

}

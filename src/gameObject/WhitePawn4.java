package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import math.Vector2D;
import states.GameState;

public class WhitePawn4 extends Pawn {
	
	private static final int id = Constants.wp4Id;

	public WhitePawn4(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}

	@Override
	public void update() {
		if( (MouseForWindow.wp4 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.whiteTurn)) super.update();
		else super.updateTurn();
	}
}

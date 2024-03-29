package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import math.Vector2D;
import states.GameState;

public class WhitePawn7 extends Pawn {
	
	private static final int id = Constants.wp7Id;

	public WhitePawn7(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}
	@Override
	public void update() {
		if( (MouseForWindow.wp7 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.whiteTurn)) super.update();
		else super.updateTurn();
	}
}

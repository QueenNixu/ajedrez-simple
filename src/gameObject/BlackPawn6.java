package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import math.Vector2D;
import states.GameState;

public class BlackPawn6 extends Pawn {
	
	private static final int id = Constants.bp6Id;

	public BlackPawn6(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}
	@Override
	public void update() {
		if( (MouseForWindow.bp6 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
		else super.updateTurn();
	}
}


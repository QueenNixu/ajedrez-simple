package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import math.Vector2D;
import states.GameState;

public class BlackPawn2 extends Pawn {
	
	private static final int id = Constants.bp2Id;

	public BlackPawn2(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}
	@Override
	public void update() {
		if( (MouseForWindow.bp2 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
		else super.updateTurn();
	}
}

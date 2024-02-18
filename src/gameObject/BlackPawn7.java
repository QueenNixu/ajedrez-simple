package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackPawn7 extends Pawn {
	
	private static final int id = Constants.bp7Id;

	public BlackPawn7(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}
	@Override
	public void update() {
		if( (MouseForWindow.bp7 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
		else super.updateTurn();
	}
}
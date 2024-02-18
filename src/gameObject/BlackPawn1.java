package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackPawn1 extends Pawn {
	
	private static final int id = Constants.bp1Id;

	public BlackPawn1(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}
	@Override
	public void update() {
		if( (MouseForWindow.bp1 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
		else super.updateTurn();
	}
}

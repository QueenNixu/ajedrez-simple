package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhitePawn3 extends Pawn {
	
	private static final int id = Constants.wp3Id;

	public WhitePawn3(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}

	@Override
	public void update() {
		if( (MouseForWindow.wp3 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.whiteTurn)) super.update();
		else super.updateTurn();
	}
}

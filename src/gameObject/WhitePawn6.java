package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhitePawn6 extends Pawn {
	
	private static final int id = Constants.wp6Id;

	public WhitePawn6(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}
	@Override
	public void update() {
		if( (MouseForWindow.wp6 || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.whiteTurn)) super.update();
		else super.updateTurn();
	}
}

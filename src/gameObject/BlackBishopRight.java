package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackBishopRight extends Bishop {

	private static final int id = Constants.bbrId;

	public BlackBishopRight(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}

	@Override
	public void update() {
		if( (Mouse.bbr || Mouse.lastPiece == id) &&
			(Mouse.mousePressed || Mouse.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
	}
}

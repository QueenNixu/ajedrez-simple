package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

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
		if( (MouseForWindow.bbr || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
	}
}

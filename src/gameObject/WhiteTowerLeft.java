package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhiteTowerLeft extends Tower {
	
	private static final int id = Constants.wtlId;

	public WhiteTowerLeft(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}

	@Override
	public void update() {
		if( (MouseForWindow.wtl || MouseForWindow.lastPiece == id) &&
			(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
			(gameState.whiteTurn)) super.update();
	}

}

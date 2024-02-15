package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackTowerLeft extends Tower {
	
	private static final int id = Constants.btlId;

	public BlackTowerLeft(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
	}

	@Override
	public void update() {
		if( (Mouse.btl || Mouse.lastPiece == id) &&
			(Mouse.mousePressed || Mouse.mouseRealesed) &&
			(gameState.blackTurn)) super.update();
	}

}

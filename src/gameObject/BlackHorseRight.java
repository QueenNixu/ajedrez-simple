package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class BlackHorseRight extends Horse {
	
	private static final int id = Constants.bhrId;

	public BlackHorseRight(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
		}

		@Override
		public void update() {
			if( (Mouse.bhr || Mouse.lastPiece == id) &&
				(Mouse.mousePressed || Mouse.mouseRealesed) &&
				(gameState.blackTurn)) super.update();
		}
}

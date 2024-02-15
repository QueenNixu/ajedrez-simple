package gameObject;

import java.awt.image.BufferedImage;

import input.Mouse;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhiteBishopRight extends Bishop {

	private static final int id = Constants.wbrId;
	
	public WhiteBishopRight(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
		}

		@Override
		public void update() {
			if( (Mouse.wbr || Mouse.lastPiece == id) &&
				(Mouse.mousePressed || Mouse.mouseRealesed) &&
				(gameState.whiteTurn)) super.update();
		}
}

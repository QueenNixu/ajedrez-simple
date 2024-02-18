package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import java.awt.Graphics;

import math.Cell;
import math.Vector2D;
import states.GameState;

public class WhiteHorseRight extends Horse {
	
	private static final int id = Constants.whrId;

	public WhiteHorseRight(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
		}

		@Override
		public void update() {
			if( (MouseForWindow.whr || MouseForWindow.lastPiece == id) &&
				(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
				(gameState.whiteTurn)) super.update();
		}
}

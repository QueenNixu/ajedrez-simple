package gameObject;

import java.awt.image.BufferedImage;

import input.MouseForWindow;

import math.Vector2D;
import states.GameState;

public class WhiteHorseLeft extends Horse {

	private static final int id = Constants.whlId;
	
	public WhiteHorseLeft(Vector2D posicion, BufferedImage textura, GameState gameState) {
		super(posicion, textura, gameState, id);
		}

		@Override
		public void update() {
			if( (MouseForWindow.whl || MouseForWindow.lastPiece == id) &&
				(MouseForWindow.mousePressed || MouseForWindow.mouseRealesed) &&
				(gameState.whiteTurn)) super.update();
		}
}

package gameObject;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
//import graphics.Sound;
import math.Vector2D;
import states.GameState;

public abstract class MovingObject extends GameObject{
	
	protected GameState gameState;
	
	//private Sound explosion;
	
	protected boolean Dead;
	
	public MovingObject(Vector2D position, BufferedImage texture, GameState gameState) {
		super(position, texture);
		this.gameState = gameState;
		Dead = false;
	}
	
	public void destroy(){
		Dead = true;
	}
	
	public boolean isDead() {return Dead;}

	public abstract int getId();

	public abstract boolean isFirstMove();
	
}
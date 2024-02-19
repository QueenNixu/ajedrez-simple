package gameObject;

import java.awt.image.BufferedImage;
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
		//System.out.println("posicion X: "+posicion.getX()+" posicion y: "+posicion.getY());
	}
	
	public void destroy(){
		Dead = true;
	}
	
	public boolean isDead() {return Dead;}

	public abstract int getId();

	public abstract boolean isFirstMove();

	public abstract void iniciarPos();
	
}
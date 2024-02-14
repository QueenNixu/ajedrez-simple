package gameObject;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
//import graphics.Sound;
import math.Vector2D;
import states.GameState;

public abstract class MovingObject extends GameObject{
	
	protected AffineTransform at;
	protected GameState gameState;
	
	//private Sound explosion;
	
	protected boolean Dead;
	
	public MovingObject(Vector2D position, BufferedImage texture, GameState gameState) {
		super(position, texture);
		this.gameState = gameState;
		Dead = false;
	}
	
	protected void collidesWith(){
		
		ArrayList<MovingObject> movingObjects = gameState.getMovingObjects(); 
		
		for(int i = 0; i < movingObjects.size(); i++){
			
			MovingObject m  = movingObjects.get(i);
			
			if(m.equals(this))
				continue;
			// calcular si ambos estan en la misma casilla
			//System.out.println("colosion");
			/*
			double distance = m.getCenter().subtract(getCenter()).getMagnitude();
			
			if(distance < m.width/2 + width/2 && movingObjects.contains(this) && !m.Dead && !Dead){
				objectCollision(this, m);
			}
			*/
		}
	}
	
	protected void destroy(){
		Dead = true;
	}
	
	public boolean isDead() {return Dead;}

	public abstract int getId();

	public abstract boolean isFirstMove();
	
}
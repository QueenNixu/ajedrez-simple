package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import math.Vector2D;

public abstract class GameObject {
	
	protected BufferedImage textura;
	protected Vector2D posicion;
	
	public GameObject(Vector2D posicion, BufferedImage textura) {
		this.posicion= posicion;
		this.textura = textura;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);

	public Vector2D getPosicion() {
		return posicion;
	}

	public void setPosicion(Vector2D posicion) {
		this.posicion = posicion;
	}

	public void setTextura(BufferedImage textura) {
		this.textura = textura;
	}
	
	
	
	

}

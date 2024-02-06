package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.Assets;
import input.Mouse;
import states.GameState;

public class Window extends JFrame implements Runnable {
	
	public static final int WIDTH = 496;
	public static final int HEIGHT = 519;
	
	public static final int cellSize = 60;
	
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	private int AVARAGEFPS = FPS;
	
	public JPanel[][] field = new JPanel[8][8];
	
	private Canvas canvas;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	private boolean tableroGenerado = false;
	private boolean piezasPosicionadas = false;
	
	private GameState gameState;
	
	private Mouse mouse;

	public static void main(String[] args) {
		new Window().start();
	}
	
	public Window() {
		
		setTitle("Ajedrez");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		
		add(canvas);
		
		mouse = new Mouse();
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
	}
	
	private void init() {
		Assets.init();
		gameState = new GameState();
	}
	
	private void generarTablero() {
	    int cellSize = 60;
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            // Establece el color antes de dibujar el rectángulo
	            if (j % 2 == 0) {
	                if (i % 2 == 0) {
	                    g.setColor(new Color(210, 180, 140));
	                } else {
	                	g.setColor(new Color(101, 67, 33));
	                }
	            } else {
	                if (i % 2 == 0) {
	                    g.setColor(new Color(101, 67, 33));
	                } else {
	                    g.setColor(new Color(210, 180, 140));
	                }
	            }
	            
	            // Dibuja el rectángulo
	            g.fillRect(cellSize * i, cellSize * j, cellSize, cellSize);
	        }
	    }
	}

	
	private void iniciarTablero() {
		
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				field[i][j] = new JPanel();
				field[i][j].setBounds(cellSize*i, cellSize*j, cellSize, cellSize);
				field[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
				if(j % 2 == 0) {
					if(i % 2 == 0) {
						field[i][j].setBackground(new Color(210, 180, 140));
					} else {
						field[i][j].setBackground(Color.BLACK);
					}
				} else {
					if(i % 2 == 0) {
						field[i][j].setBackground(Color.BLACK);
					} else {
						field[i][j].setBackground(Color.WHITE);
					}
				}
				add(field[i][j]);
			}
		}
		
	}

	private void update() {
		mouse.update();
		gameState.update();
	}
	
	private void draw() {
		bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(2);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		// dibujo arranca aqui
		generarTablero();
		/*
		if(!tableroGenerado ) {
			tableroGenerado = true;
			generarTablero();
		}
		*/
		/*
		if(!piezasPosicionadas) {
			piezasPosicionadas  = true;
			generarPiezas();
		}
		*/
		
		//g.setColor(Color.BLACK);
		//g.drawString(""+AVARAGEFPS, 100, 100);
		//System.out.println("FPS: "+AVARAGEFPS);

		gameState.draw(g);
        
		// dibujo termina aca
		
		g.dispose();
		bs.show();
	}

	private void generarPiezas() {
		
		g.drawImage(Assets.whiteKing, cellSize*4, cellSize*7 , null);
		g.drawImage(Assets.whiteQueen, cellSize*3, cellSize*7, null);
		g.drawImage(Assets.whiteHorse, cellSize*1, cellSize*7, null);
		g.drawImage(Assets.whiteHorse, cellSize*6, cellSize*7, null);
		g.drawImage(Assets.whiteTower, cellSize*0, cellSize*7, null);
		g.drawImage(Assets.whiteTower, cellSize*7, cellSize*7, null);
		g.drawImage(Assets.whiteBishop, cellSize*2, cellSize*7, null);
		g.drawImage(Assets.whiteBishop, cellSize*5, cellSize*7, null);
		for(int i = 0; i < 8; i++) {
			g.drawImage(Assets.whitePawn, cellSize*i, cellSize*6, null);
		}
		
		g.drawImage(Assets.blackKing, cellSize*4, cellSize*0 , null);
		g.drawImage(Assets.blackQueen, cellSize*3, cellSize*0, null);
		g.drawImage(Assets.blackHorse, cellSize*1, cellSize*0, null);
		g.drawImage(Assets.blackHorse, cellSize*6, cellSize*0, null);
		g.drawImage(Assets.blackTower, cellSize*0, cellSize*0, null);
		g.drawImage(Assets.blackTower, cellSize*7, cellSize*0, null);
		g.drawImage(Assets.blackBishop, cellSize*2, cellSize*0, null);
		g.drawImage(Assets.blackBishop, cellSize*5, cellSize*0, null);
		for(int i = 0; i < 8; i++) {
			g.drawImage(Assets.blackPawn, cellSize*i, cellSize*1, null);
		}
		
	}

	@Override
	public void run() {
		
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;

		init();
		
		while(running) {
			
			now = System.nanoTime();
			delta += (now - lastTime)/TARGETTIME;
			time += (now - lastTime);
			lastTime = now;
			
			if(delta >= 1) {
				update();
				draw();
				delta--;
				frames++;
			}
			if(time >=1000000000) {
				AVARAGEFPS = frames;
				frames = 0;
				time = 0;
			}
			
		}
		
		stop();
	}
	
	private void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	private void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
package main;
//UWU UWUWUWUWUW

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameObject.Constants;
import graphics.Assets;
import input.MouseForWindow;
import states.GameState;

public class Window extends JFrame implements Runnable {
	
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
	
	private GameState gameState;
	
	private MouseForWindow mouse;
	
	private boolean paused = false;

	public static void main(String[] args) {
		new Window().start();
	}
	
	public Window() {
		
		setTitle("Ajedrez");
		setSize(Constants.WIDTH, Constants.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setMaximumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setMinimumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setFocusable(true);
		
		add(canvas);
	}
	
	private void init() {
		Assets.init();
		gameState = new GameState(this);
		mouse = new MouseForWindow(gameState);
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
	}
	
	private void generarTablero() {
	    for (int i = 0; i <= 7; i++) {
	        for (int j = 0; j <= 7; j++) {
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
	            g.fillRect(Constants.CELLSIZE * i, Constants.CELLSIZE * j, Constants.CELLSIZE, Constants.CELLSIZE);
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

		gameState.draw(g);
        
		// dibujo termina aca
		
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;

		init();
		
		while(running) {
			//System.out.print("RUNNING");
			now = System.nanoTime();
			delta += (now - lastTime)/TARGETTIME;
			time += (now - lastTime);
			lastTime = now;
			if(!paused) {
				if (delta >= 1) {
	                update();
	                draw();
	                delta--;
	                frames++;
	            }
	            if (time >= 1000000000) {
	                AVARAGEFPS = frames;
	                frames = 0;
	                time = 0;
	            }
			} else {
				System.out.print("PAUSED");
	            waitForResume();
	            System.out.print("RESUMED");
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
	
	public void pause() {
	    paused = true;
	    System.out.println("PAUSE");
	}

	public void resume() {
		//System.out.print("paused: "+paused);
	    paused = false;
	    //System.out.print("paused: "+paused);
	}
	
	private synchronized void waitForResume() {
	    while (paused) {
	        try {
	            wait();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
}
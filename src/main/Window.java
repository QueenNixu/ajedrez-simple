package main;
//UWU UWUWUWUWUW

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameObject.Constants;
import gameObject.MovingObject;
import graphics.Assets;
import input.MouseForWindow;
import states.GameState;

public class Window extends JFrame implements Runnable {
	
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	private int AVARAGEFPS = FPS;
	
	//public JPanel[][] field = new JPanel[8][8];
	
	private Canvas canvas;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private GameState gameState;
	
	private MouseForWindow mouse;
	
	private boolean paused = false;
	public int ganador = -1;
	private boolean parar = false;
	//private int i = 0;
	
	public static void main(String[] args) {
		new Window().start();
	}
	
	public Window() {
		
		setTitle("Ajedrez");
		setSize(Constants.WIDTH, Constants.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setLocationRelativeTo(null);
		
		canvasInit();
		
		setVisible(true);
	}
	
	private void canvasInit() {
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setMaximumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setMinimumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setFocusable(true);
		
		add(canvas);
		
	}

	private void init() {
		Assets.init();
		//gameState = null;
		gameState = new GameState(this);
		
		mouse = new MouseForWindow(gameState);
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		//gameState.setPositions();
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
			System.out.println("bs = null");
			canvas.createBufferStrategy(2);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
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
		
		//gameState.restart();
		gameState.setPositions();
		
		while(running) {
			//if(!parar) System.out.println("RUNNING "+i);
			//i++;
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
	            waitForResume();
	        }
			
			if(ganador != -1) {
				running = false;
			}
			
		}
		
		VentanaGanador vg = new VentanaGanador(ganador, this);
		System.out.println("El ganador son las piezas "+( (ganador == 0) ? "BLANCAS" : "NEGRAS"));
		
		stop();
	}
	
	void start() {
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
		//System.out.print("Pause() called");
	    paused = true;
	}

	public void resume() {
		//System.out.print("Resume() called");
	    this.paused = false;
	    synchronized (this) {
	        notify(); // Notificar al hilo en espera que la pausa ha terminado
	    }
	    //System.out.print("paused: "+paused);
	}
	
	private synchronized void waitForResume() {
	    while (paused) {
	        try {
	            wait();
	            //System.out.print("waitForResume() processing");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public void restart() {
		
		//remove(canvas);
		//gameState.restart();
		dispose();
		Window w = new Window();
		w.start();
		
	}
	
}
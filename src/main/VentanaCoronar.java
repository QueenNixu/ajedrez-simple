package main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameObject.Constants;

public class VentanaCoronar extends JFrame {
	
	
	
	private Window window;

	public VentanaCoronar(Window window) {
		
		this.window = window;
		
		window.pause();
		
		setTitle("Coronar peon");
		setSize(Constants.WIDTH/2, Constants.HEIGHT*2/3);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		setVisible(true);
	}
	
	public VentanaCoronar() {
		
		setTitle("Coronar peon");
		setSize(Constants.WIDTH/2, Constants.HEIGHT*2/3);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		//System.out.println("20%: "+getHeight()*0.2);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBounds(0, 0, getWidth(), (int) (getHeight()*0.2)+1);
		pnlTitulo.setBackground(Color.RED);
		pnlTitulo.setBorder(null);
		add(pnlTitulo);
		
		JPanel pnlCuerpo= new JPanel();
		pnlCuerpo.setBounds(0, (int) (getHeight()*0.2)+1, getWidth(), (int) (getHeight()*0.8));
		pnlCuerpo.setBackground(Color.BLUE);
		pnlCuerpo.setBorder(null);
		add(pnlCuerpo);
		
		
		
		setVisible(true);
		
		System.out.println("ALTURA DE LA VENTANA: "+getHeight());
		System.out.println("ALTURA DE PANEL TITULO: "+pnlTitulo.getHeight());
		System.out.println("ALTURA DE PANEL CUERPO: "+pnlCuerpo.getHeight());
	}
	
	public static void main(String[] args) {
        // Crear una instancia de la ventana principal
		VentanaCoronar mainWindow = new VentanaCoronar();
    }

}

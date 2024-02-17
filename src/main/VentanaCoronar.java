package main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gameObject.Constants;
import gameObject.Pawn;
import graphics.Assets;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentanaCoronar extends JFrame {
	
	
	
	private Window window;

	public VentanaCoronar(Window window, Pawn pawn) {
		
		this.window = window;
		
		window.pause();
		
		setTitle("Coronar peon");
		setSize(Constants.WIDTH/2, Constants.HEIGHT*2/3);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBounds(0, 0, getWidth(), (int) (getHeight()*0.2)+1);
		pnlTitulo.setBackground(new Color(101, 67, 33));
		//pnlTitulo.setBorder(null);
		Border borderSuperior = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK),
                BorderFactory.createEmptyBorder(2, 2, 2, 2));
        pnlTitulo.setBorder(borderSuperior);
		getContentPane().add(pnlTitulo);
		
		JPanel pnlCuerpo= new JPanel();
		pnlCuerpo.setBounds(0, (int) (getHeight()*0.2)+1, getWidth(), (int) (getHeight()*0.8));
		pnlCuerpo.setBackground(new Color(210, 180, 140));
		//pnlCuerpo.setBorder(null);
		Border borderInferior = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK),
                BorderFactory.createEmptyBorder(2, 2, 2, 2));
        pnlCuerpo.setBorder(borderInferior);
		getContentPane().add(pnlCuerpo);
		
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
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBounds(0, 0, 248, 50);
		pnlTitulo.setBackground(new Color(120, 77, 43));
		//pnlTitulo.setBorder(null);
		Border borderSuperior = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK),
                BorderFactory.createEmptyBorder(2, 2, 2, 2));
        pnlTitulo.setBorder(borderSuperior);
		getContentPane().add(pnlTitulo);
		pnlTitulo.setLayout(null);
		
		JLabel lblTitulo1 = new JLabel("Elige a que pieza quieres");
		lblTitulo1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblTitulo1.setForeground(new Color(240, 220, 180));

		lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo1.setBounds(10, 2, 228, 28);
		pnlTitulo.add(lblTitulo1);
		
		JLabel lblTitulo2 = new JLabel(" convertir tu peon");
		lblTitulo2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblTitulo2.setForeground(new Color(240, 220, 180));
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setBounds(10, 30, 228, 21);
		pnlTitulo.add(lblTitulo2);
		
		JPanel pnlCuerpo= new JPanel();
		pnlCuerpo.setBounds(0, 50, 248, 296);
		pnlCuerpo.setBackground(new Color(240, 220, 180));
		//pnlCuerpo.setBorder(null);
		Border borderInferior = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK),
                BorderFactory.createEmptyBorder(2, 2, 2, 2));
        pnlCuerpo.setBorder(borderInferior);
		getContentPane().add(pnlCuerpo);
		pnlCuerpo.setLayout(null);
		
		Border optionBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        
		Assets.init();
		
		JPanel pnlOption1 = new JPanel();
		pnlOption1.setLayout(null);
		pnlOption1.setBackground(new Color(210, 180, 140));
		pnlOption1.setBounds(20, 11, 99, 99);
		pnlOption1.setBorder(optionBorder);
		pnlCuerpo.add(pnlOption1);
		
		JLabel lblOption1 = new JLabel("");
		lblOption1.setIcon(new ImageIcon(Assets.whiteQueen));
		lblOption1.setBounds(18, 18, 60, 60);
		pnlOption1.add(lblOption1);
		
		JPanel pnlOption2 = new JPanel();
		pnlOption2.setLayout(null);
		pnlOption2.setBackground(new Color(101, 67, 33));
		pnlOption2.setBounds(129, 11, 99, 99);
		pnlOption2.setBorder(optionBorder);
		pnlCuerpo.add(pnlOption2);
		
		JLabel lblOption2 = new JLabel("");
		lblOption2.setIcon(new ImageIcon(Assets.whiteBishop));
		lblOption2.setBounds(21, 21, 60, 60);
		pnlOption2.add(lblOption2);
		
		JPanel pnlOption3 = new JPanel();
		pnlOption3.setLayout(null);
		pnlOption3.setBackground(new Color(101, 67, 33));
		pnlOption3.setBounds(20, 120, 99, 99);
		pnlOption3.setBorder(optionBorder);
		pnlCuerpo.add(pnlOption3);
		
		JLabel lblOption3 = new JLabel("");
		lblOption3.setIcon(new ImageIcon(Assets.whiteHorse));
		lblOption3.setBounds(18, 21, 60, 60);
		pnlOption3.add(lblOption3);
		
		JPanel pnlOption4 = new JPanel();
		pnlOption4.setLayout(null);
		pnlOption4.setBackground(new Color(210, 180, 140));
		pnlOption4.setBounds(129, 120, 99, 99);
		pnlOption4.setBorder(optionBorder);
		pnlCuerpo.add(pnlOption4);
		
		JLabel lblOption4 = new JLabel("");
		lblOption4.setIcon(new ImageIcon(Assets.whiteTower));
		lblOption4.setBounds(21, 21, 60, 60);
		pnlOption4.add(lblOption4);
		
		JPanel pnlBtnNoCoronar = new JPanel();
		pnlBtnNoCoronar.setLayout(null);
		pnlBtnNoCoronar.setBackground(new Color(255, 64, 64));
		pnlBtnNoCoronar.setBounds(40, 235, 168, 39);
		pnlBtnNoCoronar.setBorder(optionBorder);
		pnlCuerpo.add(pnlBtnNoCoronar);
		
		JLabel lblNewLabel = new JLabel("No Coronar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 4, 148, 37);
		pnlBtnNoCoronar.add(lblNewLabel);
		
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

package main;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gameObject.Constants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;

public class VentanaGanador extends JFrame {
	
	protected int mouseX;
	protected int mouseY;
	protected int windowX;
	protected int windowY;

	public VentanaGanador(int idGanador, Window window) {
		
		//System.out.println("pawn.idCoronado: "+pawn.getIdCoronado());
		
		setTitle("Ganador");
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
        pnlTitulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Obtener la posición del ratón y la ventana en el momento del clic
                mouseX = e.getXOnScreen();
                mouseY = e.getYOnScreen();
                windowX = getX();
                windowY = getY();
            }
        });
        pnlTitulo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Calcular el cambio de posición del ratón y mover la ventana en consecuencia
                int deltaX = e.getXOnScreen() - mouseX;
                int deltaY = e.getYOnScreen() - mouseY;
                setLocation(windowX + deltaX, windowY + deltaY);
            }
        });
		getContentPane().add(pnlTitulo);
		pnlTitulo.setLayout(null);
		
		JLabel lblTitulo1 = new JLabel("GANADOR:");
		lblTitulo1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblTitulo1.setForeground(new Color(240, 220, 180));

		lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo1.setBounds(10, 2, 228, 28);
		pnlTitulo.add(lblTitulo1);
		
		JLabel lblTitulo2 = new JLabel("piezas "+( (idGanador == 0) ? "NEGRAS" : "BLANCAS"));
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
        
		//Assets.init();
		
		JPanel pnlPlayer1 = new JPanel();
		pnlPlayer1.setLayout(null);
		pnlPlayer1.setBackground(new Color(120, 77, 43));
		pnlPlayer1.setBounds(10, 11, 104, 82);
		pnlPlayer1.setBorder(optionBorder);
		pnlCuerpo.add(pnlPlayer1);
		
		JPanel pnlVictoriasPlayer1 = new JPanel();
		pnlVictoriasPlayer1.setBounds(32, 38, 40, 33);
		pnlPlayer1.add(pnlVictoriasPlayer1);
		pnlVictoriasPlayer1.setLayout(null);
		pnlVictoriasPlayer1.setBorder(optionBorder);
		pnlVictoriasPlayer1.setBackground(new Color(240, 220, 180));
		
		JLabel lblVictoriasPlayer1 = new JLabel("100");
		lblVictoriasPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVictoriasPlayer1.setBounds(0, 0, 40, 33);
		pnlVictoriasPlayer1.add(lblVictoriasPlayer1);
		
		JPanel pnlPlayer2 = new JPanel();
		pnlPlayer2.setLayout(null);
		pnlPlayer2.setBackground(new Color(120, 77, 43));
		pnlPlayer2.setBounds(134, 11, 104, 82);
		pnlPlayer2.setBorder(optionBorder);
		pnlCuerpo.add(pnlPlayer2);
		
		JPanel pnlVictoriasPlayer2 = new JPanel();
		pnlVictoriasPlayer2.setLayout(null);
		pnlVictoriasPlayer2.setBackground(new Color(240, 220, 180));
		pnlVictoriasPlayer2.setBounds(32, 38, 40, 33);
		pnlVictoriasPlayer2.setBorder(optionBorder);
		pnlPlayer2.add(pnlVictoriasPlayer2);
		
		JLabel lblVictoriasPlayer2 = new JLabel("100");
		lblVictoriasPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVictoriasPlayer2.setBounds(0, 0, 40, 33);
		pnlVictoriasPlayer2.add(lblVictoriasPlayer2);
		
		JPanel pnlSeparador = new JPanel();
		pnlSeparador.setLayout(null);
		pnlSeparador.setBackground(new Color(120, 77, 43));
		pnlSeparador.setBounds(117, 46, 14, 10);
		pnlSeparador.setBorder(optionBorder);
		pnlCuerpo.add(pnlSeparador);
		
		JPanel pnlBtnNewMatch = new JPanel();
		pnlBtnNewMatch.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	dispose();
		    	window.dispose();
		    	new Window().start();
		    }
		});

		pnlBtnNewMatch.setLayout(null);
		pnlBtnNewMatch.setBackground(new Color(120, 77, 43));
		pnlBtnNewMatch.setBounds(62, 104, 124, 33);
		pnlBtnNewMatch.setBorder(optionBorder);
		pnlCuerpo.add(pnlBtnNewMatch);
		
		JLabel lblNewMatch = new JLabel("Nueva Partida");
		lblNewMatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMatch.setForeground(new Color(240, 220, 180));
		lblNewMatch.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblNewMatch.setBounds(0, 0, 124, 33);
		pnlBtnNewMatch.add(lblNewMatch);
		
		JPanel pnlBtnRevancha = new JPanel();
		pnlBtnRevancha.setLayout(null);
		pnlBtnRevancha.setBackground(new Color(120, 77, 43));
		pnlBtnRevancha.setBounds(62, 148, 124, 33);
		pnlBtnRevancha.setBorder(optionBorder);
		pnlCuerpo.add(pnlBtnRevancha);
		
		JLabel lblRevancha = new JLabel("Revancha");
		lblRevancha.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevancha.setForeground(new Color(240, 220, 180));
		lblRevancha.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblRevancha.setBounds(0, 0, 124, 33);
		pnlBtnRevancha.add(lblRevancha);
		
		JPanel pnlExit = new JPanel();
		pnlExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		pnlExit.setLayout(null);
		pnlExit.setBackground(new Color(120, 77, 43));
		pnlExit.setBounds(72, 192, 104, 20);
		pnlExit.setBorder(optionBorder);
		pnlCuerpo.add(pnlExit);
		
		JLabel lblExit = new JLabel("Salir");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(new Color(240, 220, 180));
		lblExit.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblExit.setBounds(0, 0, 104, 20);
		pnlExit.add(lblExit);
		
		/*
		JPanel pnlBtnNoCoronar = new JPanel();
		pnlBtnNoCoronar.setLayout(null);
		pnlBtnNoCoronar.setBackground(new Color(255, 64, 64));
		pnlBtnNoCoronar.setBounds(40, 235, 168, 39);
		pnlBtnNoCoronar.setBorder(optionBorder);
		pnlCuerpo.add(pnlBtnNoCoronar);
		*/
		/*
		JLabel lblNewLabel = new JLabel("No Coronar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 4, 148, 37);
		pnlBtnNoCoronar.add(lblNewLabel);
		*/
		setVisible(true);
	}
	
	protected void exit() {
        super.dispose();
	}

	protected void mouseExitedActionListener() {
		setCursor(Cursor.getDefaultCursor());
	}

	protected void mouseEnteredActionListener() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}

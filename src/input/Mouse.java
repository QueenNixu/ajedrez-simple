package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gameObject.ObjectPosition;
import math.Vector2D;

public class Mouse implements MouseListener, MouseMotionListener {
	
	public static int mouseXOnApp;
	public static int mouseYOnApp;
	
	public static int mouseXOnScreen;
	public static int mouseYOnScreen;
	
	private static boolean[] piece = new boolean[32];
	
	public static boolean wk;
	public static boolean wq;
	public static boolean wbl;
	public static boolean whl;
	public static boolean wtl;
	public static boolean wbr;
	public static boolean whr;
	public static boolean wtr;
	public static boolean wp0;
	public static boolean wp1;
	public static boolean wp2;
	public static boolean wp3;
	public static boolean wp4;
	public static boolean wp5;
	public static boolean wp6;
	public static boolean wp7;
	
	public static boolean bk;
	public static boolean bq;
	public static boolean bbl;
	public static boolean bhl;
	public static boolean btl;
	public static boolean bbr;
	public static boolean bhr;
	public static boolean btr;
	public static boolean bp0;
	public static boolean bp1;
	public static boolean bp2;
	public static boolean bp3;
	public static boolean bp4;
	public static boolean bp5;
	public static boolean bp6;
	public static boolean bp7;
	public static boolean mousePressed;
	public static int lastPiece;
	public static Vector2D originalPos;
	public static boolean mouseRealesed = false;
	public static int oriPosX;
	public static int oriPosY;
	
	
	public Mouse() {
		for(int i = 0; i < piece.length; i++) {
	        piece[i] = false;
	    }
		wk = false;
		wq = false;
		wbl = false;
		whl = false;
		wtl = false;
		wbr = false;
		whr = false;
		wtr = false;
		wp0 = false;
		wp1 = false;
		wp2 = false;
		wp3 = false;
		wp4 = false;
		wp5 = false;
		wp6 = false;
		wp7 = false;
		
		bk = false;
		bq = false;
		bbl = false;
		bhl = false;
		btl = false;
		bbr = false;
		bhr = false;
		btr = false;
		bp0 = false;
		bp1 = false;
		bp2 = false;
		bp3 = false;
		bp4 = false;
		bp5 = false;
		bp6 = false;
		bp7 = false;
		
	}
	
	public void update() {
		
		wk = piece[0];
		wq = piece[1];
		wbl = piece[2];
		whl = piece[3];
		wtl = piece[4];
		wbr = piece[5];
		whr = piece[6];
		wtr = piece[7];
		wp0 = piece[8];
		wp1 = piece[9];
		wp2 = piece[10];
		wp3 = piece[11];
		wp4 = piece[12];
		wp5 = piece[13];
		wp6 = piece[14];
		wp7 = piece[15];
		
		bk = piece[16];
		bq = piece[17];
		bbl = piece[18];
		bhl = piece[19];
		btl = piece[20];
		bbr = piece[21];
		bhr = piece[22];
		btr = piece[23];
		bp0 = piece[24];
		bp1 = piece[25];
		bp2 = piece[26];
		bp3 = piece[27];
		bp4 = piece[28];
		bp5 = piece[29];
		bp6 = piece[30];
		bp7 = piece[31];
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {
	        mouseXOnApp = e.getX();
	        mouseYOnApp = e.getY();
	        oriPosX = e.getX();
	        oriPosY = e.getY();
	        
	        int pieceId = ObjectPosition.piece(mouseXOnApp, mouseYOnApp);
	        lastPiece = pieceId;
	        
	        System.out.println(pieceId);
	        
	        if(pieceId != -1) {
	            originalPos = ObjectPosition.getCell(pieceId);
	            mousePressed = true;
	            piece[pieceId] = true;
	        }
	    }
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		//Si el lugar donde estas dejando la pieza es valido dejarla ahi y actualizar datos.
		//si no, volverla a poner donde estaba
		//System.out.println("MOUSE RELEASED");
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			if(lastPiece != -1) {
				piece[lastPiece]=false;
			}
			mousePressed = false;
			
			mouseRealesed  = true;
			
			mouseXOnApp = e.getX();
			mouseYOnApp = e.getY();
		}
		
		
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(mousePressed) {
			mouseXOnApp = e.getX();
		    mouseYOnApp = e.getY();
		    //System.out.println("x: "+e.getX()+" y: "+e.getY());
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}

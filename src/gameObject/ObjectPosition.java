package gameObject;

import math.Vector2D;

public class ObjectPosition {
	
	static int[][] posicionesDelTablero = new int[8][8];
    
    public static Vector2D[] piecePosition = new Vector2D[32];
    public static int[] pieceNumbers = new int[32];
    
    public static Boolean[][] allowedCellsBool = new Boolean[8][8];
    
    public static Vector2D[] getPiecePosition() {
		return piecePosition;
	}

	public static void setPiecePosition(Vector2D[] piecePosition) {
		ObjectPosition.piecePosition = piecePosition;
	}

	static {
        Vector2D[] allPositions = {
            new Vector2D(60 * 4, 60 * 7),  // wkPos
            new Vector2D(60 * 3, 60 * 7),  // wqPos
            new Vector2D(60 * 2, 60 * 7),  // wblPos
            new Vector2D(60 * 1, 60 * 7),  // whlPos
            new Vector2D(60 * 0, 60 * 7),  // wtlPos
            new Vector2D(60 * 5, 60 * 7),  // wbrPos
            new Vector2D(60 * 6, 60 * 7),  // whrPos
            new Vector2D(60 * 7, 60 * 7),  // wtrPos
            new Vector2D(60 * 0, 60 * 6),  // wpPos[0]
            new Vector2D(60 * 1, 60 * 6),  // wpPos[1]
            new Vector2D(60 * 2, 60 * 6),  // wpPos[2]
            new Vector2D(60 * 3, 60 * 6),  // wpPos[3]
            new Vector2D(60 * 4, 60 * 6),  // wpPos[4]
            new Vector2D(60 * 5, 60 * 6),  // wpPos[5]
            new Vector2D(60 * 6, 60 * 6),  // wpPos[6]
            new Vector2D(60 * 7, 60 * 6),  // wpPos[7]
            new Vector2D(60 * 4, 60 * 0),  // bkPos
            new Vector2D(60 * 3, 60 * 0),  // bqPos
            new Vector2D(60 * 2, 60 * 0),  // bblPos
            new Vector2D(60 * 1, 60 * 0),  // bhlPos
            new Vector2D(60 * 0, 60 * 0),  // btlPos
            new Vector2D(60 * 5, 60 * 0),  // bbrPos
            new Vector2D(60 * 6, 60 * 0),  // bhrPos
            new Vector2D(60 * 7, 60 * 0),  // btrPos
            new Vector2D(60 * 0, 60 * 1),  // bpPos[0]
            new Vector2D(60 * 1, 60 * 1),  // bpPos[1]
            new Vector2D(60 * 2, 60 * 1),  // bpPos[2]
            new Vector2D(60 * 3, 60 * 1),  // bpPos[3]
            new Vector2D(60 * 4, 60 * 1),  // bpPos[4]
            new Vector2D(60 * 5, 60 * 1),  // bpPos[5]
            new Vector2D(60 * 6, 60 * 1),  // bpPos[6]
            new Vector2D(60 * 7, 60 * 1)   // bpPos[7]
        };
        
        int[] allPieceNumbers = {
                0,
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28,
                29,
                30,
                31,
            };
        int[][] posicionesDelTableroAux = {
                {20, 24, -1, -1, -1, -1, 8, 4}, // Primera fila
                {19, 25, -1, -1, -1, -1, 9, 3}, // Segunda fila
                {18, 26, -1, -1, -1, -1, 10, 2}, // Tercera fila
                {17, 27, -1, -1, -1, -1, 11, 1}, // Cuarta fila
                {16, 28, -1, -1, -1, -1, 12, 0}, // Quinta fila
                {21, 29, -1, -1, -1, -1, 13, 5}, // Sexta fila
                {22, 30, -1, -1, -1, -1, 14, 6}, // Séptima fila
                {23, 31, -1, -1, -1, -1, 15, 7}  // Octava fila
        };
        System.arraycopy(allPositions, 0, piecePosition, 0, allPositions.length);
        System.arraycopy(allPieceNumbers, 0, pieceNumbers, 0, allPieceNumbers.length);
        for (int i = 0; i < 8; i++) {
            System.arraycopy(posicionesDelTableroAux[i], 0, posicionesDelTablero[i], 0, 8);
            //System.out.print(posicionesDelTablero[i][i]);
        }

    }
    
    public ObjectPosition() {
    	
    	
        
    }
    
    public static int piece(int x, int y) {
    	
        for (int i = 0; i < piecePosition.length; i++) {
        	
            Vector2D vec = piecePosition[i];
            /*
            System.out.println("i: "+i);
            System.out.println("vecX: "+vec.getX()+"x: "+x);
            System.out.println("vecY: "+vec.getY()+"y: "+y);
            */
            if (x > vec.getX() && x < vec.getX() + 60 && y > vec.getY() && y < vec.getY() + 60) {
                //System.out.println("pieceNumbers["+i+"]: "+pieceNumbers[i]);
            	return pieceNumbers[i];
            	
            }
        }
        
        return -1; // Devuelve -1 si no se encuentra ninguna pieza en las coordenadas especificadas
    }

	public static Vector2D getCell(int pieceId) {
		if(pieceId != -1) {
			return piecePosition[pieceId];
		}
		return null;
	}
	
	
	
	

}

package gameObject;

import math.Vector2D;

public class ObjectPosition {
    
    private static Vector2D[] piecePosition = new Vector2D[32];
    private static int[] pieceNumbers = new int[32];
    
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
        System.arraycopy(allPositions, 0, piecePosition, 0, allPositions.length);
        System.arraycopy(allPieceNumbers, 0, pieceNumbers, 0, allPieceNumbers.length);

    }
    
    public ObjectPosition() {
        
    }

    public static int piece(int x, int y) {
        for (int i = 0; i < piecePosition.length; i++) {
            Vector2D vec = piecePosition[i];
            if (x > vec.getX() && x < vec.getX() + 60 && y > vec.getY() && y < vec.getY() + 60) {
                return pieceNumbers[i];
            }
        }
        return -1; // Devuelve 0 si no se encuentra ninguna pieza en las coordenadas especificadas
    }

}

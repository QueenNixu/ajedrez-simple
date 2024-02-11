package math;

import gameObject.Constants;
import gameObject.ObjectPosition;

public class Cell {
	
	public static int getFromCell(int originalPos) {
		if(originalPos >= 0 && originalPos < Constants.CELLSIZE*1) {
			return 0;
		}
		if(originalPos >= Constants.CELLSIZE*1 && originalPos < Constants.CELLSIZE*2) {
			return Constants.CELLSIZE*1;
		}
		if(originalPos >= Constants.CELLSIZE*2 && originalPos < Constants.CELLSIZE*3) {
			return Constants.CELLSIZE*2;
		}
		if(originalPos >= Constants.CELLSIZE*3 && originalPos < Constants.CELLSIZE*4) {
			return Constants.CELLSIZE*3;
		}
		if(originalPos >= Constants.CELLSIZE*4 && originalPos < Constants.CELLSIZE*5) {
			return Constants.CELLSIZE*4;
		}
		if(originalPos >= Constants.CELLSIZE*5 && originalPos < Constants.CELLSIZE*6) {
			return Constants.CELLSIZE*5;
		}
		if(originalPos >= Constants.CELLSIZE*6 && originalPos < Constants.CELLSIZE*7) {
			return Constants.CELLSIZE*6;
		}
		if(originalPos >= Constants.CELLSIZE*7 && originalPos < Constants.CELLSIZE*8) {
			return Constants.CELLSIZE*7;
		}
		return -1;
	}

	public static boolean allyCell(int i, int j, int exception, int allyStart) {
		
		//System.out.println("ObjectPosition.posicionesDelTablero["+i+"]["+j+"]: "+ObjectPosition.posicionesDelTablero[i][j]);
		
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+1 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+2 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+3 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+4 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+5 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+6 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+7 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+8 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+9 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+10 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+11 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+12 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+13 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+14 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		if(ObjectPosition.posicionesDelTablero[i][j] == allyStart+15 && ObjectPosition.posicionesDelTablero[i][j] != exception) return true;
		
		return false;
	}

	public static int getZ(int originalPos) {
		
		if(originalPos >= Constants.CELLSIZE*0 && originalPos < Constants.CELLSIZE*1) {
			//System.out.println("UWU");
			return 0;
		}
		if(originalPos >= Constants.CELLSIZE*1 && originalPos < Constants.CELLSIZE*2) {
			return 1;
		}
		if(originalPos >= Constants.CELLSIZE*2 && originalPos < Constants.CELLSIZE*3) {
			return 2;
		}
		if(originalPos >= Constants.CELLSIZE*3 && originalPos < Constants.CELLSIZE*4) {
			return 3;
		}
		if(originalPos >= Constants.CELLSIZE*4 && originalPos < Constants.CELLSIZE*5) {
			return 4;
		}
		if(originalPos >= Constants.CELLSIZE*5 && originalPos < Constants.CELLSIZE*6) {
			return 5;
		}
		if(originalPos >= Constants.CELLSIZE*6 && originalPos < Constants.CELLSIZE*7) {
			return 6;
		}
		if(originalPos >= Constants.CELLSIZE*7 && originalPos < Constants.CELLSIZE*8) {
			return 7;
		}
		return -1;
		
	}

	public static void calcAllowedCells(Vector2D originalPos, int piece) {
		
		switch (piece) {
		case 0:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, 1);
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, 1);
            break;
		case 1:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, 7);
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 2:
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, 8);
            break;
		case 3:
        	horseAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 4:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 5:
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 6:
        	horseAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 7:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 8:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 9:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 10:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 11:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 12:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 13:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 14:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 15:
			pawnAllowedCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 16:
			towerAllowedCells(originalPos, piece, Constants.BLACKSTART, 1);
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, 1);
            break;
		case 17:
			towerAllowedCells(originalPos, piece, Constants.BLACKSTART, 7);
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 18:
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 19:
        	horseAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 20:
        	towerAllowedCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 21:
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 22:
        	horseAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 23:
        	towerAllowedCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 24:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 25:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 26:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 27:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 28:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 29:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 30:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 31:
        	pawnAllowedCells(originalPos, piece, Constants.BLACKSTART);
            break;
        default:
		}
	}
	
	public static void deAllowCells(Vector2D originalPos, int piece) {
		
		switch (piece) {
		case 0:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, 1);
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, 1);
            break;
		case 1:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, 7);
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 2:
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 3:
			horseDeallowCells(originalPos);
            break;
		case 4:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 5:
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 6:
			horseDeallowCells(originalPos);
            break;
		case 7:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, 7);
            break;
		case 8:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 9:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 10:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 11:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 12:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 13:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 14:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 15:
			pawnDeallowCells(originalPos, piece, Constants.WHITESTART);
            break;
		case 16:
			towerDeallowCells(originalPos, piece, Constants.BLACKSTART, 1);
			bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, 1);
            break;
		case 17:
			towerDeallowCells(originalPos, piece, Constants.BLACKSTART, 7);
			bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 18:
        	bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 19:
        	horseDeallowCells(originalPos);
            break;
        case 20:
        	towerDeallowCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 21:
        	bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 22:
        	horseDeallowCells(originalPos);
            break;
        case 23:
        	towerDeallowCells(originalPos, piece, Constants.BLACKSTART, 7);
            break;
        case 24:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 25:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 26:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 27:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 28:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 29:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 30:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        case 31:
        	pawnDeallowCells(originalPos, piece, Constants.BLACKSTART);
            break;
        default:
		}
	}
	

	private static void bishopAllowedCells(Vector2D originalPos, int exception, int allyStart, int end) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		//ObjectPosition.allowedCellsBool[3][3] = true;
		
		int i = iAux;
		int j = jAux;
		int iter = 0;
		while(j-1 >= 0 && i-1 >= 0 && !allyCell(i-1,j-1, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i-1)+","+(j-1));
			ObjectPosition.allowedCellsBool[i-1][j - 1] = true;
			j--;
			i--;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i+1 <= 7 && j-1 >= 0&& !allyCell(i+1,j-1, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i+1)+","+(j-1));
			ObjectPosition.allowedCellsBool[i+1][j-1] = true;
			i++;
			j--;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(j+1 <= 7 && i+1 <= 7 && !allyCell(i+1,j+1, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i+1)+","+(j+1));
			ObjectPosition.allowedCellsBool[i+1][j+1] = true;
			j++;
			i++;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i-1 >= 0 && j+1 <= 7 && !allyCell(i-1,j+1, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i-1)+","+(j+1));
			ObjectPosition.allowedCellsBool[i-1][j+1] = true;
			i--;
			j++;
			iter++;
		}
		
	}

	private static void bishopDeallowCells(Vector2D originalPos, int exception, int allyStart, int end) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		int i = iAux;
		int j = jAux;
		int iter = 0;
		while(j-1 >= 0 && i-1 >= 0 && !allyCell(i-1,j-1, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i-1)+","+(j-1));
			ObjectPosition.allowedCellsBool[i-1][j - 1] = false;
			j--;
			i--;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i+1 <= 7 && j-1 >= 0&& !allyCell(i+1,j-1, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i+1)+","+(j-1));
			ObjectPosition.allowedCellsBool[i+1][j-1] = false;
			i++;
			j--;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(j+1 <= 7 && i+1 <= 7 && !allyCell(i+1,j+1, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i+1)+","+(j+1));
			ObjectPosition.allowedCellsBool[i+1][j+1] = false;
			j++;
			i++;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i-1 >= 0 && j+1 <= 7 && !allyCell(i-1,j+1, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i-1)+","+(j+1));
			ObjectPosition.allowedCellsBool[i-1][j+1] = false;
			i--;
			j++;
			iter++;
		}
		
	}

	private static void horseAllowedCells(Vector2D originalPos, int exception, int allyStart) {
		
		int i = getZ((int)originalPos.getX());
		int j = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		if (i - 1 >= 0 && j - 2 >= 0 && !allyCell(i-1,j-2, exception, allyStart)) {
			ObjectPosition.allowedCellsBool[i - 1][j - 2] = true;
		}

		if (i + 1 <= 7 && j - 2 >= 0 && !allyCell(i+1,j-2, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i + 1][j - 2] = true;
		}

		if (i - 2 >= 0 && j - 1 >= 0 && !allyCell(i-2,j-1, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i - 2][j - 1] = true;
		}

		if (i - 2 >= 0 && j + 1 <= 7 && !allyCell(i-2,j+1, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i - 2][j + 1] = true;
		}

		if (i - 1 >= 0 && j + 2 <= 7 && !allyCell(i-1,j+2, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i - 1][j + 2] = true;
		}

		if (i + 1 <= 7 && j + 2 <= 7 && !allyCell(i+1,j+2, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i + 1][j + 2] = true;
		}

		if (i + 2 <= 7 && j - 1 >= 0 && !allyCell(i+2,j-1, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i + 2][j - 1] = true;
		}

		if (i + 2 <= 7 && j + 1 <= 7 && !allyCell(i+2,j+1, exception, allyStart)) {
		    ObjectPosition.allowedCellsBool[i + 2][j + 1] = true;
		}

		
	}

	private static void horseDeallowCells(Vector2D originalPos) {
		
		int i = Cell.getZ((int)originalPos.getX());
		int j = Cell.getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		if (i - 1 >= 0 && j - 2 >= 0) {
			ObjectPosition.allowedCellsBool[i - 1][j - 2] = false;
		}

		if (i + 1 <= 7 && j - 2 >= 0) {
		    ObjectPosition.allowedCellsBool[i + 1][j - 2] = false;
		}

		if (i - 2 >= 0 && j - 1 >= 0) {
		    ObjectPosition.allowedCellsBool[i - 2][j - 1] = false;
		}

		if (i - 2 >= 0 && j + 1 <= 7) {
		    ObjectPosition.allowedCellsBool[i - 2][j + 1] = false;
		}

		if (i - 1 >= 0 && j + 2 <= 7) {
		    ObjectPosition.allowedCellsBool[i - 1][j + 2] = false;
		}

		if (i + 1 <= 7 && j + 2 <= 7) {
		    ObjectPosition.allowedCellsBool[i + 1][j + 2] = false;
		}

		if (i + 2 <= 7 && j - 1 >= 0) {
		    ObjectPosition.allowedCellsBool[i + 2][j - 1] = false;
		}

		if (i + 2 <= 7 && j + 1 <= 7) {
		    ObjectPosition.allowedCellsBool[i + 2][j + 1] = false;
		}
		
	}

	private static void towerAllowedCells(Vector2D originalPos, int exception, int allyStart, int end) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		int i = iAux;
		int j = jAux;
		int iter = 0;
		while(j-1 >= 0 && !allyCell(i,j-1, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+i+","+(j-1));
			ObjectPosition.allowedCellsBool[i][j - 1] = true;
			j--;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i+1 <= 7 && !allyCell(i+1,j, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i+1)+","+j);
			ObjectPosition.allowedCellsBool[i+1][j] = true;
			i++;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(j+1 <= 7 && !allyCell(i,j+1, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i)+","+(j+1));
			ObjectPosition.allowedCellsBool[i][j+1] = true;
			j++;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i-1 >= 0 && !allyCell(i-1,j, exception, allyStart) && iter < end) {
			//System.out.println("PINTANDO: "+(i-1)+","+j);
			ObjectPosition.allowedCellsBool[i-1][j] = true;
			i--;
			iter++;
		}

		
	}

	private static void towerDeallowCells(Vector2D originalPos, int exception, int allyStart, int end) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		int i = iAux;
		int j = jAux;
		int iter = 0;
		while(j-1 >= 0 && !allyCell(i,j-1, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+i+","+(j-1));
			ObjectPosition.allowedCellsBool[i][j - 1] = false;
			j--;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i+1 <= 7 && !allyCell(i+1,j, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i+1)+","+j);
			ObjectPosition.allowedCellsBool[i+1][j] = false;
			i++;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(j+1 <= 7 && !allyCell(i,j+1, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i)+","+(j+1));
			ObjectPosition.allowedCellsBool[i][j+1] = false;
			j++;
			iter++;
		}
		i = iAux;
		j = jAux;
		iter = 0;
		while(i-1 >= 0 && !allyCell(i-1,j, exception, allyStart) && iter < end) {
			//System.out.println("DESPINTANDO: "+(i-1)+","+j);
			ObjectPosition.allowedCellsBool[i-1][j] = false;
			i--;
			iter++;
		}
		
	}
	
	private static void pawnAllowedCells(Vector2D originalPos, int exception, int allyStart) {
		
		int i = getZ((int)originalPos.getX());
		int j = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		switch(allyStart) {
			case 0:
				if (j-1 >= 0 && !allyCell(i,j-1,exception, allyStart)) {
					ObjectPosition.allowedCellsBool[i][j - 1] = true;
					/*
					if(firstMove) {
						ObjectPosition.allowedCellsBool[i][j - 2] = true;
						//firstMove = false;
					}
					*/
				}
				break;
			case 16:
				if (j+1 <= 7 && !allyCell(i,j+1,exception, allyStart)) {
					ObjectPosition.allowedCellsBool[i][j + 1] = true;
					/*
					if(firstMove) {
						ObjectPosition.allowedCellsBool[i][j - 2] = true;
						//firstMove = false;
					}
					*/
				}
				break;
			default:
		}
		
	}
	
	private static void pawnDeallowCells(Vector2D originalPos, int exception, int allyStart) {
		
		int i = getZ((int)originalPos.getX());
		int j = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		switch(allyStart) {
		case 0:
			if (j-1 >= 0 && !allyCell(i,j-1,exception, allyStart)) {
				ObjectPosition.allowedCellsBool[i][j - 1] = false;
				/*
				if(firstMove) {
					ObjectPosition.allowedCellsBool[i][j - 2] = true;
					//firstMove = false;
				}
				*/
			}
			break;
		case 16:
			if (j+1 <= 7 && !allyCell(i,j+1,exception, allyStart)) {
				ObjectPosition.allowedCellsBool[i][j + 1] = false;
				/*
				if(firstMove) {
					ObjectPosition.allowedCellsBool[i][j - 2] = true;
					//firstMove = false;
				}
				*/
			}
			break;
		default:
	}
		
	}

	
	
}


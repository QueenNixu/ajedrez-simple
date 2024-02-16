package math;

import gameObject.BlackTowerLeft;
import gameObject.BlackTowerRight;
import gameObject.Constants;
import gameObject.Pawn;
import gameObject.WhiteTowerLeft;
import gameObject.WhiteTowerRight;
import states.GameState;

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

	public static boolean allyCell(int i, int j, int exception, int allyStart, GameState gameState) {
		
		//System.out.println("gameState.posicionesDelTablero["+i+"]["+j+"]: "+gameState.posicionesDelTablero[i][j]);
		
		if(gameState.posicionesDelTablero[i][j] == allyStart && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+1 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+2 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+3 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+4 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+5 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+6 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+7 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+8 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+9 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+10 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+11 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+12 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+13 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+14 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+15 && gameState.posicionesDelTablero[i][j] != exception) return true;
		
		return false;
	}
	
	public static boolean allyCell(int i, int j, int allyStart, GameState gameState) {
		
		//System.out.println("gameState.posicionesDelTablero["+i+"]["+j+"]: "+gameState.posicionesDelTablero[i][j]);
		
		if(gameState.posicionesDelTablero[i][j] == allyStart) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+1) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+2) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+3) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+4) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+5) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+6) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+7) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+8) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+9) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+10) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+11) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+12) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+13) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+14) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+15) return true;
		
		return false;
	}
	
	public static boolean peonCell(int i, int j, int exception, int allyStart, GameState gameState) {
		
		//System.out.println("gameState.posicionesDelTablero["+i+"]["+j+"]: "+gameState.posicionesDelTablero[i][j]);
		
		if(gameState.posicionesDelTablero[i][j] == allyStart+8 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+9 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+10 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+11 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+12 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+13 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+14 && gameState.posicionesDelTablero[i][j] != exception) return true;
		if(gameState.posicionesDelTablero[i][j] == allyStart+15 && gameState.posicionesDelTablero[i][j] != exception) return true;
		
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

	public static void calcAllowedCells(Vector2D originalPos, int piece, boolean firstMove, GameState gameState, int idCoronado) {
		
		switch (piece) {
		case 0:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART,Constants.BLACKSTART, 1, firstMove, gameState, idCoronado);
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 1, gameState, idCoronado);
        	
        	WhiteTowerRight wtr = (WhiteTowerRight) gameState.getMovingObject(7);
        	if(firstMove && wtr.getFirstMove()
        			&& !Cell.allyCell(5, 7, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(6, 7, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(5, 7, piece, Constants.BLACKSTART, gameState)
        			&& !Cell.allyCell(6, 7, piece, Constants.BLACKSTART, gameState)) {
        		gameState.allowedCellsBool[6][7] = true;
        	}
        	
        	WhiteTowerLeft wtl = (WhiteTowerLeft) gameState.getMovingObject(4);
        	if(firstMove && wtl.getFirstMove()
        			&& !Cell.allyCell(1, 7, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(2, 7, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(3, 7, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(1, 7, piece, Constants.BLACKSTART, gameState)
        			&& !Cell.allyCell(2, 7, piece, Constants.BLACKSTART, gameState)
        			&& !Cell.allyCell(3, 7, piece, Constants.BLACKSTART, gameState)) {
        		gameState.allowedCellsBool[2][7] = true;
        	}
            break;
		case 1:
			/*
			if(idCoronado == -1) {
				towerAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, firstMove, gameState, idCoronado);
	        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
			} else {
				towerAllowedCells(originalPos, idCoronado, Constants.WHITESTART, Constants.BLACKSTART, 7, firstMove, gameState, piece);
	        	bishopAllowedCells(originalPos, idCoronado, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, piece);
			}
			*/
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, firstMove, gameState, idCoronado);
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
			
            break;
		case 2:
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 8, gameState, idCoronado);
            break;
		case 3:
        	horseAllowedCells(originalPos, piece, Constants.WHITESTART, gameState, idCoronado);
            break;
		case 4:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, firstMove, gameState, idCoronado);
            break;
		case 5:
        	bishopAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
		case 6:
        	horseAllowedCells(originalPos, piece, Constants.WHITESTART, gameState, idCoronado);
            break;
		case 7:
			towerAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, firstMove, gameState, idCoronado);
            break;
		case 8:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 9:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 10:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 11:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 12:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 13:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 14:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 15:
			if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 16:
			towerAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 1, firstMove, gameState, idCoronado);
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 1, gameState, idCoronado);
        	
        	BlackTowerRight btr = (BlackTowerRight) gameState.getMovingObject(23);
        	if(firstMove && btr.getFirstMove()
        			&& !Cell.allyCell(5, 0, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(6, 0, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(5, 0, piece, Constants.BLACKSTART, gameState)
        			&& !Cell.allyCell(6, 0, piece, Constants.BLACKSTART, gameState)) {
        		gameState.allowedCellsBool[6][0] = true;
        	}
        	
        	BlackTowerLeft btl = (BlackTowerLeft) gameState.getMovingObject(20);
        	if(firstMove && btl.getFirstMove()
        			&& !Cell.allyCell(1, 0, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(2, 0, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(3, 0, piece, Constants.WHITESTART, gameState)
        			&& !Cell.allyCell(1, 0, piece, Constants.BLACKSTART, gameState)
        			&& !Cell.allyCell(2, 0, piece, Constants.BLACKSTART, gameState)
        			&& !Cell.allyCell(3, 0, piece, Constants.BLACKSTART, gameState)) {
        		gameState.allowedCellsBool[2][0] = true;
        	}
        	
            break;
		case 17:
			towerAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, firstMove, gameState, idCoronado);
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, gameState, idCoronado);
            break;
        case 18:
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, gameState, idCoronado);
            break;
        case 19:
        	horseAllowedCells(originalPos, piece, Constants.BLACKSTART, gameState, idCoronado);
            break;
        case 20:
        	towerAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, firstMove, gameState, idCoronado);
            break;
        case 21:
        	bishopAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, gameState, idCoronado);
            break;
        case 22:
        	horseAllowedCells(originalPos, piece, Constants.BLACKSTART, gameState, idCoronado);
            break;
        case 23:
        	towerAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, firstMove, gameState, idCoronado);
            break;
        case 24:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
        	
            break;
        case 25:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 26:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 27:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 28:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 29:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 30:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 31:
        	if(idCoronado == -1) {
				pawnAllowedCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, firstMove, gameState);
			} else {
				calcAllowedCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        default:
		}
	}
	
	public static void deAllowCells(Vector2D originalPos, int piece, boolean firstMove, GameState gameState, int idCoronado) {
		
		switch (piece) {
		case 0:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 1, gameState, idCoronado);
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 1, gameState, idCoronado);
			//WhiteTowerRight wtr = (WhiteTowerRight) gameState.getMovingObject(7);
			if(firstMove) {
        		gameState.allowedCellsBool[6][7] = false;
        		gameState.allowedCellsBool[5][7] = false;
        	}
        	//WhiteTowerLeft wtl = (WhiteTowerLeft) gameState.getMovingObject(4);
        	if(firstMove) {
        		gameState.allowedCellsBool[2][7] = false;
        		gameState.allowedCellsBool[3][7] = false;
        	}
            break;
		case 1:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
		case 2:
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
		case 3:
			horseDeallowCells(originalPos, gameState);
            break;
		case 4:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
		case 5:
			bishopDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
		case 6:
			horseDeallowCells(originalPos, gameState);
            break;
		case 7:
			towerDeallowCells(originalPos, piece, Constants.WHITESTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
		case 8:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 9:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 10:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 11:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 12:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 13:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 14:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 15:
			if(idCoronado == -1) {
				pawnDeallowCells(originalPos, piece, Constants.WHITESTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
		case 16:
			towerDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.BLACKSTART, 1, gameState, idCoronado);
			bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 1, gameState, idCoronado);
            break;
		case 17:
			towerDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.BLACKSTART, 7, gameState, idCoronado);
			bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, gameState, idCoronado);
            break;
        case 18:
        	bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, gameState, idCoronado);
            break;
        case 19:
        	horseDeallowCells(originalPos, gameState);
            break;
        case 20:
        	towerDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
        case 21:
        	bishopDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.WHITESTART, 7, gameState, idCoronado);
            break;
        case 22:
        	horseDeallowCells(originalPos, gameState);
            break;
        case 23:
        	towerDeallowCells(originalPos, piece, Constants.BLACKSTART, Constants.BLACKSTART, 7, gameState, idCoronado);
            break;
        case 24:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 25:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 26:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 27:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 28:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 29:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 30:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        case 31:
        	if(idCoronado == -1) {
        		pawnDeallowCells(originalPos, piece, Constants.BLACKSTART, firstMove, gameState, idCoronado);
			} else {
				deAllowCells(originalPos, idCoronado, firstMove, gameState, piece);
			}
            break;
        default:
		}
	}
	

	private static void bishopAllowedCells(Vector2D originalPos, int exception, int allyStart, int enemyStart, int end, GameState gameState, int idCoronado) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		//gameState.allowedCellsBool[3][3] = true;
		if(idCoronado == -1) {
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && i-1 >= 0 && !allyCell(i-1,j-1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i-1)+","+(j-1));
				gameState.allowedCellsBool[i-1][j - 1] = true;
				if(allyCell(i-1,j-1, exception, enemyStart, gameState)) {
					break;
				}
				j--;
				i--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && j-1 >= 0 && !allyCell(i+1,j-1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i+1)+","+(j-1));
				gameState.allowedCellsBool[i+1][j-1] = true;
				if(allyCell(i+1,j-1, exception, enemyStart, gameState)) {
					break;
				}
				i++;
				j--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && i+1 <= 7 && !allyCell(i+1,j+1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i+1)+","+(j+1));
				gameState.allowedCellsBool[i+1][j+1] = true;
				if(allyCell(i+1,j+1, exception, enemyStart, gameState)) {
					break;
				}
				j++;
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && j+1 <= 7 && !allyCell(i-1,j+1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i-1)+","+(j+1));
				gameState.allowedCellsBool[i-1][j+1] = true;
				if(allyCell(i-1,j+1, exception, enemyStart, gameState)) {
					break;
				}
				i--;
				j++;
				iter++;
			}
		} else {
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && i-1 >= 0 && !allyCell(i-1,j-1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i-1)+","+(j-1));
				gameState.allowedCellsBool[i-1][j - 1] = true;
				if(allyCell(i-1,j-1, exception, enemyStart, gameState)) {
					break;
				}
				j--;
				i--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && j-1 >= 0 && !allyCell(i+1,j-1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i+1)+","+(j-1));
				gameState.allowedCellsBool[i+1][j-1] = true;
				if(allyCell(i+1,j-1, exception, enemyStart, gameState)) {
					break;
				}
				i++;
				j--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && i+1 <= 7 && !allyCell(i+1,j+1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i+1)+","+(j+1));
				gameState.allowedCellsBool[i+1][j+1] = true;
				if(allyCell(i+1,j+1, exception, enemyStart, gameState)) {
					break;
				}
				j++;
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && j+1 <= 7 && !allyCell(i-1,j+1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i-1)+","+(j+1));
				gameState.allowedCellsBool[i-1][j+1] = true;
				if(allyCell(i-1,j+1, exception, enemyStart, gameState)) {
					break;
				}
				i--;
				j++;
				iter++;
			}
		}
		
		
	}

	private static void bishopDeallowCells(Vector2D originalPos, int exception, int allyStart, int enemyStart, int end, GameState gameState, int idCoronado) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		if(idCoronado == -1) {
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && i-1 >= 0 && !allyCell(i-1,j-1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i-1)+","+(j-1));
				gameState.allowedCellsBool[i-1][j - 1] = false;
				if(allyCell(i-1,j-1, exception, enemyStart, gameState)) {
					break;
				}
				j--;
				i--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && j-1 >= 0&& !allyCell(i+1,j-1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i+1)+","+(j-1));
				gameState.allowedCellsBool[i+1][j-1] = false;
				if(allyCell(i+1,j-1, exception, enemyStart, gameState)) {
					break;
				}
				i++;
				j--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && i+1 <= 7 && !allyCell(i+1,j+1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i+1)+","+(j+1));
				gameState.allowedCellsBool[i+1][j+1] = false;
				if(allyCell(i+1,j+1, exception, enemyStart, gameState)) {
					break;
				}
				j++;
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && j+1 <= 7 && !allyCell(i-1,j+1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i-1)+","+(j+1));
				gameState.allowedCellsBool[i-1][j+1] = false;
				if(allyCell(i-1,j+1, exception, enemyStart, gameState)) {
					break;
				}
				i--;
				j++;
				iter++;
			}
		} else {
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && i-1 >= 0 && !allyCell(i-1,j-1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.print("\nDESPINTANDO: "+(i-1)+","+(j-1));
				gameState.allowedCellsBool[i-1][j - 1] = false;
				if(allyCell(i-1,j-1, idCoronado, enemyStart, gameState)) {
					break;
				}
				j--;
				i--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && j-1 >= 0 && !allyCell(i+1,j-1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.print("\nDESPINTANDO: "+(i+1)+","+(j-1));
				gameState.allowedCellsBool[i+1][j-1] = false;
				if(allyCell(i+1,j-1, idCoronado, enemyStart, gameState)) {
					break;
				}
				i++;
				j--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && i+1 <= 7 && !allyCell(i+1,j+1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.print("\nDESPINTANDO: "+(i+1)+","+(j+1));
				gameState.allowedCellsBool[i+1][j+1] = false;
				if(allyCell(i+1,j+1, idCoronado, enemyStart, gameState)) {
					break;
				}
				j++;
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && j+1 <= 7 && !allyCell(i-1,j+1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.print("\nDESPINTANDO: "+(i-1)+","+(j+1));
				gameState.allowedCellsBool[i-1][j+1] = false;
				if(allyCell(i-1,j+1, idCoronado, enemyStart, gameState)) {
					break;
				}
				i--;
				j++;
				iter++;
			}
		}
		
		
	}

	private static void horseAllowedCells(Vector2D originalPos, int exception, int allyStart, GameState gameState, int idCoronado) {
		
		int i = getZ((int)originalPos.getX());
		int j = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		if(idCoronado == -1) {
			if (i - 1 >= 0 && j - 2 >= 0 && !allyCell(i-1,j-2, exception, allyStart, gameState)) {
				gameState.allowedCellsBool[i - 1][j - 2] = true;
			}

			if (i + 1 <= 7 && j - 2 >= 0 && !allyCell(i+1,j-2, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 1][j - 2] = true;
			}

			if (i - 2 >= 0 && j - 1 >= 0 && !allyCell(i-2,j-1, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i - 2][j - 1] = true;
			}

			if (i - 2 >= 0 && j + 1 <= 7 && !allyCell(i-2,j+1, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i - 2][j + 1] = true;
			}

			if (i - 1 >= 0 && j + 2 <= 7 && !allyCell(i-1,j+2, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i - 1][j + 2] = true;
			}

			if (i + 1 <= 7 && j + 2 <= 7 && !allyCell(i+1,j+2, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 1][j + 2] = true;
			}

			if (i + 2 <= 7 && j - 1 >= 0 && !allyCell(i+2,j-1, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 2][j - 1] = true;
			}

			if (i + 2 <= 7 && j + 1 <= 7 && !allyCell(i+2,j+1, exception, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 2][j + 1] = true;
			}
		} else {
			if (i - 1 >= 0 && j - 2 >= 0 && !allyCell(i-1,j-2, idCoronado, allyStart, gameState)) {
				gameState.allowedCellsBool[i - 1][j - 2] = true;
			}

			if (i + 1 <= 7 && j - 2 >= 0 && !allyCell(i+1,j-2, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 1][j - 2] = true;
			}

			if (i - 2 >= 0 && j - 1 >= 0 && !allyCell(i-2,j-1, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i - 2][j - 1] = true;
			}

			if (i - 2 >= 0 && j + 1 <= 7 && !allyCell(i-2,j+1, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i - 2][j + 1] = true;
			}

			if (i - 1 >= 0 && j + 2 <= 7 && !allyCell(i-1,j+2, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i - 1][j + 2] = true;
			}

			if (i + 1 <= 7 && j + 2 <= 7 && !allyCell(i+1,j+2, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 1][j + 2] = true;
			}

			if (i + 2 <= 7 && j - 1 >= 0 && !allyCell(i+2,j-1, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 2][j - 1] = true;
			}

			if (i + 2 <= 7 && j + 1 <= 7 && !allyCell(i+2,j+1, idCoronado, allyStart, gameState)) {
			    gameState.allowedCellsBool[i + 2][j + 1] = true;
			}
		}

		
	}

	private static void horseDeallowCells(Vector2D originalPos, GameState gameState) {
		
		int i = Cell.getZ((int)originalPos.getX());
		int j = Cell.getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		if (i - 1 >= 0 && j - 2 >= 0) {
			gameState.allowedCellsBool[i - 1][j - 2] = false;
		}

		if (i + 1 <= 7 && j - 2 >= 0) {
		    gameState.allowedCellsBool[i + 1][j - 2] = false;
		}

		if (i - 2 >= 0 && j - 1 >= 0) {
		    gameState.allowedCellsBool[i - 2][j - 1] = false;
		}

		if (i - 2 >= 0 && j + 1 <= 7) {
		    gameState.allowedCellsBool[i - 2][j + 1] = false;
		}

		if (i - 1 >= 0 && j + 2 <= 7) {
		    gameState.allowedCellsBool[i - 1][j + 2] = false;
		}

		if (i + 1 <= 7 && j + 2 <= 7) {
		    gameState.allowedCellsBool[i + 1][j + 2] = false;
		}

		if (i + 2 <= 7 && j - 1 >= 0) {
		    gameState.allowedCellsBool[i + 2][j - 1] = false;
		}

		if (i + 2 <= 7 && j + 1 <= 7) {
		    gameState.allowedCellsBool[i + 2][j + 1] = false;
		}
		
	}

	private static void towerAllowedCells(Vector2D originalPos, int exception, int allyStart, int enemyStart, int end, boolean firstMove, GameState gameState, int idCoronado) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		/*
		System.out.println("towerAllowedCells: "+idCoronado);
		
		if(idCoronado >= 8 && idCoronado <= 15) {System.out.println("Peon Blanco");}
		else {
			if(idCoronado >= 24 && idCoronado <= 31) {System.out.println("Peon Negro");}
		}
		*/
		
		if(idCoronado == -1) {
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && !allyCell(i,j-1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+i+","+(j-1));
				gameState.allowedCellsBool[i][j - 1] = true;
				if(allyCell(i,j-1, exception, enemyStart, gameState)) {
					break;
				}
				j--;
				iter++;
				
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && !allyCell(i+1,j, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i+1)+","+j);
				gameState.allowedCellsBool[i+1][j] = true;
				if(allyCell(i+1,j, exception, enemyStart, gameState)) {
					break;
				}
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && !allyCell(i,j+1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i)+","+(j+1));
				gameState.allowedCellsBool[i][j+1] = true;
				if(allyCell(i,j+1, exception, enemyStart, gameState)) {
					break;
				}
				j++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && !allyCell(i-1,j, exception, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i-1)+","+j);
				gameState.allowedCellsBool[i-1][j] = true;
				if(allyCell(i-1,j, exception, enemyStart, gameState)) {
					break;
				}
				i--;
				iter++;
			}
		} else {
			//System.out.println("idCoronado:"+ idCoronado);
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && !allyCell(i,j-1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+i+","+(j-1));
				gameState.allowedCellsBool[i][j - 1] = true;
				if(allyCell(i,j-1, idCoronado, enemyStart, gameState)) {
					break;
				}
				j--;
				iter++;
				
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && !allyCell(i+1,j, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i+1)+","+j);
				gameState.allowedCellsBool[i+1][j] = true;
				if(allyCell(i+1,j, idCoronado, enemyStart, gameState)) {
					break;
				}
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && !allyCell(i,j+1, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i)+","+(j+1));
				gameState.allowedCellsBool[i][j+1] = true;
				if(allyCell(i,j+1, idCoronado, enemyStart, gameState)) {
					break;
				}
				j++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && !allyCell(i-1,j, idCoronado, allyStart, gameState) && iter < end) {
				//System.out.println("PINTANDO: "+(i-1)+","+j);
				gameState.allowedCellsBool[i-1][j] = true;
				if(allyCell(i-1,j, idCoronado, enemyStart, gameState)) {
					break;
				}
				i--;
				iter++;
			}
		}

		
	}

	private static void towerDeallowCells(Vector2D originalPos, int exception, int allyStart, int enemyStart, int end, GameState gameState, int idCoronado) {
		
		int iAux = getZ((int)originalPos.getX());
		int jAux = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		//System.out.println("idCoronado: "+idCoronado);
		if(idCoronado == -1) {
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && !allyCell(i,j-1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+i+","+(j-1));
				gameState.allowedCellsBool[i][j - 1] = false;
				if(allyCell(i,j-1, exception, enemyStart, gameState)) {
					break;
				}
				j--;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && !allyCell(i+1,j, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i+1)+","+j);
				gameState.allowedCellsBool[i+1][j] = false;
				if(allyCell(i+1,j, exception, enemyStart, gameState)) {
					break;
				}
				i++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && !allyCell(i,j+1, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i)+","+(j+1));
				gameState.allowedCellsBool[i][j+1] = false;
				if(allyCell(i,j+1, exception, enemyStart, gameState)) {
					break;
				}
				j++;
				iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && !allyCell(i-1,j, exception, allyStart, gameState) && iter < end) {
				//System.out.println("DESPINTANDO: "+(i-1)+","+j);
				gameState.allowedCellsBool[i-1][j] = false;
				if(allyCell(i-1,j, exception, enemyStart, gameState)) {
					break;
				}
				i--;
				iter++;
			}
		} else {
			System.out.println("towerDeAllowCells(); | coronado | idCoronado: "+idCoronado);
			int i = iAux;
			int j = jAux;
			int iter = 0;
			while(j-1 >= 0 && !allyCell(i,j-1, idCoronado, allyStart, gameState) && iter < end) {
			    //System.out.println("DESPINTANDO: "+i+","+(j-1));
			    System.out.println("Limpiando "+i+" "+(j-1));
			    gameState.allowedCellsBool[i][j - 1] = false;
			    if(allyCell(i,j-1, idCoronado, enemyStart, gameState)) {
			        break;
			    }
			    j--;
			    iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i+1 <= 7 && !allyCell(i+1,j, idCoronado, allyStart, gameState) && iter < end) {
			    //System.out.println("DESPINTANDO: "+(i+1)+","+j);
			    System.out.println("Limpiando "+(i+1)+" "+j);
			    gameState.allowedCellsBool[i+1][j] = false;
			    if(allyCell(i+1,j, idCoronado, enemyStart, gameState)) {
			        break;
			    }
			    i++;
			    iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(j+1 <= 7 && !allyCell(i,j+1, idCoronado, allyStart, gameState) && iter < end) {
			    //System.out.println("DESPINTANDO: "+(i)+","+(j+1));
			    System.out.println("Limpiando "+i+" "+(j+1));
			    gameState.allowedCellsBool[i][j+1] = false;
			    if(allyCell(i,j+1, idCoronado, enemyStart, gameState)) {
			        break;
			    }
			    j++;
			    iter++;
			}
			i = iAux;
			j = jAux;
			iter = 0;
			while(i-1 >= 0 && !allyCell(i-1,j, idCoronado, allyStart, gameState) && iter < end) {
			    //System.out.println("DESPINTANDO: "+(i-1)+","+j);
			    //System.out.println("Limpiando "+(i-1)+" "+j);
			    gameState.allowedCellsBool[i-1][j] = false;
			    if(allyCell(i-1,j, idCoronado, enemyStart, gameState)) {
			        break;
			    }
			    i--;
			    iter++;
			}

		}
		
	}
	
	private static void pawnAllowedCells(Vector2D originalPos, int exception, int allyStart, int enemyStart, boolean firstMove, GameState gameState) {
		
		int i = getZ((int)originalPos.getX());
		int j = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		switch(allyStart) {
		case 0:
			if (j-1 >= 0 && !allyCell(i,j-1,exception, allyStart, gameState) && !allyCell(i,j-1,exception, enemyStart, gameState)) {
				gameState.allowedCellsBool[i][j - 1] = true;
				if(firstMove && !allyCell(i,j-2,exception, allyStart, gameState) && !allyCell(i,j-2,exception, enemyStart, gameState)) {
					gameState.allowedCellsBool[i][j - 2] = true;
					//firstMove = false;
				}
			}
			if(j-1 >= 0 && i-1 >= 0 && allyCell(i-1,j-1,exception, enemyStart, gameState)) {
				gameState.allowedCellsBool[i-1][j - 1] = true;
			}
			if(j-1 >= 0 && i+1 <= 7 && allyCell(i+1,j-1,exception, enemyStart, gameState)) {
				gameState.allowedCellsBool[i+1][j - 1] = true;
			}
			if(i-1 >= 0 && peonCell(i-1, j, exception, enemyStart, gameState)) {
				if(gameState.getMovingObject(gameState.posicionesDelTablero[i-1][j]).isFirstMove()) {
					//System.out.println("ENEMY PAWN");
					gameState.allowedCellsBool[i-1][j - 1] = true;
				}
				
			}
			if(i+1 <= 7 && peonCell(i+1, j, exception, enemyStart, gameState)) {
				if(gameState.getMovingObject(gameState.posicionesDelTablero[i+1][j]).isFirstMove()) {
					//System.out.println("ENEMY PAWN");
					gameState.allowedCellsBool[i+1][j - 1] = true;
				}
			}
			break;
		case 16:
			if (j+1 <= 7 && !allyCell(i,j+1,exception, allyStart, gameState) && !allyCell(i,j+1,exception, enemyStart, gameState)) {
				gameState.allowedCellsBool[i][j + 1] = true;
				if(firstMove && !allyCell(i,j+2,exception, allyStart, gameState) && !allyCell(i,j+2,exception, enemyStart, gameState)) {
					gameState.allowedCellsBool[i][j + 2] = true;
					//firstMove = false;
				}
			}
			if(j+1 <= 7 && i-1 >= 0 && allyCell(i-1,j+1,exception, enemyStart, gameState)) {
				gameState.allowedCellsBool[i-1][j + 1] = true;
			}
			if(j+1 <= 7 && i+1 <= 7 && allyCell(i+1,j+1,exception, enemyStart, gameState)) {
				gameState.allowedCellsBool[i+1][j + 1] = true;
			}
			if(i-1 >= 0 && peonCell(i-1, j, exception, enemyStart, gameState)) {
				if(gameState.getMovingObject(gameState.posicionesDelTablero[i-1][j]).isFirstMove()) {
					gameState.allowedCellsBool[i-1][j + 1] = true;
					//System.out.println("ENEMY PAWN");
				}
				
			}
			if(i+1 <= 7 && peonCell(i+1, j, exception, enemyStart, gameState)) {
				//System.out.println(gameState.getMovingObject(gameState.posicionesDelTablero[i+1][j]).isFirstMove());
				if(gameState.getMovingObject(gameState.posicionesDelTablero[i+1][j]).isFirstMove()) {
					gameState.allowedCellsBool[i+1][j + 1] = true;
					//System.out.println("ENEMY PAWN");
				}
			}
			break;
		default:
		}
		
	}
	
	private static void pawnDeallowCells(Vector2D originalPos, int exception, int allyStart, boolean firstMove, GameState gameState, int piece) {
		
		int i = getZ((int)originalPos.getX());
		int j = getZ((int)originalPos.getY());
		
		//System.out.println(i);
		//System.out.println(j);
		
		switch(allyStart) {
		case 0:
			if (j-1 >= 0) {
				gameState.allowedCellsBool[i][j - 1] = false;
				if(firstMove) {
					gameState.allowedCellsBool[i][j - 2] = false;
				}
			}
			if(j-1 >= 0 && i-1 >= 0) {
				gameState.allowedCellsBool[i-1][j - 1] = false;
			}
			if(j-1 >= 0 && i+1 <= 7) {
				gameState.allowedCellsBool[i+1][j - 1] = false;
			}
			break;
		case 16:
			if (j+1 <= 7) {
				gameState.allowedCellsBool[i][j + 1] = false;
				if(firstMove) {
					gameState.allowedCellsBool[i][j + 2] = false;
				}
			}
			if(j+1 <= 7 && i-1 >= 0) {
				gameState.allowedCellsBool[i-1][j + 1] = false;
			}
			if(j+1 <= 7 && i+1 <= 7) {
				gameState.allowedCellsBool[i+1][j + 1] = false;
			}
			break;
		default:
		}
		
	}

	
	
}


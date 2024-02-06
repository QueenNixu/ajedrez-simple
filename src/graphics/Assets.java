package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage whiteKing;
	public static BufferedImage whiteQueen;
	public static BufferedImage whiteHorse;
	public static BufferedImage whiteTower;
	public static BufferedImage whiteBishop;
	public static BufferedImage whitePawn;
	
	public static BufferedImage blackKing;
	public static BufferedImage blackQueen;
	public static BufferedImage blackHorse;
	public static BufferedImage blackTower;
	public static BufferedImage blackBishop;
	public static BufferedImage blackPawn;
	
	public static void init() {
		
		whiteKing = Loader.ImageLoader("/pieces/white king.png");
		whiteQueen = Loader.ImageLoader("/pieces/white queen.png");
		whiteHorse = Loader.ImageLoader("/pieces/white horse.png");
		whiteTower = Loader.ImageLoader("/pieces/white tower.png");
		whiteBishop = Loader.ImageLoader("/pieces/white bishop.png");
		whitePawn = Loader.ImageLoader("/pieces/white pawn.png");
		
		blackKing = Loader.ImageLoader("/pieces/black king-1.png");
		blackQueen = Loader.ImageLoader("/pieces/black queen-1.png");
		blackHorse = Loader.ImageLoader("/pieces/black horse-1.png");
		blackTower = Loader.ImageLoader("/pieces/black tower-1.png");
		blackBishop = Loader.ImageLoader("/pieces/black bishop-1.png");
		blackPawn = Loader.ImageLoader("/pieces/black pawn-1.png");
		
	}

}

package marc.BracketUtils;

import java.awt.Dimension;
import java.awt.Point;

public class MatchPositions {
	
	//playerCount must be power of 2, max is 128 atm
	public static Point[][] getPlayersPositions(final int playerCount){
		switch(playerCount){
			case 128:
				return get128PlayersPositions();
			case 64:
				return get64PlayersPositions();
			case 32:
				return get32PlayersPositions();
			case 16:
				return get16PlayersPositions();
			case 8:
				return get8PlayersPositions();
			case 4:
				return get4PlayersPositions();
			case 2:
				return get2PlayersPositions();
			default:
				throw new IllegalArgumentException("'playerCount' must be a power of 2");
				
		}
	}
	
	
	private static Point[][] get2PlayersPositions() {
		int maxPlayers = 2;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		return pos;
	}


	private static Point[][] get4PlayersPositions() {
		int maxPlayers = 4;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		for(int i = 0; i < maxPlayers/4;i++ ){
			pos [2][i] = new Point(4 ,3+8*i);
		}
		
		return pos;
	}


	private static Point[][] get8PlayersPositions() {
		int maxPlayers = 8;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		for(int i = 0; i < maxPlayers/4;i++ ){
			pos [2][i] = new Point(4 ,3+8*i);
		}
		for(int i = 0; i < maxPlayers/8;i++ ){
			pos [3][i] = new Point(6 ,7+16*i);
		}
		
		return pos;
	}


	private static Point[][] get16PlayersPositions() {
		int maxPlayers = 16;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		for(int i = 0; i < maxPlayers/4;i++ ){
			pos [2][i] = new Point(4 ,3+8*i);
		}
		for(int i = 0; i < maxPlayers/8;i++ ){
			pos [3][i] = new Point(6 ,7+16*i);
		}
		for(int i = 0; i < maxPlayers/16;i++ ){
			pos [4][i] = new Point(8 ,15+32*i);
		}
		
		return pos;
	}


	private static Point[][] get32PlayersPositions() {
		int maxPlayers = 32;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		for(int i = 0; i < maxPlayers/4;i++ ){
			pos [2][i] = new Point(4 ,3+8*i);
		}
		for(int i = 0; i < maxPlayers/8;i++ ){
			pos [3][i] = new Point(6 ,7+16*i);
		}
		for(int i = 0; i < maxPlayers/16;i++ ){
			pos [4][i] = new Point(8 ,15+32*i);
		}
		for(int i = 0; i < maxPlayers/32;i++ ){
			pos [5][i] = new Point(10 ,31+64*i);
		}
		
		return pos;
	}


	private static Point[][] get64PlayersPositions() {
		int maxPlayers = 64;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		for(int i = 0; i < maxPlayers/4;i++ ){
			pos [2][i] = new Point(4 ,3+8*i);
		}
		for(int i = 0; i < maxPlayers/8;i++ ){
			pos [3][i] = new Point(6 ,7+16*i);
		}
		for(int i = 0; i < maxPlayers/16;i++ ){
			pos [4][i] = new Point(8 ,15+32*i);
		}
		for(int i = 0; i < maxPlayers/32;i++ ){
			pos [5][i] = new Point(10 ,31+64*i);
		}
		for(int i = 0; i < maxPlayers/64;i++ ){
			pos [6][i] = new Point(12 ,63+128*i);
		}
		
		return pos;
	}


	// Point[x][y]: x rows, y
	// x= z => y= 2^(z-1)
	// 128 Players => 7 rounds + 1 winner
	
	// @Dimension d size of the bracket-component to be displayed
	public static Point[][] get128PlayersPositions(){
		int maxPlayers = 128;
		Point[][] pos = new Point[8][128];
		for(int i = 0; i < maxPlayers;i++ ){
			pos [0][i] = new Point(0,2*i);
		} 
		for(int i = 0; i < maxPlayers/2;i++ ){
			pos [1][i] = new Point(2 ,1+4*i);
		}
		for(int i = 0; i < maxPlayers/4;i++ ){
			pos [2][i] = new Point(4 ,3+8*i);
		}
		for(int i = 0; i < maxPlayers/8;i++ ){
			pos [3][i] = new Point(6 ,7+16*i);
		}
		for(int i = 0; i < maxPlayers/16;i++ ){
			pos [4][i] = new Point(8 ,15+32*i);
		}
		for(int i = 0; i < maxPlayers/32;i++ ){
			pos [5][i] = new Point(10 ,31+64*i);
		}
		for(int i = 0; i < maxPlayers/64;i++ ){
			pos [6][i] = new Point(12 ,63+128*i);
		}
		for(int i = 0; i < maxPlayers/128;i++ ){
			pos [7][i] = new Point(14 ,127+256*i);
		}
		return pos;
	}
	

}

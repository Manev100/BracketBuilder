package marc.BracketUtils;

import java.awt.Dimension;
import java.awt.Point;

public class MatchPositions {
		
	// Point[x][y]: x rows, y
	// x= z => y= 2^(z-1)
	// 128 Players => 7 rounds + 1 winner
	
	// @Dimension d size of the bracket-component to be displayed
	public static Point[][] get128PlayersPositions(Dimension d){
		Point[][] pos = new Point[8][128];
		int height = (int) d.getHeight();
		int width = (int) d.getWidth();
		for(int i = 0; i < 128;i++ ){
			pos [0][i] = new Point(0,2*i*height);
		} 
		for(int i = 0; i < 64;i++ ){
			pos [1][i] = new Point(width+100 ,height+4*i*height);
		}
		for(int i = 0; i < 32;i++ ){
			pos [2][i] = new Point(2*(width+100) ,3*height+8*i*height);
		}
		for(int i = 0; i < 16;i++ ){
			pos [3][i] = new Point(3*(width+100) ,7*height+16*i*height);
		}
		for(int i = 0; i < 8;i++ ){
			pos [4][i] = new Point(4*(width+100) ,15*height+32*i*height);
		}
		for(int i = 0; i < 4;i++ ){
			pos [5][i] = new Point(5*(width+100) ,31*height+64*i*height);
		}
		for(int i = 0; i < 2;i++ ){
			pos [6][i] = new Point(6*(width+100) ,63*height+128*i*height);
		}
		for(int i = 0; i < 1;i++ ){
			pos [7][i] = new Point(7*(width+100) ,127*height+256*i*height);
		}
		return pos;
	}
	
	public static Dimension getPanelSize128Players(Dimension d){
		int height = (int) d.getHeight();
		int width = (int) d.getWidth();
		return new Dimension(7*(width+100)+width,2*127*height+height);
	}
}

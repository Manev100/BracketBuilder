package marc.main;

import marc.enums.Format;

public class PlayerMatch {
	
	private Player player1;
	private Player player2;
	private int player1Score;
	private int player2Score;
	private Format format;

	
	public PlayerMatch(final Player player1,final Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.format = Format.BO3;
		
	}
	
	public Player getPlayer1() { return player1;}
	public Player getPlayer2() {return player2;}
	public void setPlayer1(final Player player1) {this.player1 = player1;}
	public void setPlayer2(final Player player2) {this.player2 = player2;}
	public int getPlayer1Score() {return player1Score;}
	public void setPlayer1Score(int player1Score) {this.player1Score = player1Score;}
	public int getPlayer2Score() {return player2Score;}
	public void setPlayer2Score(int player2Score) {	this.player2Score = player2Score;}
	public Format getFormat() {return format;}
	public void setFormat(Format format) {	this.format = format;}
	
}

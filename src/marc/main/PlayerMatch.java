package marc.main;

public class PlayerMatch {
	
	String player1;
	String player2;
	
	public PlayerMatch() {
		this("","");
	}
	
	
	public PlayerMatch(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public String getPlayer1() { return player1;}
	public String getPlayer2() {return player2;}
	public void setPlayer1(String player1) {this.player1 = player1;}
	public void setPlayer2(String player2) {this.player2 = player2;}

}
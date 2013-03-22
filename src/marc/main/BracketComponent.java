package marc.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BracketComponent extends JPanel {
	
	PlayerMatch playerMatch;
	ImageIcon iconP1;
	ImageIcon iconP2;
	JPanel player1;
	JPanel player2;
	
	
	public BracketComponent(PlayerMatch p1) {
		setLayout(new BorderLayout());
		playerMatch	= p1;
		
		player1 = new PlayerArea(playerMatch.getPlayer1());
		player2 = new PlayerArea(playerMatch.getPlayer2());
		
		add(player1, BorderLayout.NORTH);
		add(player2, BorderLayout.SOUTH);
		
	}
	
	
	
	public PlayerMatch getPlayerMatch() {
		return playerMatch;
	}

	public void setPlayerMatch(PlayerMatch p) {
		this.playerMatch = p;
	}

	

}

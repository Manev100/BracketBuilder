package marc.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BracketComponent extends JPanel {
	
	PlayerMatch playerMatch;
	ImageIcon iconP1;
	ImageIcon iconP2;
	
	public BracketComponent(PlayerMatch p1) {
		setLayout(new BorderLayout());
		playerMatch	= p1;
		iconP1 = new ImageIcon("res/wrong.png" ,"Defaul-Icon");
		iconP2 = new ImageIcon("res/wrong.png" ,"Defaul-Icon");
		
		add(new JLabel(iconP1),BorderLayout.NORTH);
		
	}
	
	/*public void paintComponent(Graphics g){
		
		drawBorder(g);
		drawIcons(g);
		drawPlayerNames(g);
		
		
	}*/
	
	
	
	
	
	public PlayerMatch getPlayerMatch() {
		return playerMatch;
	}

	public void setPlayerMatch(PlayerMatch p) {
		this.playerMatch = p;
	}

	

}

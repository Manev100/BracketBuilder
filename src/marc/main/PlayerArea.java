package marc.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerArea extends JPanel {
	private Player player;
	
	public PlayerArea(final Player p) {
		this.player = p;
		setLayout(new BorderLayout());
		
		add(buildIcon(player.getIcon()),BorderLayout.WEST);
		add(new JTextField(player.getName(),20), BorderLayout.CENTER);
		add(new ScorePanel(player), BorderLayout.EAST);
	}

	private JLabel buildIcon(ImageIcon icon) {
		JLabel p = new JLabel(icon);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		return p;
	}
	
	private JTextField buildPlayerNameField(String name){
		JTextField field = new JFormattedTextField(name);
		
		return field;
	}


}

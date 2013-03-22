package marc.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;

public class ScorePanel extends JPanel {
	private Player player;
	private ImageIcon plusIcon;
	private ImageIcon minusIcon;
	
	public ScorePanel(final Player p) {
		this.player = p;
		plusIcon = new ImageIcon("res/add1.png");
		minusIcon = new ImageIcon("res/reduce1.png");
		setLayout(new BorderLayout());
		
		JButton plusButton = new JButton(plusIcon);
		plusButton.setMargin(new Insets(0,0,0,0));
		
		JButton minusButton = new JButton(minusIcon);
		minusButton.setMargin(new Insets(0,0,0,0));
		
		
		add(plusButton, BorderLayout.WEST);
		add(minusButton, BorderLayout.CENTER);
		JLabel jl = new JLabel("0");
		jl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		add(jl, BorderLayout.EAST);
	}

}

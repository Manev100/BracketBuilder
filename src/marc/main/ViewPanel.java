package marc.main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ViewPanel extends JPanel {

	public ViewPanel() {
		this.setLayout(null);
		setBackground(Color.CYAN);
		BracketComponent d = new BracketComponent(new PlayerMatch());
		BracketComponent e = new BracketComponent(new PlayerMatch());
		add(d);
		add(e);
		Insets insets = getInsets();
		d.setBounds(20, 0, 500, 40);
		//e.setBounds(0, 40, 500, 50);
		
	}
	/*public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.BLACK);
		BracketComponent b = new BracketComponent(new PlayerMatch(), 0,0);
		BracketComponent c = new BracketComponent(new PlayerMatch(), 0,60);
		b.paintComponent(g);
		c.paintComponent(g);
		
	}*/

}

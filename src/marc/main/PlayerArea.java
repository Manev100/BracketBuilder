package marc.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerArea extends JPanel {
	private Player player;
	PropertyChangeListener listener;
	JTextField field;
	
	public PlayerArea(final Player p) {
		this.player = p;
		setLayout(new BorderLayout());
		listener = new PropertyChangeListener(){
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				 String propertyName = evt.getPropertyName();
				 
			        if ("name".equals(propertyName)) {
			        	if(field != null){
			        		field.setText((String)evt.getNewValue());
			        		
			        	}
			        } 
			}	
		};
		
		
		add(buildIcon(player.getIcon()),BorderLayout.WEST);
		add(buildPlayerNameField(player.getName()), BorderLayout.CENTER);
		add(new ScorePanel(player), BorderLayout.EAST);
		player.addPropertyChangeListener(listener);
		
	}

	private JLabel buildIcon(ImageIcon icon) {
		JLabel p = new JLabel(icon);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		return p;
	}
	
	private JTextField buildPlayerNameField(String name){
		this.field = new JTextField(name,20);
		return this.field;
	}


}

package marc.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import marc.main.BracketModel;
import marc.main.Player;
import marc.main.ViewPanel;

public class AddPlayerListener implements ActionListener {
	
	private BracketModel model;
	private ViewPanel view;
	
	
	public AddPlayerListener(BracketModel b, ViewPanel v) {
		this.model = b;
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Type name of new player!");
		model.addPlayer(new Player(name));
		//view.refreshPlayers();
		
	}

}

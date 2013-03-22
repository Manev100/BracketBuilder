package marc.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import marc.Listeners.AddPlayerListener;

public class BracketController {
	
		private JFrame frame;
		private final Dimension startSize = new Dimension(800,600); 
		private BracketModel bracketModel;
		private ViewPanel viewPanel;
		private JButton addButton;
		private JButton deleteButton;
		private JButton editBracketButton;
		
	public BracketController(){
		frame = new JFrame("Bracket-Builder");
		bracketModel = new BracketModel();
		frame.add(createJSplitPane(), BorderLayout.CENTER);
		setup();
		
		
	}
	
	private void setup() {
		frame.setSize(startSize);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(400,200));
		frame.setExtendedState(JFrame.NORMAL);
		
	}
	private JSplitPane createJSplitPane(){
		JSplitPane p = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true);
		viewPanel = new ViewPanel(bracketModel);
		JScrollPane scrollPane = new JScrollPane(viewPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		p.setTopComponent(createTopArea());
		p.setBottomComponent(scrollPane);
		p.setEnabled(false);
		return p;
		
	}
	
	
	
	private JPanel createTopArea(){
		JPanel p = new JPanel(new BorderLayout());
		p.add(createMenuBar(), BorderLayout.NORTH);
		p.add(createTopBar(), BorderLayout.SOUTH);
		return p;
	}
	
	private JMenuBar createMenuBar(){
		JMenuBar jbar = new JMenuBar();
		
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem loadItem = new JMenuItem("Load");
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		jbar.add(fileMenu);
		
		return jbar;
	}
	
	private JToolBar createTopBar(){
		JToolBar bar = new JToolBar("Toolbar");
		bar.setFloatable(false);
		bar.setRollover(true);
		bar.add(createAddButton());
		bar.add(new JButton("Delete Player"));
		bar.addSeparator();
		bar.add(new JButton("Edit Bracket-Format"));
		
		return bar;
	}
	public void show() {
		frame.setVisible(true);
	}
	
	private JButton createAddButton(){
		addButton = new JButton("Add Player");
		addButton.addActionListener(new AddPlayerListener(bracketModel, viewPanel));
		return addButton;
	}
}

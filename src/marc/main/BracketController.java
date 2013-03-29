package marc.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import marc.Listeners.AddPlayerListener;
import marc.enums.PlayerCount;

public class BracketController {
	
		private JFrame frame;
		private final Dimension startSize = new Dimension(800,600); 
		private PlayersList bracketModel;
		private ViewPanel viewPanel;
		private JButton addButton;
		private JButton deleteButton;
		private JButton editBracketButton;
		
		
	public BracketController(){
		frame = new JFrame("Bracket-Builder");
		bracketModel = new PlayersList();
		frame.add(createJSplitPane(), BorderLayout.CENTER);
		setup();
		setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		
		
	}
	
	private void setLookAndFeel(String lookAndFeel) {
	    try {
            // Set System L&F
	    	UIManager.setLookAndFeel(lookAndFeel);
		} 
	    catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class for specified look and feel:"
                               + lookAndFeel);
            System.err.println("Did you include the L&F library in the class path?");
            System.err.println("Using the default look and feel.");
        } 
        
        catch (UnsupportedLookAndFeelException e) {
            System.err.println("Can't use the specified look and feel ("
                               + lookAndFeel
                               + ") on this platform.");
            System.err.println("Using the default look and feel.");
        } 
        
        catch (Exception e) {
            System.err.println("Couldn't get specified look and feel ("
                               + lookAndFeel
                               + "), for some reason.");
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        }
		
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
		
		
		JScrollPane scrollPane = new JScrollPane(createTable(),ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		p.setBottomComponent(scrollPane);
		p.setTopComponent(createTopArea());
		
		p.setDividerSize(0);
		p.setEnabled(false);
		return p;
	}
	
	
	private JTable createTable(){
		
		LinkedList<Player> dummyList = new LinkedList<Player>(Arrays.asList(new Player[]{new Player("1"), new Player("2"),new Player("3"), new Player("4"),new Player("5"), new Player("6")}));
		BracketTableModel model = new BracketTableModel(PlayerCount.players32, dummyList);
		
		JTable table = new JTable(model);
		table.setDefaultRenderer(JPanel.class, new BracketTableRenderer());
		table.setDefaultEditor(JPanel.class,new BracketCellEditor());
		table.setShowGrid(false);
		table.setRowMargin(0);
		table.getColumnModel().setColumnMargin(0);
		table.setRowHeight(77);
		table.setRowSelectionAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBackground(Color.CYAN);
		
		TableColumn column;
		for(int i= 0; i < model.getColumnCount() ; i++){
			column = table.getColumnModel().getColumn(i);		
			column.setPreferredWidth(250);
		}
		
		
	
		
		return table;
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
		
		JMenuItem addPlayer = new JMenuItem("Add Player");
		JMenuItem deletePlayer = new JMenuItem("Delete Player");
		JMenuItem editBracket = new JMenuItem("Edit Bracket-Format");
		JMenu edit = new JMenu("Edit");
		edit.add(addPlayer);
		edit.add(deletePlayer);
		edit.add(editBracket);
		
		jbar.add(edit);
		jbar.setVisible(true);
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

package marc.main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

public class Main {
	public static void main(String[] args){
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(createJSplitPane(), BorderLayout.CENTER);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
	}
	private static JSplitPane createJSplitPane(){
		JSplitPane p = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true);
		p.setTopComponent(createTopArea());
		p.setBottomComponent(new ViewPanel());
		p.setEnabled(false);
		return p;
		
	}
	
	
	
	private static JPanel createTopArea(){
		JPanel p = new JPanel(new BorderLayout());
		p.add(createMenuBar(), BorderLayout.NORTH);
		p.add(createTopBar(), BorderLayout.SOUTH);
		return p;
	}
	
	private static JMenuBar createMenuBar(){
		JMenuBar jbar = new JMenuBar();
		
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem loadItem = new JMenuItem("Load");
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		jbar.add(fileMenu);
		
		return jbar;
	}
	
	private static JToolBar createTopBar(){
		JToolBar bar = new JToolBar("Toolbar");
		bar.setFloatable(false);
		bar.setRollover(true);
		bar.add(new JButton("Add Player"));
		bar.add(new JButton("Delete Player"));
		bar.addSeparator();
		bar.add(new JButton("Edit Bracket-type"));
		return bar;
	}
}

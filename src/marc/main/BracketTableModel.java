package marc.main;


import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import marc.BracketUtils.MatchPositions;
import marc.enums.PlayerCount;

public class BracketTableModel extends AbstractTableModel implements TableModel {

	private int rowCount = 0;
	private int columnCount = 0;
	private String COLUMN_NAMES[];
	private JPanel field[][];
	private JPanel betweenPanel;
	private int maxPlayers;
	private PlayersList players;
	private LinkedList<BracketComponent> bracketComponents;
	
	public BracketTableModel(PlayerCount playerCount) {
		players = new PlayersList();
		setUpField(playerCount);
		
	}
	
	public BracketTableModel(PlayerCount playerCount, LinkedList<Player> list) {
		players = new PlayersList(list);
		setUpField(playerCount);
		refreshField();
		
	}

	public void refreshField() {
		Iterator<Player> playerIt = players.iterator();
		
		for(BracketComponent comp: bracketComponents){
			Player ComponentPlayer = comp.getPlayerMatch().getPlayer1();
			if(playerIt.hasNext()){
				ComponentPlayer.setName(playerIt.next().getName());
			}
			ComponentPlayer = comp.getPlayerMatch().getPlayer2();
			if(playerIt.hasNext()){
				ComponentPlayer.setName(playerIt.next().getName());
			}
		}
		
	}

	private void setUpField(PlayerCount playerCount) {
		this.maxPlayers = playerCount.getPlayerCount();
		this.COLUMN_NAMES = playerCount.getColumnNames();
		bracketComponents = new LinkedList<BracketComponent>();
		
		if((Math.log(maxPlayers)/Math.log(2)) % 1 == 0){
			rowCount = 2*maxPlayers -1;
			columnCount = (int) ((Math.log(maxPlayers)/Math.log(2))+1) *2-1;
			field = new JPanel[columnCount][rowCount];
			fillfield(field);
			betweenPanel = new JPanel();
			betweenPanel.setBackground(Color.CYAN);
		}
		else{
			throw new IllegalArgumentException("'playerCount' must be a power of 2!");
		}
		
	}

	private void fillfield(JPanel[][] f) {
		Point[][] positions = MatchPositions.getPlayersPositions(maxPlayers);
		int column;
		int row;
		for(int x = 0; x < positions.length; x++){
			for(int y = 0; y < positions[x].length;y++){
				if(positions[x][y] != null){
				column = positions[x][y].x;
				row = positions[x][y].y;	
				f[column][row] = new BracketComponent(new PlayerMatch(new Player("TBD"),new Player("TBD")));
				bracketComponents.add((BracketComponent) f[column][row]);
				}
			}
		}
	}

	@Override
	public int getColumnCount() {
		return columnCount;
	}

	@Override
	public int getRowCount() {
		return rowCount;
	}
	
	@Override
	public Class<?> getColumnClass(int ColumnIndex){
		return JPanel.class;
	}
	
	@Override
	public String getColumnName(int ColumnIndex){
		return COLUMN_NAMES[ColumnIndex];
	}
	
	@Override
	public boolean isCellEditable(int row, int column){
		return true;		
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(field[columnIndex][rowIndex]!= null)
			return field[columnIndex][rowIndex];
		else
			return betweenPanel; 
	}

}

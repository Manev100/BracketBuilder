package marc.main;


import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import marc.BracketUtils.MatchPositions;

public class BracketTableModel extends AbstractTableModel implements TableModel {

	private int rowCount = 0;
	private int columnCount = 0;
	private static final String COLUMN_NAMES[] = {"RO 128","","RO 64","","RO 32","", "RO 16","", "RO 8","", "RO 4","", "RO 2","", "Final"};
	private JPanel field[][];
	private JPanel betweenPanel;
	
	public BracketTableModel(int playerCount) {
		if((Math.log(playerCount)/Math.log(2)) % 1 == 0){
			rowCount = 2*playerCount -1;
			columnCount = (int) ((Math.log(playerCount)/Math.log(2))+1) *2-1;
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

		Point[][] positions = MatchPositions.get128PlayersPositions();
		int column;
		int row;
		for(int x = 0; x < positions.length; x++){
			for(int y = 0; y < positions[x].length;y++){
				if(positions[x][y] != null){
				column = positions[x][y].x;
				row = positions[x][y].y;	
				f[column][row] = new BracketComponent(new PlayerMatch(new Player("asd"),new Player("345")));
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

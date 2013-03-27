package marc.main;


import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class BracketTableModel extends AbstractTableModel implements TableModel {

	private int rowCount = 0;
	private int columnCount = 0;
	private static final String COLUMN_NAMES[] = {"RO 128","","RO 64","","RO 32","", "RO 16","", "RO 8","", "RO 4","", "RO 2","", "Final"};
	private JPanel field[][];
	
	
	public BracketTableModel(int playerCount) {
		if((Math.log(playerCount)/Math.log(2)) % 1 == 0){
			rowCount = 2*playerCount -1;
			columnCount = (int) ((Math.log(playerCount)/Math.log(2))+1) *2-1;
			field = new JPanel[rowCount][columnCount];
			fillfield(field);
		}
		else{
			throw new IllegalArgumentException("'playerCount' must be a power of 2!");
		}
	}

	private void fillfield(JPanel[][] f) {
		
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
		return BracketComponent.class;
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
		return field[rowIndex][columnIndex];
	}

}

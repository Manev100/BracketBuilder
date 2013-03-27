package marc.main;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class BracketCellEditor extends AbstractCellEditor implements
		TableCellEditor {
	

	public BracketCellEditor() {
	
	}

	@Override
	public Object getCellEditorValue() {
		
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		return (Component)value;
	}

}

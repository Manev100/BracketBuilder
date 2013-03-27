package marc.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import marc.BracketUtils.MatchPositions;

public class BracketTableRenderer extends DefaultTableCellRenderer {
	
	public void BracketTableRenderer(){
		
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		return (Component) table.getModel().getValueAt(row, column);
	}
	
	
	

}

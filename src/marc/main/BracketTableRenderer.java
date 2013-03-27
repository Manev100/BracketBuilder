package marc.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.DefaultCellEditor;
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
		// TODO Auto-generated method stub
		
		
		
		Point[][] positions = MatchPositions.get128PlayersPositions();
		
		for(int x = 0; x < positions.length; x++){
			for(int y = 0; y < positions[0].length;y++){
				if(positions[x][y]!= null && positions[x][y].equals(new Point(column,row))){
					BracketComponent brCmp = new BracketComponent(new PlayerMatch(new Player("asd"),new Player("345")));
					//table.getColumnModel().getColumn(x).setCellEditor(new BracketCellEditor());
					return brCmp;
				}
			}
		}
		return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
		
	}
	
	
	

}

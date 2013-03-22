package marc.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

import marc.BracketUtils.MatchPositions;

public class ViewPanel extends JPanel implements Scrollable{
		
	private BracketModel model;
	private int offsetX, offsetY;
	private int maxUnitIncrement = 5;
	
	public ViewPanel(BracketModel m) {
		setOffsetX(0);
		setOffsetY(0);
		this.model = m;
		this.setLayout(null);
		setBackground(Color.CYAN);
		BracketComponent d = new BracketComponent(new PlayerMatch(new Player(""), new Player("")));
		Insets insets = getInsets();
		Dimension size = d.getPreferredSize();
		setPreferredSize(MatchPositions.getPanelSize128Players(size));
		Point[][] positions = MatchPositions.get128PlayersPositions(size);
		for(int x=0; x< 8; x++ ){
			for(int y=0; y< 128;y++){
				if(positions[x][y] != null){
					d = new BracketComponent(new PlayerMatch(new Player("abc"), new Player("def")));
					d.setBounds((int)positions[x][y].getX()+insets.left -offsetX, (int)positions[x][y].getY()+insets.top-offsetY, size.width, size.height);
					add(d);
				}
			}
		}
		//d.setBounds(0+insets.left, 0+insets.top, size.width, size.height);
		//e.setBounds(0+insets.left, 100+insets.top, size.width, size.height);
		
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	
	// Scrollable Interface
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
            int orientation,
            int direction) {
		if (orientation == SwingConstants.HORIZONTAL)
	        return visibleRect.width - maxUnitIncrement;
	    else
	        return visibleRect.height - maxUnitIncrement;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		//Get the current position.
	    int currentPosition = 0;
	    if (orientation == SwingConstants.HORIZONTAL) {
	        currentPosition = visibleRect.x;
	    } else {
	        currentPosition = visibleRect.y;
	    }

	    //Return the number of pixels between currentPosition
	    //and the nearest tick mark in the indicated direction.
	    
	    if (direction < 0) {
	        int newPosition = currentPosition -
	                         (currentPosition / maxUnitIncrement)
	                          * maxUnitIncrement;

		    System.out.println(newPosition );
	        return (newPosition == 0) ? maxUnitIncrement : newPosition;
	    } else {
	        return ((currentPosition / maxUnitIncrement) + 1)
	                 * maxUnitIncrement
	                 - currentPosition;
	    }
	}
	
	public void setMaxUnitIncrement(int pixels) {
        maxUnitIncrement = pixels;
    }
}

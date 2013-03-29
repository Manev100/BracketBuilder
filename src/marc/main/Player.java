package marc.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;

public class Player{
	private String name;
	private ImageIcon icon;
	PropertyChangeListener listener;
	
	public Player(final String name, final ImageIcon icon ){
		this.name = name;
		this.icon = icon;	
	}
	
	public Player(final String name){
		this.name = name;
		this.icon = new ImageIcon("res/wrong.png" ,"Defaul-Icon");	
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		notifyPropertyChangeListener("name", oldName, name);
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		ImageIcon oldIcon = this.icon;
		this.icon = icon;
		notifyPropertyChangeListener("icon", oldIcon, icon);
	}
	
	private void notifyPropertyChangeListener(String name, Object oldValue, Object newValue){
		if(listener != null){
			listener.propertyChange(new PropertyChangeEvent(this, name, oldValue, newValue));
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}
	
}

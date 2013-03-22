package marc.main;

import javax.swing.ImageIcon;

public class Player {
	private String name;
	private ImageIcon icon;
	
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
		this.name = name;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}

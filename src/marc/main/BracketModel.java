package marc.main;

import java.util.LinkedList;

public class BracketModel {

	private LinkedList<Player> playerList;
	public BracketModel() {
		this.playerList = new LinkedList<Player>();
	}
	
	public void addPlayer(Player p){
		playerList.add(p);
	}
	public boolean deletePlayer(String name){
		for(Player p: playerList){
			if(p.getName().equals(name)){
				playerList.remove(p);
				return true;
			}
		}
		return false;
	}
	
	

}

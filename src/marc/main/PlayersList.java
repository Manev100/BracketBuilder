package marc.main;

import java.util.Iterator;
import java.util.LinkedList;

public class PlayersList {

	private LinkedList<Player> playerList;
	
	public PlayersList() {
		this.playerList = new LinkedList<Player>();
	}
	
	public PlayersList(LinkedList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public void addPlayer(Player p){
		playerList.add(p);
	}
	
	public void switchPlayers(int index1, int index2){
		Player temp = playerList.get(index1);
		playerList.set(index1, playerList.get(index2));
		playerList.set(index2, temp);
	}
	
	public void switchPlayers(String player1, String player2){
		int index1 = getIndex(player1);
		int index2 = getIndex(player2);
		switchPlayers(index1, index2);
	}
	
	public int getIndex(String name){
		for(int i = 0; i< playerList.size(); i++){
			if(playerList.get(i).getName().equals(name)){
				return i;
			}
		}
		throw new IllegalArgumentException("Name Not in List");
	}
	
	public Player get(int index){
		return playerList.get(index);
	}
	
	public Iterator<Player> iterator(){
		return playerList.iterator();
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

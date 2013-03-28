package marc.enums;

public enum Format {
	BO1(1),BO3(3),BO5(5),BO7(7),BO9(9);
	
	private final int maxGames;
	
	private Format(int i){
		this.maxGames = i;
	}
	public int getMaxGames(){
		return maxGames;
	}
}

package marc.main;

public enum Format {
	BO1(1),BO3(3),BO5(5),BO7(7),BO9(9);
	
	private final int maxGames;
	
	Format(int i){
		this.maxGames = i;
	}
	int getMaxGames(){
		return maxGames;
	}
}

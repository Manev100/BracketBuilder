package marc.enums;

public enum PlayerCount {
	
	players128(new String[]{"RO 128","","RO 64","","RO 32","", "RO 16","", "RO 8","", "RO 4","", "RO 2","", "Final"},128),
	players64(new String[]{"RO 64","","RO 32","", "RO 16","", "RO 8","", "RO 4","", "RO 2","", "Final"},64),
	players32(new String[]{"RO 32","", "RO 16","", "RO 8","", "RO 4","", "RO 2","", "Final"},32),
	players16(new String[]{ "RO 16","", "RO 8","", "RO 4","", "RO 2","", "Final"},16),
	players8(new String[]{ "RO 8","", "RO 4","", "RO 2","", "Final"},8),
	players4(new String[]{ "RO 4","", "RO 2","", "Final"},4),
	players2(new String[]{"RO 2","", "Final"},2);
	
	
	private final String[] columnNames;
	private int playerCount;
	
	private PlayerCount(final String[] columnNames, final int playerCount){
		this.columnNames = columnNames;
		this.playerCount = playerCount;
	}
	
	public String[] getColumnNames(){
		return columnNames;
	}
	
	public int getPlayerCount(){
		return playerCount;
	}
}

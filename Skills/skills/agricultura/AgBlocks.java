package skills.agricultura;

public enum AgBlocks {
	Trigo(59,296,295), Patata(142,392,392), Zanahoria(141,391,391), Melon(103,103,362), Calabaza(86,86,361);
	
	private int	id;
	private int	dropId;
	private int	seedId;

	private AgBlocks(int value, int drop, int seed) {
		this.id = value;
		this.dropId = drop;
		this.seedId = seed;
	}

	public int getId() {
		return this.id;
	}

	public int getDropId() {
		return dropId;
	}

	public int getSeedId() {
		return seedId;
	}
}

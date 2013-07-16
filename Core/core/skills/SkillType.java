package core.skills;

public enum SkillType {
	Mineria(100), Tala(100), Agricultura(100), Ganaderia(100), Pesca(30), Construccion(50), Herreria(50), Artesania(50), Carpinteria(50), Cocina(50), Apotecario(50), Mamposteria(50), Doma(10), Arco(10), Escudos(10), Armaduras(10), Lanzas(10), Espadas(10), Hachas(10), Mazas(10);
	
	public static SkillType getFromString(String string){
		for (SkillType skillType : values()){
			if(skillType.toString().equalsIgnoreCase(string)){
				return skillType;
			}
		}
		return null;
	}
	private int	level;

	private SkillType(int value) {
		this.level = value;
	}

	public int getLevel() {
		return this.level;
	}
}

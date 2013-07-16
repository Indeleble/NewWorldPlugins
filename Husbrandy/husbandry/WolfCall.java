package husbandry;

public enum WolfCall {
	llamar, traer;
	
	public static WolfCall getFromString(String string){
		for (WolfCall skillType : values()){
			if(skillType.toString().equalsIgnoreCase(string)){
				return skillType;
			}
		}
		return null;
	}

}

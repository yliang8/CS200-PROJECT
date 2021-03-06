public class Unit {
	private String name;
	private int combatStrength;
	
	public Unit(UNITS unit) {
		switch (unit) {
			case FOOTMAN:
				name = "FOOTMAN";
				combatStrength = 1;
				break;
			case KNIGHT:
				name = "KNIGHT";
				combatStrength = 2;
				break;
			case SHIP:
				name = "SHIP";
				combatStrength = 2;
				break;
			case SIEGE:
				name = "SIEGE";
				combatStrength = 4;
				break;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getCombatStrength(){
		return combatStrength;
	}
	
	public String toString(){
		return name;
	}
	
	public enum UNITS {
		FOOTMAN,
		KNIGHT,
		SHIP,
		SIEGE,
	}
}

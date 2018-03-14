package reflection;

public class Hero {
	public String name;
	int hp;
	int damage;
	
	public Hero() {
		
	}
	
	public Hero(String name,int hp,int damage) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
	static String copyright;
	static {
		System.out.println("初始化copyright");
		copyright="Blizzard";
	}

}

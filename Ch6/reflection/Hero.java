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
	
//	static String copyright;
//	static {
//		System.out.println("初始化copyright");
//		copyright="Blizzard";
//	}
	
	public Hero(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
//	toString原是打印物件在內存中位置，可以做修改
	public String toString() {
		return "Hero [name "+name+" ]";
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void attackHero(Hero h2) {
		System.out.println(this.name+"is attacking "+h2.name);
	}

}

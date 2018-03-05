package jdbc;

public class Hero {
	int id;
	String name;
	float hp;
	int damage;
	
	public Hero(int id,String name,float hp,int damage) {
		this.id=id;
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
	public Hero(String name,float hp,int damage) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
	public Hero() {
		
	}
}

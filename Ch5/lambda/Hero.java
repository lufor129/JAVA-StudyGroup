package lambda;

public class Hero implements Comparable<Hero>{
	
	String name;
	int hp;
	int damage;
	
	public Hero() {
		
	}
	
	public Hero(String name,int hp,int damage) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
//	Override
	public int CompareTo(Hero anotherHero) {
		if(this.damage<anotherHero.damage)
			return 1;
		else
			return 0;
	}
	
//	Override
	public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

	@Override
	public int compareTo(Hero arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

package how2interface;

public class SHero extends Hero implements Support {

	public void heal() {
		System.out.println("加血");
	}

	public void attack() {
		System.out.println("弱弱的攻擊");
	}

	public SHero() {
		super("");
		this.name = "tracer";
		this.damage = 100;
		this.hp = 150;
	}

	// Override toString()
	public String toString() {
		return "[ "+name+" damage:"+damage+" hp:"+hp+" ]";
	} 

}

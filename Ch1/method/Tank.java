package method;

public class Tank extends Hero {

	Tank(String name) {
		super(name);
	}

	Tank() {
		this("Big hammer");
	}

	public void attack() {
		System.out.println(name + " attack but seems like nobody hurt");

	}

	public void attack(Hero h1) {
		System.out.println(name + " attack " + h1.name);
		// this.attack();

	}

	public void attack(Hero h1, Hero h2) {
		System.out.println(name + " attack " + h1.name + " and " + h2.name + " at the same time");

	}
}

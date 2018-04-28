package method;

public class Relife extends Hero {

	Relife(String name, int hp, int damage) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}

	Hero revive(Hero h) {
		return new Hero(h.name, 200, 30);
	}

	public static void main(String[] args) {
		Relife mercy = new Relife("mercy", 200, 40);
		Hero s76 = new Hero("s76", 200, 50);

		while (true) {
			mercy.attackHero(s76);

			if (s76.hp <= 0)
				break;
		}
		
		s76=mercy.revive(s76);

		System.out.println(s76.damage);
	}

}

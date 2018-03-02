package method;

public class Relife extends Hero {

	Relife(String name, int hp, int damage) {
		super.name = name;
		super.hp = hp;
		super.damage = damage;
	}

	void revive(Hero h) {
		h = new Hero(h.name, 200, 40);
	}

	public static void main(String[] args) {
		Relife mercy = new Relife("mercy", 200, 40);
		Hero s76 = new Hero("s76", 200, 50);

		while (true) {
			mercy.attackHero(s76);

			if (s76.hp <= 0)
				break;
		}

		mercy.revive(s76);

		// System.out.println(s76.damage);
	}

}

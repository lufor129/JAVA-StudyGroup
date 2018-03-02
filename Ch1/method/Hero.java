package method;

public class Hero {
	String name; // 變量
	int hp;
	int armor;
	int damage;
	float movespeed;

	// 實例化一個對象時會調動建構方法，默認（）自動產生
	Hero() {
		// System.out.println("hello");
		// this("Sombra");
	}

	// 當有非（）建構，默認不會有（）自動產生
	Hero(String name) {
		// this 代表當前的物件(Hero)
		this.name = name;
	}

	Hero(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	void printThis() {
		System.out.println(this);
		System.out.println(this.name);
	}

	/*-------------類傳參-----------*/

	void attackHero(Hero hero) {
		hero.hp -= this.damage;
		System.out.println(hero.name + " left " + hero.hp);

		if (hero.hp <= 0) {
			System.out.println(hero.name + " is dead");
		}
	}

}
